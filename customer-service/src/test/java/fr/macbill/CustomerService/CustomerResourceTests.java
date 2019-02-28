package fr.macbill.CustomerService;


import com.netflix.discovery.converters.Auto;
import fr.macbill.customerService.documents.Customer;
import fr.macbill.customerService.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebFluxTest
public class CustomerResourceTests {

    @Autowired
    private WebTestClient webClient;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void findCustomerByIdIsOk () {
        Customer customer = new Customer();
        customer.setName("Nicolas");
        Mono<Customer> save = this.customerRepository.save(customer);

        this.webClient.get().uri("/customer/1").accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Customer.class)
                .isEqualTo(Objects.requireNonNull(save.block()));
    }

    @Test
    public void signupCustomer () {
        Customer customer = new Customer();

        this.webClient.post().uri("/customer").accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(customer), Customer.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Customer.class);
    }
}
