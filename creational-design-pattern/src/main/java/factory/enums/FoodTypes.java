package enums;

import concrete_product_factory.BurgerFactory;
import concrete_product_factory.PizzaFactory;
import product.FoodItem;
import product_factory.FoodFactory;

public enum FoodTypes {

	PIZZA("pizza", new PizzaFactory()), BURGER("burger", new BurgerFactory());

	String type;
	FoodFactory foodFactory;

	private FoodTypes(String type, FoodFactory foodItem) {
		this.type = type;
		this.foodFactory = foodItem;
	}

	public String getType() {
		return type;
	}

	public FoodItem createFood() {
		return foodFactory.createFood();
	}

}
