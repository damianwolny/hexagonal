package pl.dwolny.hexagonal.infrastructure.repository.csv;

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
@ConditionalOnProperty(prefix = "db", name = "enabled", havingValue = "csv", matchIfMissing = true)
@RequiredArgsConstructor
public class CsvPaymentRepository implements PaymentRepository {

	//TODO OPEN CSV logic goes here

	@Override
	public Optional<Payment> findById(UUID id) {

		return Optional.empty();
	}

	@Override
	public Payment save(Payment payment) {

		return null;
	}

	@Override
	public void deleteById(UUID id) {

	}

	@Override
	public List<Payment> findAll() {

		return null;
	}
}
