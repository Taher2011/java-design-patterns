package abstract_factory.ecommerce._02_concrete_product;

import abstract_factory.ecommerce._01_product.FraudCheck;

public class SecureFraudCheck extends FraudCheck {

	@Override
	public void checkFraud() {
		System.out.println("Performing advanced fraud detection for Secure family");
	}
}
