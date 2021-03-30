package pl.dwolny.hexagonal.infrastructure.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.dwolny.hexagonal.domain.model.Payment;

import java.util.UUID;

@Repository
public interface SpringDataMongoPaymentRepository extends MongoRepository<Payment, UUID> {
}
