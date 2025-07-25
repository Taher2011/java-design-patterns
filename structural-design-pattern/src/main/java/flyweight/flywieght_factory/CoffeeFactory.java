package flywieght_factory;

import java.util.HashMap;
import java.util.Map;

import concrete_flyweight_intrinsic.Coffee;
import enums.CoffeeType;

public class CoffeeFactory {

	private Map<CoffeeType, Coffee> coffeeCache = new HashMap<>();

	public Coffee getCoffee(CoffeeType coffeeType) {
		if (coffeeType == null) {
			throw new IllegalArgumentException("CoffeeType cannot be null");
		}
		// Check if Coffee object is already in cache
		Coffee coffee = coffeeCache.get(coffeeType);
		if (coffee == null) {
			// If not in cache, get from CoffeeType and store in cache
			coffee = coffeeType.getCoffee();
			coffeeCache.put(coffeeType, coffee);
		}
		return coffee;
	}

	public Coffee getCoffee1(CoffeeType coffeeType) {
		return coffeeType.getCoffee();
	}

//	public Coffee getCoffee(CoffeeType coffeeType) {
//        return coffeeCache.computeIfAbsent(coffeeType, CoffeeType::getCoffee);
//    }
}
