package adapter.target;

public class DefaultPaymentProcessor implements PaymentProcessor {

	@Override
	public void processPayment(PaymentProcessorDTO paymentDTO) {
		System.out.println("Processing payment of $" + paymentDTO.getTotalAmount() + " for customerId "
				+ paymentDTO.getUserIdentifier() + " on date " + paymentDTO.getPaymentRequestTimestamp()
				+ " with description : " + paymentDTO.getTxnNarration());
	}
}
