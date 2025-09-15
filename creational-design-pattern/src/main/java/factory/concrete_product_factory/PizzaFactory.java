package factory.concrete_product_factory;

import factory.concrete_product.Pizza;
import factory.product.FoodItem;
import factory.product_factory.FoodFactory;

public class PizzaFactory extends FoodFactory {

	@Override
	public FoodItem createFood() {
		return new Pizza();
	}
}
