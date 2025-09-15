package strategy.strategy;

import strategy.dto.Order;

public interface FoodDeliveryStrategy {

	void processOrder(Order order);

	double calculateCost(Order order);

}
