package product_factory;

import java.util.HashMap;
import java.util.Map;

import concrete_product_factory.BurgerFactory;
import concrete_product_factory.PizzaFactory;
import concrete_product_factory.SandwichFactory;
import enums.FoodTypes;
import product.FoodItem;

public abstract class FoodFactory {

	private static Map<FoodTypes, FoodFactory> factories = new HashMap<>();

	static {
		factories.put(FoodTypes.PIZZA, new PizzaFactory());
		factories.put(FoodTypes.BURGER, new BurgerFactory());
		factories.put(FoodTypes.SANDWICH, new SandwichFactory());
	}

	public static FoodFactory createFoodFactory(FoodTypes foodTypes) {
		FoodFactory foodFactory = factories.get(foodTypes);
		if (foodFactory == null) {
			throw new IllegalArgumentException("Invalid food type: " + foodTypes);
		}
		return foodFactory;
	}

	public abstract FoodItem createFood();

}
