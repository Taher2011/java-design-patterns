package _02_concrete_product;

import _01_product.FraudCheck;

public class SecureFraudCheck extends FraudCheck {

	@Override
	public void checkFraud() {
		System.out.println("Performing advanced fraud detection for Secure family");
	}
}
