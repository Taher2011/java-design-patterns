package _02_concrete_product;

import _01_product.PaymentMethod;

public class SecureUPI extends PaymentMethod {

	@Override
	public void processPayment() {
		System.out.println("Processing UPI payment with extra security");
	}
}
