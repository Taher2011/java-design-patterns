package strategy.concrete_strategy;

import java.util.stream.Collectors;

import strategy.dto.Order;
import strategy.strategy.FoodDeliveryStrategy;

public abstract class BaseDeliveryStrategy implements FoodDeliveryStrategy {

	public String getFormattedItems(Order order) {
		return order.getOrderQuantity().entrySet().stream().map(e -> e.getKey() + " " + e.getValue())
				.collect(Collectors.joining(", "));
	}

	public double calculateBaseCost(Order order) {
		return order.getOrderQuantity().values().stream().mapToInt(Integer::intValue).sum() * 10.0; // Base cost per
																									// item
	}
}
