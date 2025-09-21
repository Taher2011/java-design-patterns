package decorator.restaurant.client;

import decorator.restaurant.component.Pizza;
import decorator.restaurant.concrete_component.IndianPizza;
import decorator.restaurant.concrete_decorator.CheeseDecorator;
import decorator.restaurant.concrete_decorator.VeggiesDecorator;

public class DecoratorClient {

	private static void printOrderDetails(Pizza pizza) {
		System.out.println("Order: " + pizza.getDescription() + " Total $" + pizza.getPrice());
	}

	public static void main(String[] args) {
		Pizza pizza = new IndianPizza(142.0);
		printOrderDetails(pizza);

		pizza = new CheeseDecorator(pizza);
		pizza = new VeggiesDecorator(pizza);
		printOrderDetails(pizza);
	}

}
