package client;

import enums.FoodTypes;
import product.FoodItem;

public class FoodDeliveryApp {

	public static void main(String[] args) {
		// Order a Pizza
		FoodItem pizza = FoodTypes.PIZZA.createFood();
		pizza.prepare();

		// Order a Burger
		FoodItem burger = FoodTypes.BURGER.createFood();
		burger.prepare();
	}

}
