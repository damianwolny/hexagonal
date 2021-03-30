package pl.dwolny.hexagonal.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CreatePaymentResponse {

	private final UUID id;
}
