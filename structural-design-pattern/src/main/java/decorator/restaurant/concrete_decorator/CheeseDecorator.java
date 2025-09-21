package decorator.restaurant.concrete_decorator;

import decorator.restaurant.component.Pizza;
import decorator.restaurant.decorator.PizzaDecorator;

public class CheeseDecorator extends PizzaDecorator {

	private static final double CHEESE_PRICE = 50.0;

	public CheeseDecorator(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + " + cheese topping";
	}

	@Override
	public double getPrice() {
		return pizza.getPrice() + CHEESE_PRICE;
	}

}
