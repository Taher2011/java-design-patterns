package factory.concrete_product_factory;

import factory.concrete_product.Sandwich;
import factory.product.FoodItem;
import factory.product_factory.FoodFactory;

public class SandwichFactory extends FoodFactory {

	@Override
	public FoodItem createFood() {
		return new Sandwich();
	}

}
