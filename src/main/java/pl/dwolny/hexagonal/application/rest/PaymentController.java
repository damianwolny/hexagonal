package pl.dwolny.hexagonal.application.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.dwolny.hexagonal.application.request.CreatePaymentRequest;
import pl.dwolny.hexagonal.application.request.UpdatePaymentRequest;
import pl.dwolny.hexagonal.application.response.CreatePaymentResponse;
import pl.dwolny.hexagonal.domain.model.Payment;
import pl.dwolny.hexagonal.domain.service.PaymentFacade;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

	private final PaymentFacade facade;

	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public CreatePaymentResponse create(@RequestBody CreatePaymentRequest createPaymentRequest) {

		return facade.createPayment(createPaymentRequest);
	}

	@GetMapping(
			value = "/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Payment get(@PathVariable("id") final UUID id) {

		return facade.getPayment(id);
	}

	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Payment update(@RequestBody UpdatePaymentRequest createPaymentRequest) {

		return facade.updatePayment(createPaymentRequest);
	}

	@DeleteMapping(
			value = "/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePayment(@PathVariable final UUID id) {

		facade.deletePayment(id);
	}

	@GetMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	//Response type depends on payments quantity, for large number it's better to use paging or HTTP Streaming
	public List<Payment> getAllPayments() {

		return facade.getAllPayments();
	}

}
