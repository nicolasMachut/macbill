package fr.macbill.workdayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableEurekaClient
@SpringBootApplication
public class WorkDayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkDayServiceApplication.class, args);
	}

}
