package ecommerce._02_concrete_product;

import ecommerce._01_product.PaymentMethod;

public class StandardCreditCard extends PaymentMethod {

	@Override
	public void processPayment() {
		System.out.println("Processing basic credit card payment");
	}
}
