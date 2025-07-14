package ecommerce._02_concrete_product;

import ecommerce._01_product.FraudCheck;

public class StandardFraudCheck extends FraudCheck {

	@Override
	public void checkFraud() {
		System.out.println("Performing basic fraud detection for Standard family");
	}
}
