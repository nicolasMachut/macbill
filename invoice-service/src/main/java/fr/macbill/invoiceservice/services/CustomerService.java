package fr.macbill.invoiceservice.services;

import fr.macbill.invoiceservice.dto.CustomerDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CustomerService {

    private final WebClient.Builder webClientBuilder;

    public CustomerService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public CustomerDto getCustomerById(String customerId) {
        return this.webClientBuilder
                .build()
                .get()
                .uri("http://customer-service/customer/" + customerId)
                .retrieve()
                .bodyToMono(CustomerDto.class)
                .block();
    }
}
