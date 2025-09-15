package strategy.concrete_strategy;

import strategy.dto.Order;

public class TakeAway extends BaseDeliveryStrategy {

	@Override
	public void processOrder(Order order) {
		System.out.println("Preparing Take-Away order-no. " + order.getOrderId() + " for " + order.getCustomerName());
		System.out.println("Items: " + getFormattedItems(order));
		System.out.println("Ready for pickup in 15 minutes");
	}

	@Override
	public double calculateCost(Order order) {
		return calculateBaseCost(order); // No extra fee
	}
}
