package abstract_factory.insurance._02_concrete_product;

import abstract_factory.insurance._01_product.HealthInsurance;

public class PremiumHealthInsurance extends HealthInsurance {

	@Override
	public void healthInsurancepolicyDeatils() {
		System.out.println("Premium Health: Hospitalization up to $200,000 + Outpatient care");
	}
}
