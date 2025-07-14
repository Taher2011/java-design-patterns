package insurance._02_concrete_product;

import insurance._01_product.AutoInsurance;

public class BasicAutoInsurance extends AutoInsurance {

	@Override
	public void getPolicyDetails() {
		System.out.println("Basic Auto: Accidents up to $20,000");
	}
}
