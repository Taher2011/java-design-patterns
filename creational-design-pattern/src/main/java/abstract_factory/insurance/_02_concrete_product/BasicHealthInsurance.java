package abstract_factory.insurance._02_concrete_product;

import abstract_factory.insurance._01_product.HealthInsurance;

public class BasicHealthInsurance extends HealthInsurance {

	@Override
	public void healthInsurancepolicyDeatils() {
		System.out.println("Basic Health: Hospitalization up to $50,000");
	}
}
