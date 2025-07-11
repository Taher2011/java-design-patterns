package _03_abstract_product_factory;

import _01_product.AutoInsurance;
import _01_product.HealthInsurance;
import _01_product.HomeInsurance;

public abstract class AbstractInsuranceFactory {

	public abstract AutoInsurance autoInsurance();

	public abstract HealthInsurance healthInsurance();

	public abstract HomeInsurance homeInsurance();
}
