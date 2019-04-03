package fr.macbill.backend.resources;


import fr.macbill.backend.models.Customer;
import fr.macbill.backend.services.CustomerServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api")
public class CustomerResource {

    private final CustomerServiceImpl customerService;

    public CustomerResource(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public Iterable<Customer> findAll (Principal principal) {
        return this.customerService.findAll(principal.getName());
    }

    @GetMapping(path = "/customer/{id}")
    public Customer findById (@PathVariable String id, Principal principal) {
        return this.customerService.findById(id, principal.getName());
    }

    @PostMapping("/customer")
    public Customer createNewCustomer (@Valid @RequestBody Customer customer, Principal principal) {
        customer.setUserId(principal.getName());
        return this.customerService.save(customer);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer (@PathVariable(value = "id") String customerId, Principal principal) {
        this.customerService.delete(customerId, principal.getName());
    }
}
