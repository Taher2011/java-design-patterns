package client;

import concrete_product_factory.BurgerFactory;
import concrete_product_factory.PizzaFactory;
import product.FoodItem;
import product_factory.FoodFactory;

public class FoodDeliveryApp {

	public static void main(String[] args) {
		// Order a Pizza
		FoodFactory pizzaFactory = new PizzaFactory();
		FoodItem pizza = pizzaFactory.getFood();
		pizza.prepare();

		// Order a Burger
		FoodFactory burgerFactory = new BurgerFactory();
		FoodItem burger = burgerFactory.getFood();
		burger.prepare();

	}

}
