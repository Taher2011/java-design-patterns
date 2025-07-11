package _02_concrete_product;

import _01_product.AutoInsurance;

public class BasicAutoInsurance extends AutoInsurance {

	@Override
	public void getPolicyDetails() {
		System.out.println("Basic Auto: Accidents up to $20,000");
	}
}
