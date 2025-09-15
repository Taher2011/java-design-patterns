package abstract_factory.ecommerce._02_concrete_product;

import abstract_factory.ecommerce._01_product.TransactionReceipt;

public class SecureReceipt extends TransactionReceipt {

	@Override
	public void generateReceipt() {
		System.out.println("Generating detailed receipt with security info for Secure family");
	}
}
