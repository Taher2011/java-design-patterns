package _03_abstract_product_factory;

import _01_product.AmericanVehicle;
import _01_product.AsianVehicle;
import _01_product.EuropeanVehicle;

public abstract class AbstractVehicleFactory {
	public abstract AsianVehicle getAsianVehicle();

	public abstract EuropeanVehicle getEuropeanVehicle();

	public abstract AmericanVehicle getAmericanVehicle();
}
