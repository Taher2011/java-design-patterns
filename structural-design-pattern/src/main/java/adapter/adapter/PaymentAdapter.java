package adapter.adapter;

import adapter.adaptee.PaymentDTO;
import adapter.adaptee.ThirdPartyPaymentGateway;
import adapter.target.PaymentProcessor;
import adapter.target.PaymentProcessorDTO;

public class PaymentAdapter implements PaymentProcessor {

	private ThirdPartyPaymentGateway gateway;

	public PaymentAdapter(ThirdPartyPaymentGateway gateway) {
		this.gateway = gateway;
	}

	@Override
	public void processPayment(PaymentProcessorDTO paymentProcessorDTO) {
		PaymentDTO paymentDTO = PaymentDTO.builder().orderId(paymentProcessorDTO.getTxnOrderReference())
				.amount(paymentProcessorDTO.getTotalAmount()).customerId(paymentProcessorDTO.getUserIdentifier())
				.name(paymentProcessorDTO.getFirstName() + " " + paymentProcessorDTO.getLastName())
				.email(paymentProcessorDTO.getContactEmail())
				.createdDate(paymentProcessorDTO.getPaymentRequestTimestamp())
				.paymentMode(paymentProcessorDTO.getPaymentChannel()).status(paymentProcessorDTO.getPaymentStatus())
				.description(paymentProcessorDTO.getTxnNarration()).build();
		gateway.makePayment(paymentDTO);
	}

}
