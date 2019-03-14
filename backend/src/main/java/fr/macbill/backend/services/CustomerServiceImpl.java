package fr.macbill.backend.services;

import fr.macbill.backend.models.Customer;
import fr.macbill.backend.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Iterable<Customer> findAll(String userId) {
        return this.customerRepository.findAllByUserId(userId);
    }

    public Customer save (Customer customer) {
        return this.customerRepository.save(customer);
    }
    public void delete(String customerId, String userId) {
        this.customerRepository.deleteByIdAndUserId(customerId, userId);
    }

    @Override
    public Customer findById(String customerId, String userId) {
        return this.customerRepository.findByIdAndUserId(customerId, userId);
    }
}
