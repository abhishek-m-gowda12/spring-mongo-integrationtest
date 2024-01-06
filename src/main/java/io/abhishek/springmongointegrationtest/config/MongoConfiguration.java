package io.abhishek.springmongointegrationtest.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages = {"io.abhishek.springmongointegrationtest.repository"})
public class MongoConfiguration {

}
