package _02_concrete_product;

import _01_product.PaymentMethod;

public class StandardPayPal extends PaymentMethod {

	@Override
	public void processPayment() {
		System.out.println("Processing basic PayPal payment");
	}
}
