package flyweight.enums;

import java.math.BigDecimal;

import flyweight.concrete_flyweight_intrinsic.Coffee;

public enum CoffeeType {

	LATTE_SMALL(new Coffee("latte", "small", new BigDecimal("87.00"))),
	LATTE_MEDIUM(new Coffee("latte", "medium", new BigDecimal("105.00"))),
	CAPPUCCINO_MEDIUM(new Coffee("cappuccino", "medium", new BigDecimal("106.00"))),
	CAPPUCCINO_SMALL(new Coffee("cappuccino", "small", new BigDecimal("90.00")));

	private final Coffee coffee;

	CoffeeType(Coffee coffee) {
		this.coffee = coffee;
	}

	public Coffee getCoffee() {
		return coffee;
	}

}
