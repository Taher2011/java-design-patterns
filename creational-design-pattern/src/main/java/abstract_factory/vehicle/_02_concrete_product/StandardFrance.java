package abstract_factory.vehicle._02_concrete_product;

import abstract_factory.vehicle._01_product.EuropeanVehicle;

public class StandardFrance extends EuropeanVehicle {

	@Override
	public void describe() {
		System.out.println("Standard French vehicle with high-end features");
	}
}
