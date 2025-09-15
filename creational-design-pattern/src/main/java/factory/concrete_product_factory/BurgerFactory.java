package factory.concrete_product_factory;

import factory.concrete_product.Burger;
import factory.product.FoodItem;
import factory.product_factory.FoodFactory;

public class BurgerFactory extends FoodFactory {

	@Override
	public FoodItem createFood() {
		return new Burger();
	}
}
