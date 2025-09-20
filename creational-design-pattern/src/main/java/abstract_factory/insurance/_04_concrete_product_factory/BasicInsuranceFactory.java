package abstract_factory.insurance._04_concrete_product_factory;

import abstract_factory.insurance._01_product.AutoInsurance;
import abstract_factory.insurance._01_product.HealthInsurance;
import abstract_factory.insurance._01_product.HomeInsurance;
import abstract_factory.insurance._02_concrete_product.BasicAutoInsurance;
import abstract_factory.insurance._02_concrete_product.BasicHealthInsurance;
import abstract_factory.insurance._02_concrete_product.BasicHomeInsurance;
import abstract_factory.insurance._03_abstract_product_factory.AbstractInsuranceFactory;

public class BasicInsuranceFactory extends AbstractInsuranceFactory {

	@Override
	public AutoInsurance createAutoInsurance() {
		return new BasicAutoInsurance();
	}

	@Override
	public HealthInsurance createHealthInsurance() {
		return new BasicHealthInsurance();
	}

	@Override
	public HomeInsurance createHomeInsurance() {
		return new BasicHomeInsurance();
	}
}
