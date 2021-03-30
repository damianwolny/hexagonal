package pl.dwolny.hexagonal.infrastructure.repository.mongo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import pl.dwolny.hexagonal.infrastructure.repository.mongo.SpringDataMongoPaymentRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses = SpringDataMongoPaymentRepository.class)
public class MongoDBConfiguration {

}
