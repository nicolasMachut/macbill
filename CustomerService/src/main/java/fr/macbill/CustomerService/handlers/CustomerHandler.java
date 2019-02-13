package fr.macbill.CustomerService.handlers;

import fr.macbill.CustomerService.services.CustomerService;
import fr.macbill.CustomerService.services.CustomerServiceImpl;
import fr.macbill.CustomerService.documents.Customer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class CustomerHandler {

    private final CustomerService customerService;

    public CustomerHandler(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<Customer> customer = request.bodyToMono(Customer.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(customer.flatMap(customerService::save), Customer.class));
    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(customerService.findAll(), Customer.class);
    }


}
