package pl.dwolny.hexagonal.application.response;

import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.UUID;

@Value
@RequiredArgsConstructor
public class CreatePaymentResponse {

	private final UUID id;
}
