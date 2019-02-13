package fr.macbill.CustomerService.services;

import fr.macbill.CustomerService.documents.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<Customer> findAll ();
    Mono<Customer> save (Customer customer);
}
