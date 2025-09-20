package abstract_factory.vehicle._02_concrete_product;

import abstract_factory.vehicle._01_product.Sedan;

public class IndianSedan extends Sedan {

	@Override
	public void describe() {
		System.out.println("Sedan: Family sedan with high mileage");
	}
}
