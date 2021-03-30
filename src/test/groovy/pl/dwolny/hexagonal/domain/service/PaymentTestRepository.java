package pl.dwolny.hexagonal.domain.service;

import pl.dwolny.hexagonal.domain.model.Payment;
import pl.dwolny.hexagonal.domain.repository.PaymentRepository;

import java.util.UUID;

public class PaymentTestRepository extends InMemoryRepository<Payment, UUID> implements PaymentRepository {

}
