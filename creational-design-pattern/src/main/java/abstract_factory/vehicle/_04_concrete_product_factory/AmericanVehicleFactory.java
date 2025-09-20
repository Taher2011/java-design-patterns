package abstract_factory.vehicle._04_concrete_product_factory;

import abstract_factory.vehicle._01_product.Hatchback;
import abstract_factory.vehicle._01_product.SUV;
import abstract_factory.vehicle._01_product.Sedan;
import abstract_factory.vehicle._02_concrete_product.AmericanHatchback;
import abstract_factory.vehicle._02_concrete_product.AmericanSUV;
import abstract_factory.vehicle._02_concrete_product.AmericanSedan;
import abstract_factory.vehicle._03_abstract_product_factory.AbstractVehicleFactory;

public class AmericanVehicleFactory extends AbstractVehicleFactory {

	@Override
	public Hatchback createHatchbackVehicle() {
		return new AmericanHatchback();
	}

	@Override
	public Sedan createSedanVehicle() {
		return new AmericanSedan();
	}

	@Override
	public SUV createSUVVehilce() {
		return new AmericanSUV();
	}
}
