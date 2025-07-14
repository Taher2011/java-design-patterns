package client;

import component.Pizza;
import concrete_component.IndianPizza;
import concrete_decorator.CheeseDecorator;
import concrete_decorator.VeggiesDecorator;

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
