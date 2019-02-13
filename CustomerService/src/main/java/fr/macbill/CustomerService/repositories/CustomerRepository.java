package fr.macbill.CustomerService.repositories;

import fr.macbill.CustomerService.documents.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
}
