package pl.dwolny.hexagonal.application.request;

import lombok.AllArgsConstructor;
import lombok.Value;
import pl.dwolny.hexagonal.domain.model.Payment;

@Value
@AllArgsConstructor
public class UpdatePaymentRequest {

	private final Payment payment;

}
