package factory.concrete_product;

import factory.product.FoodItem;

public class Pizza implements FoodItem {

	@Override
	public void prepare() {
		System.out.println("Preparing Pizza: Adding dough, sauce, cheese, and toppings.");
	}
}
