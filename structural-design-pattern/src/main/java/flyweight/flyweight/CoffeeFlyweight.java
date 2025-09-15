package flyweight.flyweight;

import flyweight.extrinsic_entity.Order;

public interface CoffeeFlyweight {
	void serve(Order order); // order is extrinsic state
}
