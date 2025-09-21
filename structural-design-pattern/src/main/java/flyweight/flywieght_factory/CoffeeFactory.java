package flyweight.flywieght_factory;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import flyweight.concrete_flyweight_intrinsic.Coffee;
import flyweight.enums.CoffeeType;

public class CoffeeFactory {

	private static Map<String, Coffee> coffeeCache = new ConcurrentHashMap<>();

	/* Approach-1 using map */
	public Coffee getCoffeeByMapApproach(String type, String servingSize, BigDecimal price) {
		if (type == null || servingSize == null || price == null) {
			throw new IllegalArgumentException("coffee cannot be null");
		}
		String key = String.format("%s_%s_%.2f", type.toUpperCase(), servingSize.toLowerCase(), price);

		// return coffeeCache.computeIfAbsent(key, k -> new Coffee(type, servingSize,
		// price));

		Coffee coffee = coffeeCache.get(key);
		if (coffee == null) {
			coffee = new Coffee(type, servingSize, price);
			coffeeCache.put(key, coffee);
		}
		return coffee;
	}

	/* Approach-2 using enums */
	public Coffee getCoffeeByEnumApproach(CoffeeType coffeeType) {
		return coffeeType.getCoffee();
	}

}
