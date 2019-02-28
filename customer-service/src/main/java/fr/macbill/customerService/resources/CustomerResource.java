package fr.macbill.customerService.resources;

import fr.macbill.customerService.documents.Customer;
import fr.macbill.customerService.services.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@CrossOrigin
@RestController
public class CustomerResource {

    private final CustomerServiceImpl customerService;

    public CustomerResource(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public Flux<Customer> findAll () {
        return this.customerService.findAll();
    }

    @GetMapping(path = "/customer/{id}")
    public Mono<Customer> findAll (@PathVariable String id) {
        return this.customerService.findById(id);
    }

    @PostMapping("/customer")
    public Mono<Customer> createNewCustomer (@Valid @RequestBody Customer customer) {
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
