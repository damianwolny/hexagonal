package pl.dwolny.hexagonal.domain.service

import pl.dwolny.hexagonal.application.request.CreatePaymentRequest
import pl.dwolny.hexagonal.application.response.CreatePaymentResponse
import pl.dwolny.hexagonal.domain.repository.PaymentRepository
import pl.dwolny.hexagonal.utils.ModelTestUtil
import spock.lang.Specification
import spock.lang.Subject

class PaymentServiceTest extends Specification {

    PaymentRepository paymentRepository = new PaymentTestRepository()

    @Subject
    PaymentService paymentService = new PaymentService(paymentRepository)

    def "should create payment"() {

        given:
        CreatePaymentRequest request = ModelTestUtil.createPaymentSampleRequest

        when:
        CreatePaymentResponse response = paymentService.createPayment(request)

        then:
		paymentRepository.findById(response.getId()).isPresent()
		def createdPayment = paymentRepository.findById(response.getId()).get()

		createdPayment.id != null
		createdPayment.paymentDetails.accountNumber == request.paymentDetails.accountNumber
		createdPayment.paymentDetails.currency == request.paymentDetails.currency
		createdPayment.paymentDetails.userId == request.paymentDetails.userId

    }
}
