package fr.macbill.CustomerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableEurekaClient
@EnableReactiveMongoRepositories
@SpringBootApplication
public class CustomerServiceApplication {

	/*
	https://developer.okta.com/blog/2018/09/24/reactive-apis-with-spring-webflux
	 */

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
}

