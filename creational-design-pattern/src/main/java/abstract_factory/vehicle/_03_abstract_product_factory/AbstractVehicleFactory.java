package abstract_factory.vehicle._03_abstract_product_factory;

import abstract_factory.vehicle._01_product.AmericanVehicle;
import abstract_factory.vehicle._01_product.AsianVehicle;
import abstract_factory.vehicle._01_product.EuropeanVehicle;

public abstract class AbstractVehicleFactory {
	public abstract AsianVehicle getAsianVehicle();

	public abstract EuropeanVehicle getEuropeanVehicle();

	public abstract AmericanVehicle getAmericanVehicle();
}
