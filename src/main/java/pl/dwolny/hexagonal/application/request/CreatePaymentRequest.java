package pl.dwolny.hexagonal.application.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dwolny.hexagonal.domain.model.PaymentDetails;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {

	private PaymentDetails paymentDetails;

}
