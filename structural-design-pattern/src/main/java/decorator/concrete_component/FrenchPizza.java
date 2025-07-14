package concrete_component;

import component.Pizza;

public class FrenchPizza extends Pizza {

	public FrenchPizza(double additionalPrice) {
		super(additionalPrice + BASE_PRICE);
	}

	@Override
	public String getDescription() {
		return "French Style Pizza";
	}

	@Override
	public double getPrice() {
		return price;
	}
}
