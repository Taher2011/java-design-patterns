package client;

import java.time.LocalDateTime;
import java.util.Map;

import concrete_strategy.DineIn;
import concrete_strategy.HomeDelivery;
import concrete_strategy.TakeAway;
import context.StrategyContext;
import dto.Order;

public class StrategyClient {

	public static void main(String[] args) {
		StrategyContext context = new StrategyContext(new HomeDelivery());
		Order order1 = new Order(12345, "Taher Enterprises", Map.of("Veg-Burger", 2, "Cheese-Pizza", 3, "Pepsi", 3),
				LocalDateTime.now());
		context.processOrder(order1);

		System.out.println("\nChanging strategy...");
		context.setDeliveryStrategy(new TakeAway());
		Order order2 = new Order(12346, "Taher Enterprises",
				Map.of("Non-Veg-Burger", 5, "GarlicBread-Pizza", 3, "Coke", 5), LocalDateTime.now());
		context.processOrder(order2);

		System.out.println("\nChanging strategy...");
		context.setDeliveryStrategy(new DineIn());
		Order order3 = new Order(12347, "Taher Enterprises", Map.of("Shwarma", 8, "Naan", 8, "Sprite", 10),
				LocalDateTime.now());
		context.processOrder(order3);
	}

}
