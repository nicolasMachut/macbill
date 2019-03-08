package fr.macbill.backend.resources;


import fr.macbill.backend.models.Customer;
import fr.macbill.backend.services.CustomerServiceImpl;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Map;
import java.util.Optional;

@RestController
public class CustomerResource {

    private final CustomerServiceImpl customerService;

    public CustomerResource(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public Iterable<Customer> findAll (Principal principal) {
        String userId = getUserId((OAuth2Authentication) principal);
        return this.customerService.findAll(userId);
    }

    @GetMapping(path = "/customer/{id}")
    public Optional<Customer> findAll (@PathVariable String id, Principal principal) {
        String userId = getUserId((OAuth2Authentication) principal);
        return this.customerService.findById(id, userId);
    }

    @PostMapping("/customer")
    public Customer createNewCustomer (@Valid @RequestBody Customer customer, Principal principal) {
        String userId = getUserId((OAuth2Authentication) principal);
        customer.setUserId(userId);
        return this.customerService.save(customer);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer (@PathVariable(value = "id") String customerId, Principal principal) {
        String userId = getUserId((OAuth2Authentication) principal);
        this.customerService.delete(customerId, userId);
    }

    private String getUserId(OAuth2Authentication principal) {
        OAuth2Authentication authentication = principal;
        Map<String, String> user = (Map<String, String>) authentication.getUserAuthentication().getDetails();
        return user.get("sub");
    }
}
