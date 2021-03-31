package pl.dwolny.hexagonal.infrastructure.repository.mongo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import pl.dwolny.hexagonal.domain.model.Payment;
import pl.dwolny.hexagonal.domain.repository.PaymentRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Adapter
@Component
@ConditionalOnProperty(prefix = "db", name = "enabled", havingValue = "mongo")
@RequiredArgsConstructor
public class MongoDbPaymentRepository implements PaymentRepository {

	private final SpringDataMongoPaymentRepository paymentRepository;

	@Override
	public Optional<Payment> findById(UUID id) {

		return paymentRepository.findById(id);
	}

	@Override
	public Payment save(Payment payment) {

		return paymentRepository.save(payment);
	}

	@Override
	public void deleteById(UUID id) {

		paymentRepository.deleteById(id);
	}

	@Override
	public List<Payment> findAll() {

		return paymentRepository.findAll();
	}
}
