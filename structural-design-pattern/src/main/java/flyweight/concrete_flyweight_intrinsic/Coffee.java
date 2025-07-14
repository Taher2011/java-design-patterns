package concrete_flyweight_intrinsic;

import java.math.BigDecimal;

import extrinsic_entity.Order;
import flyweight.CoffeeFlyweight;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Coffee implements CoffeeFlyweight {

	private String type; // intrinsic state
	private BigDecimal price;// intrinsic state
	private String servingSize;// intrinsic state

	@Override
	public void serve(Order order) {
		System.out.println("Serving " + servingSize + " " + type + " coffe for orderId " + order.getOrderId()
				+ " on order table " + order.getOrderTable() + " for the customer " + order.getCustomerName()
				+ " and price is " + price);
	}
}
