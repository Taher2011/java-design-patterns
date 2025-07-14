package insurance._02_concrete_product;

import insurance._01_product.HomeInsurance;

public class PremiumHomeInsurance extends HomeInsurance {

	@Override
	public void getPolicyDetails() {
		System.out.println("Premium Home: Property damage up to $500,000 + Natural disaster coverage");
	}
}
