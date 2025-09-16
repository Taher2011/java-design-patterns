package abstract_factory.insurance._03_abstract_product_factory;

import java.util.HashMap;
import java.util.Map;

import abstract_factory.insurance._01_product.AutoInsurance;
import abstract_factory.insurance._01_product.HealthInsurance;
import abstract_factory.insurance._01_product.HomeInsurance;
import abstract_factory.insurance._04_concrete_product_factory.BasicInsuranceFactory;
import abstract_factory.insurance._04_concrete_product_factory.PremiumInsuranceFactory;

public abstract class AbstractInsuranceFactory {

	private static Map<String, AbstractInsuranceFactory> map = new HashMap<>();
	static {
		map.put("basic", new BasicInsuranceFactory());
		map.put("premium", new PremiumInsuranceFactory());
	}

	public abstract AutoInsurance autoInsurance();

	public abstract HealthInsurance healthInsurance();

	public abstract HomeInsurance homeInsurance();

	public static AbstractInsuranceFactory createFactory(String insuranceVariants) {
		return map.get(insuranceVariants);
	}
}
