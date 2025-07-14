package product_factory;

import concrete_product_factory.BurgerFactory;
import concrete_product_factory.PizzaFactory;
import enums.FoodTypes;
import product.FoodItem;

public abstract class FoodFactory {

	public abstract FoodItem createFood();

	public static FoodFactory getFood(FoodTypes foodTypes) {
		if (foodTypes == null) {
			throw new IllegalArgumentException("Food type cannot be null");
		}
		FoodFactory foodFactory = null;
		switch (foodTypes) {
		case PIZZA:
			foodFactory = new PizzaFactory();
			break;
		case BURGER:
			foodFactory = new BurgerFactory();
			break;
		default:
			throw new IllegalArgumentException("Unknown food type: " + foodTypes);
		}
		return foodFactory;
	}
}
