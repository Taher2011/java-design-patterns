package insurance._03_abstract_product_factory;

import insurance._01_product.AutoInsurance;
import insurance._01_product.HealthInsurance;
import insurance._01_product.HomeInsurance;

public abstract class AbstractInsuranceFactory {

	public abstract AutoInsurance autoInsurance();

	public abstract HealthInsurance healthInsurance();

	public abstract HomeInsurance homeInsurance();
}
