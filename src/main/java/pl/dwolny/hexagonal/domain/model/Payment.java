package pl.dwolny.hexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Payment {

	private UUID id;
	private PaymentDetails paymentDetails;
}
