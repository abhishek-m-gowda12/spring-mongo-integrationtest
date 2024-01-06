package io.abhishek.springmongointegrationtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"io.abhishek"})
public class SpringMongoIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoIntegrationApplication.class, args);
	}

}
