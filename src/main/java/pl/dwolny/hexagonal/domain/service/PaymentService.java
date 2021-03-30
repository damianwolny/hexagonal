package pl.dwolny.hexagonal.domain.service;

import org.springframework.stereotype.Service;
import pl.dwolny.hexagonal.application.request.CreatePaymentRequest;
import pl.dwolny.hexagonal.application.request.UpdatePaymentRequest;
import pl.dwolny.hexagonal.application.response.CreatePaymentResponse;
import pl.dwolny.hexagonal.domain.model.Payment;
import pl.dwolny.hexagonal.domain.repository.PaymentRepository;

import java.util.List;
import java.util.UUID;

@Service //Spring magic to simplify the architecture, ideally service should don't know anything abt dependency injection framework
public class PaymentService {  //Can Implement some interface if we plan to have multiple implementation of below logic

	private final PaymentRepository paymentRepository;

	public PaymentService(final PaymentRepository paymentRepository) {

		this.paymentRepository = paymentRepository;
	}

	public Payment getPayment(UUID id) {

		return paymentRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Payment with given id doesn't exist"));
	}

	public void deletePayment(UUID id) {

		paymentRepository.deleteById(id);
	}

	public CreatePaymentResponse createPayment(CreatePaymentRequest createPaymentRequest) {

		final Payment payment = new Payment(UUID.randomUUID(), createPaymentRequest.getPaymentDetails());
		paymentRepository.save(payment);

		return new CreatePaymentResponse(payment.getId());
	}

	public Payment updatePayment(UpdatePaymentRequest updatePaymentRequest) {

		Payment payment = paymentRepository
				.findById(updatePaymentRequest.getPayment().getId())
				.orElseThrow(() -> new RuntimeException("Payment with given id doesn't exist"));

		//Efficient only if we consider domain object as an entity and number fields to update is relatively small
		//In other cases such as relational databases we have to provide here for example DTO pattern with MapStruct mapping
		payment.setPaymentDetails(updatePaymentRequest.getPayment().getPaymentDetails());

		paymentRepository.save(payment);

		return payment;
	}

	public List<Payment> getAllPayments() {

		return paymentRepository.findAll();
	}
}
