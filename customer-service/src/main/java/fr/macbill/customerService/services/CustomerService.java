package fr.macbill.customerService.services;

import fr.macbill.customerService.documents.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<Customer> findAll ();
    Mono<Customer> save (Customer customer);
}
