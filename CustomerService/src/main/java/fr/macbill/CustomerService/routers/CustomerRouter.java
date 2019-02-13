package fr.macbill.CustomerService.routers;

import fr.macbill.CustomerService.handlers.CustomerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class CustomerRouter {

    @Bean
    public RouterFunction<ServerResponse> route(CustomerHandler handler) {
        return RouterFunctions
                .route(GET("/customers").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(POST("/customer").and(accept(MediaType.APPLICATION_JSON)), handler::save);
    }
}
