package pl.dwolny.hexagonal.application.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.dwolny.hexagonal.domain.model.PaymentDetails;

@Getter
@AllArgsConstructor
public class CreatePaymentRequest {

	private PaymentDetails paymentDetails;

}
