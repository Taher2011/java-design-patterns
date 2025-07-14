package vehicle._04_concrete_product_factory;

import vehicle._01_product.AmericanVehicle;
import vehicle._01_product.AsianVehicle;
import vehicle._01_product.EuropeanVehicle;
import vehicle._02_concrete_product.PremiumAmerica;
import vehicle._02_concrete_product.PremiumEngland;
import vehicle._02_concrete_product.PremiumIndian;
import vehicle._03_abstract_product_factory.AbstractVehicleFactory;

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
