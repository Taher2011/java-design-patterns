package abstract_factory.insurance._02_concrete_product;

import abstract_factory.insurance._01_product.AutoInsurance;

public class BasicAutoInsurance extends AutoInsurance {

	@Override
	public void autoInsurancepolicyDeatils() {
		System.out.println("Basic Auto: Accidents up to $20,000");
	}
}
