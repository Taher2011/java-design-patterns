package _02_concrete_product;

import _01_product.PaymentMethod;

public class SecurePayPal extends PaymentMethod {

	@Override
	public void processPayment() {
		System.out.println("Processing PayPal with extra security");
	}
}
