package concrete_product_factory;

import concrete_product.Sandwich;
import product.FoodItem;
import product_factory.FoodFactory;

public class SandwichFactory extends FoodFactory {

	@Override
	public FoodItem createFood() {
		return new Sandwich();
	}

}
