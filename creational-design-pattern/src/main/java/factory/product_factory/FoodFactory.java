package product_factory;

import product.FoodItem;

public abstract class FoodFactory {

	public abstract FoodItem createFood();

	public FoodItem getFood() {
		return createFood();
	}
}
