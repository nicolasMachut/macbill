package fr.macbill.customerService.services;

import fr.macbill.customerService.documents.Customer;

import java.util.Optional;

public interface CustomerService {

    Iterable<Customer> findAll(String sub);
    Customer save (Customer customer);
    void delete(String customerId, String userId);
    Optional<Customer> findById(String s, String id);

}
