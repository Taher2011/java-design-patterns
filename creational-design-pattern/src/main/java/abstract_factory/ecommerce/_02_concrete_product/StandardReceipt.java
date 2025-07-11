package _02_concrete_product;

import _01_product.TransactionReceipt;

public class StandardReceipt extends TransactionReceipt {

	@Override
	public void generateReceipt() {
		System.out.println("Generating basic receipt for Standard family");
	}
}
