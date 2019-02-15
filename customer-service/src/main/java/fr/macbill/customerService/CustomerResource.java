package fr.macbill.customerService;

import fr.macbill.customerService.documents.Customer;
import fr.macbill.customerService.repositories.CustomerRepository;
import fr.macbill.customerService.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
public class CustomerResource {

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public Flux<Customer> findAll () {
        return this.customerService.findAll();
    }

    @PostMapping("/customer")
    public Mono<Customer> createNewCustomer (@RequestBody Customer customer) {
        return this.customerService.save(customer);
    }

    @DeleteMapping("/customer/{id}")
    public Mono<ResponseEntity<Void>> deleteCustomer (@PathVariable(value = "id") String customerId) {
        return this.customerService.findById(customerId)
                .flatMap(existingCustomer ->
                        customerService.delete(existingCustomer)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
