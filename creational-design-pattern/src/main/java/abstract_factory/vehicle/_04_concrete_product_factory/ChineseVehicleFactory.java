package abstract_factory.vehicle._04_concrete_product_factory;

import abstract_factory.vehicle._01_product.AmericanVehicle;
import abstract_factory.vehicle._01_product.AsianVehicle;
import abstract_factory.vehicle._01_product.EuropeanVehicle;
import abstract_factory.vehicle._02_concrete_product.StandardCanada;
import abstract_factory.vehicle._02_concrete_product.StandardChina;
import abstract_factory.vehicle._02_concrete_product.StandardFrance;
import abstract_factory.vehicle._03_abstract_product_factory.AbstractVehicleFactory;

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
