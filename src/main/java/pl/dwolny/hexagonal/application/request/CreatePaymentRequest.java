package pl.dwolny.hexagonal.application.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import pl.dwolny.hexagonal.domain.model.PaymentDetails;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {

	@NotNull
	private PaymentDetails paymentDetails;

}
