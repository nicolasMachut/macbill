package fr.macbill.CustomerService.services;

import fr.macbill.CustomerService.documents.Customer;
import fr.macbill.CustomerService.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Flux<Customer> findAll () {
        return this.customerRepository.findAll();
    }

    public Mono<Customer> save (Customer customer) {
        return this.customerRepository.save(customer);
    }
}
