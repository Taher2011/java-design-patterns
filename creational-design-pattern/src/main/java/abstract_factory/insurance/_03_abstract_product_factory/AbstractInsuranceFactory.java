package abstract_factory.insurance._03_abstract_product_factory;

import abstract_factory.insurance._01_product.AutoInsurance;
import abstract_factory.insurance._01_product.HealthInsurance;
import abstract_factory.insurance._01_product.HomeInsurance;

public abstract class AbstractInsuranceFactory {

	public abstract AutoInsurance autoInsurance();

	public abstract HealthInsurance healthInsurance();

	public abstract HomeInsurance homeInsurance();
}
