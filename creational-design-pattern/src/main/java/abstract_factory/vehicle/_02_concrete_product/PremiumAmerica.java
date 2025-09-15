package abstract_factory.vehicle._02_concrete_product;

import abstract_factory.vehicle._01_product.AmericanVehicle;

public class PremiumAmerica extends AmericanVehicle {

	@Override
	public void describe() {
		System.out.println("Premium American vehicle with high-end features");
	}
}
