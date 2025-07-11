package _04_concrete_product_factory;

import _01_product.AutoInsurance;
import _01_product.HealthInsurance;
import _01_product.HomeInsurance;
import _02_concrete_product.BasicAutoInsurance;
import _02_concrete_product.BasicHealthInsurance;
import _02_concrete_product.BasicHomeInsurance;
import _03_abstract_product_factory.AbstractInsuranceFactory;

public class BasicInsuranceFactory extends AbstractInsuranceFactory {

	@Override
	public AutoInsurance autoInsurance() {
		return new BasicAutoInsurance();
	}

	@Override
	public HealthInsurance healthInsurance() {
		return new BasicHealthInsurance();
	}

	@Override
	public HomeInsurance homeInsurance() {
		return new BasicHomeInsurance();
	}
}
