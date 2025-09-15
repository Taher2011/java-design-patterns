package abstract_factory.vehicle._02_concrete_product;

import abstract_factory.vehicle._01_product.AsianVehicle;

public class PremiumIndian extends AsianVehicle {

	@Override
	public void describe() {
		System.out.println("Premium Indian vehicle with high-end features");
	}
}
