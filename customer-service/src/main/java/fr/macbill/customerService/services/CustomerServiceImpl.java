package fr.macbill.customerService.services;

import fr.macbill.customerService.documents.Customer;
import fr.macbill.customerService.repositories.CustomerRepository;
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
    public Optional<Customer> findById(String id, String userId) {
        return this.customerRepository.findByIdAndUserId(id, userId);
    }
}
