package pl.dwolny.hexagonal.domain.repository;

import org.springframework.stereotype.Repository;
import pl.dwolny.hexagonal.domain.model.Payment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PaymentRepository {

	Optional<Payment> findById(UUID id);

	Payment save(Payment payment);

	void deleteById(UUID id);

	List<Payment> findAll();
}
