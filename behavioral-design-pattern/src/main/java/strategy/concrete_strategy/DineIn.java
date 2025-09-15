package strategy.concrete_strategy;

import strategy.dto.Order;

public class DineIn extends BaseDeliveryStrategy {

	@Override
	public void processOrder(Order order) {
		System.out.println("Preparing Dine-In order-no. " + order.getOrderId() + " for " + order.getCustomerName());
		System.out.println("Items: " + getFormattedItems(order));
		System.out.println("Table service in 20 minutes");
	}

	@Override
	public double calculateCost(Order order) {
		return calculateBaseCost(order) + 2.0; // Service fee
	}
}
