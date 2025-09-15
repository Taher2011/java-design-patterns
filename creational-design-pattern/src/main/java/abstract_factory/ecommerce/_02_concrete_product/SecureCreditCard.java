package abstract_factory.ecommerce._02_concrete_product;

import abstract_factory.ecommerce._01_product.PaymentMethod;

public class SecureCreditCard extends PaymentMethod {

	@Override
	public void processPayment() {
		System.out.println("Processing credit card payment with extra security");
	}
}
