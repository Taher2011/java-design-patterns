package abstract_factory.vehicle._02_concrete_product;

import abstract_factory.vehicle._01_product.Sedan;

public class ChineseSedan extends Sedan {

	@Override
	public void describe() {
		System.out.println("Sedan: Stylish sedan with tech-loaded dashboard");
	}
}
