package abstract_factory.vehicle._02_concrete_product;

import abstract_factory.vehicle._01_product.SUV;

public class AmericanSUV extends SUV {

	@Override
	public void describe() {
		System.out.println("SUV: Rugged build with V8 engine");
	}
}
