package insurance._02_concrete_product;

import insurance._01_product.AutoInsurance;

public class PremiumAutoInsurance extends AutoInsurance {

	@Override
	public void getPolicyDetails() {
		System.out.println("Premium Auto: Accidents up to $100,000 + Roadside assistance");
	}
}
