package strategy;

import dto.Order;

public interface FoodDeliveryStrategy {

	void processOrder(Order order);

	double calculateCost(Order order);

}
