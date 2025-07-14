package vehicle._03_abstract_product_factory;

import vehicle._01_product.AmericanVehicle;
import vehicle._01_product.AsianVehicle;
import vehicle._01_product.EuropeanVehicle;

public abstract class AbstractVehicleFactory {
	public abstract AsianVehicle getAsianVehicle();

	public abstract EuropeanVehicle getEuropeanVehicle();

	public abstract AmericanVehicle getAmericanVehicle();
}
