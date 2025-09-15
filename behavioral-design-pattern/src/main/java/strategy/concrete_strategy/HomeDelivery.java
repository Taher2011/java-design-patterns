package strategy.concrete_strategy;

import strategy.dto.Order;

public class HomeDelivery extends BaseDeliveryStrategy {

	@Override
	public void processOrder(Order order) {
		System.out
				.println("Preparing Home-Delivery order-no. " + order.getOrderId() + " for " + order.getCustomerName());
		System.out.println("Items: " + getFormattedItems(order));
		System.out.println("Estimated delivery: " + order.getLocalDateTime().plusHours(1));
	}

	@Override
	public double calculateCost(Order order) {
		return calculateBaseCost(order) + 5.0; // Delivery fee
	}
}
