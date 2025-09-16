package abstract_factory.insurance._02_concrete_product;

import abstract_factory.insurance._01_product.HomeInsurance;

public class PremiumHomeInsurance extends HomeInsurance {

	@Override
	public void homeInsurancepolicyDeatils() {
		System.out.println("Premium Home: Property damage up to $500,000 + Natural disaster coverage");
	}
}
