package abstract_factory.vehicle._04_concrete_product_factory;

import abstract_factory.vehicle._01_product.Hatchback;
import abstract_factory.vehicle._01_product.SUV;
import abstract_factory.vehicle._01_product.Sedan;
import abstract_factory.vehicle._02_concrete_product.IndianHatchback;
import abstract_factory.vehicle._02_concrete_product.IndianSUV;
import abstract_factory.vehicle._02_concrete_product.IndianSedan;
import abstract_factory.vehicle._03_abstract_product_factory.AbstractVehicleFactory;

public class IndianVehicleFactory extends AbstractVehicleFactory {

	@Override
	public Hatchback createHatchbackVehicle() {
		return new IndianHatchback();
	}

	@Override
	public Sedan createSedanVehicle() {
		return new IndianSedan();
	}

	@Override
	public SUV createSUVVehilce() {
		return new IndianSUV();
	}
}
