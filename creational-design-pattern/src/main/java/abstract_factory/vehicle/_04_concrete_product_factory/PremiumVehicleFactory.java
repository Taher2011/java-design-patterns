package _04_concrete_product_factory;

import _01_product.AmericanVehicle;
import _01_product.AsianVehicle;
import _01_product.EuropeanVehicle;
import _02_concrete_product.PremiumAmerica;
import _02_concrete_product.PremiumEngland;
import _02_concrete_product.PremiumIndian;
import _03_abstract_product_factory.AbstractVehicleFactory;

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
