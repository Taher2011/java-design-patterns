package decorator.concrete_decorator;

import decorator.component.Pizza;
import decorator.decorator.PizzaDecorator;

public class VeggiesDecorator extends PizzaDecorator {

	private static final double VEGGIES_PRICE = 40.0;

	public VeggiesDecorator(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + ", veggies topping";
	}

	@Override
	public double getPrice() {
		return pizza.getPrice() + VEGGIES_PRICE;
	}

}
