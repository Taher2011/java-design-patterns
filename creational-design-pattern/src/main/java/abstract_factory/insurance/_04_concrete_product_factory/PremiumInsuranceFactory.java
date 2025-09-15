package abstract_factory.insurance._04_concrete_product_factory;

import abstract_factory.insurance._01_product.AutoInsurance;
import abstract_factory.insurance._01_product.HealthInsurance;
import abstract_factory.insurance._01_product.HomeInsurance;
import abstract_factory.insurance._02_concrete_product.PremiumAutoInsurance;
import abstract_factory.insurance._02_concrete_product.PremiumHealthInsurance;
import abstract_factory.insurance._02_concrete_product.PremiumHomeInsurance;
import abstract_factory.insurance._03_abstract_product_factory.AbstractInsuranceFactory;

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
