package insurance._04_concrete_product_factory;

import insurance._01_product.AutoInsurance;
import insurance._01_product.HealthInsurance;
import insurance._01_product.HomeInsurance;
import insurance._02_concrete_product.PremiumAutoInsurance;
import insurance._02_concrete_product.PremiumHealthInsurance;
import insurance._02_concrete_product.PremiumHomeInsurance;
import insurance._03_abstract_product_factory.AbstractInsuranceFactory;

public class PremiumInsuranceFactory extends AbstractInsuranceFactory {

	@Override
	public AutoInsurance autoInsurance() {
		return new PremiumAutoInsurance();
	}

	@Override
	public HealthInsurance healthInsurance() {
		return new PremiumHealthInsurance();
	}

	@Override
	public HomeInsurance homeInsurance() {
		return new PremiumHomeInsurance();
	}
}
