package _02_concrete_product;

import _01_product.PaymentMethod;

public class StandardUPI extends PaymentMethod {

	@Override
	public void processPayment() {
		System.out.println("Processing basic UPI payment");
	}
}
