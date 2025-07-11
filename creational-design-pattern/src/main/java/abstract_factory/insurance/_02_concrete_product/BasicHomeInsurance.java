package _02_concrete_product;

import _01_product.HomeInsurance;

public class BasicHomeInsurance extends HomeInsurance {

	@Override
	public void getPolicyDetails() {
		System.out.println("Basic Home: Property damage up to $100,000");
	}
}