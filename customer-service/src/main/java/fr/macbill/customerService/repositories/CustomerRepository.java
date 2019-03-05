package fr.macbill.customerService.repositories;

import fr.macbill.customerService.documents.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

    Iterable<Customer> findAllByUserId(String userId);
    Optional<Customer> findByIdAndUserId(String id, String userId);
    void deleteByIdAndUserId(String id, String userId);
}
