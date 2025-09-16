package abstract_factory.insurance._02_concrete_product;

import abstract_factory.insurance._01_product.HomeInsurance;

public class BasicHomeInsurance extends HomeInsurance {

	@Override
	public void homeInsurancepolicyDeatils() {
		System.out.println("Basic Home: Property damage up to $100,000");
	}
}