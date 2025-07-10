package concrete_product_factory;

import concrete_product.Burger;
import product.FoodItem;
import product_factory.FoodFactory;

public class BurgerFactory extends FoodFactory {

	@Override
	public FoodItem createFood() {
		return new Burger();
	}
}
