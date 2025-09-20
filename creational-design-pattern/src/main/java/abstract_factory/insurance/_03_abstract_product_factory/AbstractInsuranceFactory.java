package abstract_factory.insurance._03_abstract_product_factory;

import java.util.EnumMap;
import java.util.Map;

import abstract_factory.insurance._01_product.AutoInsurance;
import abstract_factory.insurance._01_product.HealthInsurance;
import abstract_factory.insurance._01_product.HomeInsurance;
import abstract_factory.insurance._04_concrete_product_factory.BasicInsuranceFactory;
import abstract_factory.insurance._04_concrete_product_factory.PremiumInsuranceFactory;
import abstract_factory.insurance._05_enum.PlanType;

public abstract class AbstractInsuranceFactory {

	private static Map<PlanType, AbstractInsuranceFactory> factories = new EnumMap<>(PlanType.class);
	static {
		factories.put(PlanType.BASIC, new BasicInsuranceFactory());
		factories.put(PlanType.PREMIUM, new PremiumInsuranceFactory());
	}

	public abstract AutoInsurance autoInsurance();

	public abstract HealthInsurance healthInsurance();

	public abstract HomeInsurance homeInsurance();

	public static AbstractInsuranceFactory createFactory(PlanType planType) {
		AbstractInsuranceFactory abstractInsuranceFactory = factories.get(planType);
		if (abstractInsuranceFactory == null) {
			throw new IllegalArgumentException("invalid plan type");
		}
		return abstractInsuranceFactory;
	}
}
