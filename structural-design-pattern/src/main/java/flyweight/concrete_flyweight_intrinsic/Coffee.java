package flyweight.concrete_flyweight_intrinsic;

import java.math.BigDecimal;

import flyweight.extrinsic_entity.Order;
import flyweight.flyweight.CoffeeFlyweight;
import lombok.AllArgsConstructor;
import lombok.Getter;

/*Flyweight objects are generally immutable so no setter , all fields are final and initialize once by constructor */

@AllArgsConstructor
@Getter
public class Coffee implements CoffeeFlyweight {

	private final String type; // intrinsic state
	private final BigDecimal price;// intrinsic state
	private final String servingSize;// intrinsic state

	@Override
	public void serve(Order order) {
		System.out.println("Serving '" + servingSize + "_" + type + "' coffee for orderId '" + order.getOrderId()
				+ "' on order table '" + order.getOrderTable() + "' for the customer '" + order.getCustomerName()
				+ "' and price is " + price);
	}
}
