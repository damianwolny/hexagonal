package pl.dwolny.hexagonal.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dwolny.hexagonal.application.request.CreatePaymentRequest;
import pl.dwolny.hexagonal.application.request.UpdatePaymentRequest;
import pl.dwolny.hexagonal.application.response.CreatePaymentResponse;
import pl.dwolny.hexagonal.domain.model.Payment;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PaymentFacade {

	//Multiple dependencies goes here
	//In that simple case facade is obviously a redundant abstraction layer

	private final PaymentService paymentService;

	public Payment getPayment(final UUID id) {

		return paymentService.getPayment(id);
	}

	public void deletePayment(UUID id) {

		paymentService.deletePayment(id);
	}

	public CreatePaymentResponse createPayment(CreatePaymentRequest createPaymentRequest) {

		return paymentService.createPayment(createPaymentRequest);
	}

	public Payment updatePayment(UpdatePaymentRequest updatePaymentRequest) {

		return paymentService.updatePayment(updatePaymentRequest);

	}

	public List<Payment> getAllPayments() {

		return paymentService.getAllPayments();
	}
}
