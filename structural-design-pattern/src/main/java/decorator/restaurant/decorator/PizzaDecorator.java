package decorator.restaurant.decorator;

import decorator.restaurant.component.Pizza;

public abstract class PizzaDecorator extends Pizza {

	protected Pizza pizza;

	protected PizzaDecorator(Pizza pizza) {
		super(pizza.getPrice());
		this.pizza = pizza;
	}

	@Override
	public abstract String getDescription();

	@Override
	public abstract double getPrice();

}
