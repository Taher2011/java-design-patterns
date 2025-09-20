package abstract_factory.vehicle._02_concrete_product;

import abstract_factory.vehicle._01_product.Sedan;

public class AmericanSedan extends Sedan {

	@Override
	public void describe() {
		System.out.println("Sedan: Comfortable sedan with advanced safety features");
	}
}
