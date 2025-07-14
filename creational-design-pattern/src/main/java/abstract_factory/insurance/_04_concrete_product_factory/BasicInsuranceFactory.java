package insurance._04_concrete_product_factory;

import insurance._01_product.AutoInsurance;
import insurance._01_product.HealthInsurance;
import insurance._01_product.HomeInsurance;
import insurance._02_concrete_product.BasicAutoInsurance;
import insurance._02_concrete_product.BasicHealthInsurance;
import insurance._02_concrete_product.BasicHomeInsurance;
import insurance._03_abstract_product_factory.AbstractInsuranceFactory;

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
