package abstract_factory.vehicle._02_concrete_product;

import abstract_factory.vehicle._01_product.AsianVehicle;

public class StandardChina extends AsianVehicle {

	@Override
	public void describe() {
		System.out.println("Standard Chineese vehicle with high-end features");
	}
}
