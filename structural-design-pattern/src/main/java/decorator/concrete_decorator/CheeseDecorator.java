package decorator.concrete_decorator;

import decorator.component.Pizza;
import decorator.decorator.PizzaDecorator;

public class CheeseDecorator extends PizzaDecorator {

	private static final double CHEESE_PRICE = 50.0;

	public CheeseDecorator(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + ", cheese topping";
	}

	@Override
	public double getPrice() {
		return pizza.getPrice() + CHEESE_PRICE;
	}

}
