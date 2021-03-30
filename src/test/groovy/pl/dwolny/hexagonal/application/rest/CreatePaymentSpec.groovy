package pl.dwolny.hexagonal.application.rest

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.json.JsonOutput
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import pl.dwolny.hexagonal.application.response.CreatePaymentResponse
import pl.dwolny.hexagonal.domain.service.PaymentFacade
import pl.dwolny.hexagonal.utils.ModelTestUtil
import spock.lang.Specification
import spock.mock.DetachedMockFactory

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

@WebMvcTest(controllers = [PaymentController])
@AutoConfigureMockMvc
class CreatePaymentSpec extends Specification {

	@Autowired
	protected MockMvc mvc

	@Autowired
	PaymentFacade facade

	@Autowired
	ObjectMapper objectMapper

	def "should pass payment details to domain component and return 'created' status"() {

		given:
			def request = ModelTestUtil.createPaymentSampleRequest

		and:
			UUID uuid = UUID.randomUUID()
			facade.createPayment(request) >> new CreatePaymentResponse(uuid)

		when:
			def response = mvc.perform(post('/payments')
					.contentType(MediaType.APPLICATION_JSON)
					.content(JsonOutput.toJson(request)))
					.andReturn()
					.response

		then:
			response.status == HttpStatus.CREATED.value()

		and:
			with(objectMapper.readValue(response.contentAsString, Map)) {
				it.id == uuid.toString()
			}
	}

	@TestConfiguration
	static class StubConfig {
		DetachedMockFactory detachedMockFactory = new DetachedMockFactory()

		@Bean
		PaymentFacade paymentFacade() {
			return detachedMockFactory.Stub(PaymentFacade)
		}
	}
}
