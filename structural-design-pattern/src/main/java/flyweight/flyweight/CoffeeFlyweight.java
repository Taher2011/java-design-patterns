package flyweight;

import extrinsic_entity.Order;

public interface CoffeeFlyweight {
	void serve(Order order); // extrinsic state
}
