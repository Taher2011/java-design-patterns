package concrete_product;

import product.FoodItem;

public class Sandwich implements FoodItem {

	@Override
	public void prepare() {
		System.out.println("Preparing Sandwich: Toasting bread, vegies, and stuffings.");
	}

}
