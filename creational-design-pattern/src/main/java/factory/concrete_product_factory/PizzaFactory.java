package concrete_product_factory;

import concrete_product.Pizza;
import product.FoodItem;
import product_factory.FoodFactory;

public class PizzaFactory extends FoodFactory {

	@Override
	public FoodItem createFood() {
		return new Pizza();
	}
}
