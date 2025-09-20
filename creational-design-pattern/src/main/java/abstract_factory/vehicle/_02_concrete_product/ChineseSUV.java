package abstract_factory.vehicle._02_concrete_product;

import abstract_factory.vehicle._01_product.SUV;

public class ChineseSUV extends SUV {

	@Override
	public void describe() {
		System.out.println("SUV: Affordable SUV with modern features");
	}
}
