package fr.macbill.backend.services;


import fr.macbill.backend.models.Customer;

import java.util.Optional;

public interface CustomerService {

    Iterable<Customer> findAll(String sub);
    Customer save (Customer customer);
    void delete(String customerId, String userId);
    Optional<Customer> findById(String s, String id);

}
