package flyweight.enums;

import java.math.BigDecimal;

import flyweight.concrete_flyweight_intrinsic.Coffee;

public enum CoffeeType {

	LATTE_SMALL(new Coffee("latte", new BigDecimal("87.00"), "small")),
	LATTE_MEDIUM(new Coffee("latte", new BigDecimal("105.00"), "medium")),
	CAPPUCCINO_MEDIUM(new Coffee("cappuccino", new BigDecimal("106.00"), "medium")),
	CAPPUCCINO_SMALL(new Coffee("cappuccino", new BigDecimal("90.00"), "small"));

	private final Coffee coffee; // Each enum holds a Coffee object

	CoffeeType(Coffee coffee) {
		this.coffee = coffee;
	}

	public Coffee getCoffee() {
		return coffee;
	}

}
