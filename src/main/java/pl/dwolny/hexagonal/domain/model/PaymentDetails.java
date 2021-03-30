package pl.dwolny.hexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetails {

	private BigDecimal amount;
	private String currency; //Ideally should be some Enum value
	private Long userId;
	private String accountNumber;
}
