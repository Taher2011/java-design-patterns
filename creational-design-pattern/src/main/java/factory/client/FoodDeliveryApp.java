package client;

import enums.FoodTypes;
import product.FoodItem;
import product_factory.FoodFactory;

public class FoodDeliveryApp {

	public static void main(String[] args) {
		// Order a Pizza
		FoodFactory pizzaFactory = FoodFactory.getFood(FoodTypes.PIZZA);
		FoodItem pizza = pizzaFactory.createFood();
		pizza.prepare();

		// Order a Burger
		FoodFactory burgerFactory = FoodFactory.getFood(FoodTypes.BURGER);
		FoodItem burger = burgerFactory.createFood();
		burger.prepare();

	}

}
