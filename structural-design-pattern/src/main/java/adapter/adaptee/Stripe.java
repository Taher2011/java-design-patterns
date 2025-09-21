package adapter.adaptee;

public class Stripe implements ThirdPartyPaymentGateway {

	@Override
	public void makePayment(PaymentDTO paymentDTO) {
		System.out.println("Stripe gateway processing payment of Rs." + paymentDTO.getAmount() + " for custId "
				+ paymentDTO.getCustomerId() + " name " + paymentDTO.getName() + " and payment mode was "
				+ paymentDTO.getPaymentMode());
	}

}
