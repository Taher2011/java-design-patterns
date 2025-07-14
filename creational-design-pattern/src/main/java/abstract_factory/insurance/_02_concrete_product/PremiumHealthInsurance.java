package insurance._02_concrete_product;

import insurance._01_product.HealthInsurance;

public class PremiumHealthInsurance extends HealthInsurance {

	@Override
	public void getPolicyDetails() {
		System.out.println("Premium Health: Hospitalization up to $200,000 + Outpatient care");
	}
}
