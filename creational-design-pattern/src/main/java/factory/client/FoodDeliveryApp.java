package factory.client;

import factory.enums.FoodTypes;
import factory.product.FoodItem;
import factory.product_factory.FoodFactory;

public class FoodDeliveryApp {

	public static void main(String[] args) {
		// Order a Pizza
		FoodFactory foodFactory = FoodFactory.createFoodFactory(FoodTypes.PIZZA);
		FoodItem pizza = foodFactory.createFood();
		pizza.prepare();

		// Order a Burger
		foodFactory = FoodFactory.createFoodFactory(FoodTypes.BURGER);
		FoodItem burger = foodFactory.createFood();
		burger.prepare();

		// Order a Sandwich
		foodFactory = FoodFactory.createFoodFactory(FoodTypes.SANDWICH);
		FoodItem sandwich = foodFactory.createFood();
		sandwich.prepare();
	}

}
