package _02_concrete_product;

import _01_product.AutoInsurance;

public class PremiumAutoInsurance extends AutoInsurance {

	@Override
	public void getPolicyDetails() {
		System.out.println("Premium Auto: Accidents up to $100,000 + Roadside assistance");
	}
}
