package factory.concrete_product;

import factory.product.FoodItem;

public class Sandwich implements FoodItem {

	@Override
	public void prepare() {
		System.out.println("Preparing Sandwich: Toasting bread, vegies, and stuffings.");
	}

}
