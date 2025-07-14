package concrete_component;

import component.Pizza;

public class IndianPizza extends Pizza {

	public IndianPizza(double additionalPrice) {
		super(additionalPrice + BASE_PRICE);
	}

	@Override
	public String getDescription() {
		return "Indian Style Pizza";
	}

	@Override
	public double getPrice() {
		return price;
	}
}
