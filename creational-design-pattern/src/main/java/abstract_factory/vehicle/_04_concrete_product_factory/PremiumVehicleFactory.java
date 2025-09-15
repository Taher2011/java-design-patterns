package abstract_factory.vehicle._04_concrete_product_factory;

import abstract_factory.vehicle._01_product.AmericanVehicle;
import abstract_factory.vehicle._01_product.AsianVehicle;
import abstract_factory.vehicle._01_product.EuropeanVehicle;
import abstract_factory.vehicle._02_concrete_product.PremiumAmerica;
import abstract_factory.vehicle._02_concrete_product.PremiumEngland;
import abstract_factory.vehicle._02_concrete_product.PremiumIndian;
import abstract_factory.vehicle._03_abstract_product_factory.AbstractVehicleFactory;

public class PremiumVehicleFactory extends AbstractVehicleFactory {

	@Override
	public AsianVehicle getAsianVehicle() {
		return new PremiumIndian();
	}

	@Override
	public EuropeanVehicle getEuropeanVehicle() {
		return new PremiumEngland();
	}

	@Override
	public AmericanVehicle getAmericanVehicle() {
		return new PremiumAmerica();
	}

}
