package _04_concrete_product_factory;

import _01_product.AutoInsurance;
import _01_product.HealthInsurance;
import _01_product.HomeInsurance;
import _02_concrete_product.PremiumAutoInsurance;
import _02_concrete_product.PremiumHealthInsurance;
import _02_concrete_product.PremiumHomeInsurance;
import _03_abstract_product_factory.AbstractInsuranceFactory;

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
