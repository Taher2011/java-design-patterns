package factory.product_factory;

import java.util.HashMap;
import java.util.Map;

import factory.concrete_product_factory.BurgerFactory;
import factory.concrete_product_factory.PizzaFactory;
import factory.concrete_product_factory.SandwichFactory;
import factory.enums.FoodTypes;
import factory.product.FoodItem;

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
