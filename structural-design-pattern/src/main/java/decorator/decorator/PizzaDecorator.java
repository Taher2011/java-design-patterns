package decorator.decorator;

import decorator.component.Pizza;

public abstract class PizzaDecorator extends Pizza {

	protected Pizza pizza;

	protected PizzaDecorator(Pizza pizza) {
		super(pizza.getPrice());
		this.pizza = pizza;
	}

	public abstract String getDescription();

	public abstract double getPrice();

}
