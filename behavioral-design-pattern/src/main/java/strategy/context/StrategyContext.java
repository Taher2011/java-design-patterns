package strategy.context;

import strategy.dto.Order;
import strategy.strategy.FoodDeliveryStrategy;

public class StrategyContext {

	FoodDeliveryStrategy deliveryStrategy;

	public StrategyContext(FoodDeliveryStrategy deliveryStrategy) {
		if (deliveryStrategy == null) {
			throw new IllegalArgumentException("Delivery strategy cannot be null");
		}
		this.deliveryStrategy = deliveryStrategy;
	}

	public void setDeliveryStrategy(FoodDeliveryStrategy deliveryStrategy) {
		if (deliveryStrategy == null) {
			throw new IllegalArgumentException("Delivery strategy cannot be null");
		}
		this.deliveryStrategy = deliveryStrategy;
	}

	public void processOrder(Order order) {
		if (order == null) {
			throw new IllegalArgumentException("Order cannot be null");
		}
		deliveryStrategy.processOrder(order);
		System.out.println("Total cost: $" + deliveryStrategy.calculateCost(order));
	}
}
