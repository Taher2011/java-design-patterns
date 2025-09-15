package abstract_factory.vehicle._02_concrete_product;

import abstract_factory.vehicle._01_product.AmericanVehicle;

public class StandardCanada extends AmericanVehicle {

	@Override
	public void describe() {
		System.out.println("Standard Canadian vehicle with high-end features");
	}
}
