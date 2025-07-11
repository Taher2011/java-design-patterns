package _04_concrete_product_factory;

import _01_product.AmericanVehicle;
import _01_product.AsianVehicle;
import _01_product.EuropeanVehicle;
import _02_concrete_product.StandardCanada;
import _02_concrete_product.StandardChina;
import _02_concrete_product.StandardFrance;
import _03_abstract_product_factory.AbstractVehicleFactory;

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
