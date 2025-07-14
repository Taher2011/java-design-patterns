package vehicle._04_concrete_product_factory;

import vehicle._01_product.AmericanVehicle;
import vehicle._01_product.AsianVehicle;
import vehicle._01_product.EuropeanVehicle;
import vehicle._02_concrete_product.StandardCanada;
import vehicle._02_concrete_product.StandardChina;
import vehicle._02_concrete_product.StandardFrance;
import vehicle._03_abstract_product_factory.AbstractVehicleFactory;

public class StandardVehicleFactory extends AbstractVehicleFactory {

	@Override
	public AsianVehicle getAsianVehicle() {
		return new StandardChina();
	}

	@Override
	public EuropeanVehicle getEuropeanVehicle() {
		return new StandardFrance();
	}

	@Override
	public AmericanVehicle getAmericanVehicle() {
		return new StandardCanada();
	}
}
