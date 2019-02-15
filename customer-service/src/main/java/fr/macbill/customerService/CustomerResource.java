package fr.macbill.customerService;

import fr.macbill.customerService.documents.Customer;
import fr.macbill.customerService.repositories.CustomerRepository;
import fr.macbill.customerService.services.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
public class CustomerResource {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public CustomerResource(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @CrossOrigin
    @GetMapping(path = "/customers", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> findAll () {
        return this.customerRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("/customer")
    public Mono<Customer> createNewCustomer (@RequestBody Customer customer) {
        return this.customerService.save(customer);
    }
}
