package abstract_factory.vehicle._02_concrete_product;

import abstract_factory.vehicle._01_product.Hatchback;

public class IndianHatchback extends Hatchback {

	@Override
	public void describe() {
		System.out.println("Hatchback: Compact hatchback with affordability");
	}
}
