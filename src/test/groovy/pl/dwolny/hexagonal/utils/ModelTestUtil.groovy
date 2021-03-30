package pl.dwolny.hexagonal.utils

import pl.dwolny.hexagonal.application.request.CreatePaymentRequest
import pl.dwolny.hexagonal.domain.model.PaymentDetails

class ModelTestUtil {

	static def getCreatePaymentSampleRequest() {

		return new CreatePaymentRequest(new PaymentDetails(
				BigDecimal.TEN,
				"PLN",
				1L,
				"66249010441591015925023032"))
	}
}
