package factory.concrete_product;

import factory.product.FoodItem;

public class Burger implements FoodItem {

	@Override
	public void prepare() {
		System.out.println("Preparing Burger: Grilling patty, adding buns, lettuce, and sauce.");
	}
}
