package pl.dwolny.hexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class PaymentDetails {

	private BigDecimal amount;
	private String currency; //Ideally should be some Enum value
	private Long userId;
	private String accountNumber;
}
