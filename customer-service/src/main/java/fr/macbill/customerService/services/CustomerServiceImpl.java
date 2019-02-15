package fr.macbill.customerService.services;

import fr.macbill.customerService.documents.Customer;
import fr.macbill.customerService.repositories.CustomerRepository;
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
    public Mono<Void> delete (Customer customer) {
        return this.customerRepository.delete(customer);
    }

    @Override
    public Mono<Customer> findById(String id) {
        return this.customerRepository.findById(id);
    }
}
