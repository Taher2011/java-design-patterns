package flyweight.client;

import java.time.LocalDateTime;

import flyweight.concrete_flyweight_intrinsic.Coffee;
import flyweight.enums.CoffeeType;
import flyweight.extrinsic_entity.Order;
import flyweight.flywieght_factory.CoffeeFactory;

public class FlyweightPattern {
	public static void main(String[] args) {
		CoffeeFactory coffeeFactory = new CoffeeFactory();

		Coffee coffee1 = coffeeFactory.getCoffee1(CoffeeType.CAPPUCCINO_MEDIUM);
		coffee1.serve(new Order("ABC1234", "Taher", "Table-1A", LocalDateTime.now()));

		Coffee coffee2 = coffeeFactory.getCoffee1(CoffeeType.CAPPUCCINO_MEDIUM);
		coffee2.serve(new Order("ABC5678", "Taheri", "Table-A2", LocalDateTime.now()));

		Coffee coffee3 = coffeeFactory.getCoffee1(CoffeeType.LATTE_SMALL);
		coffee3.serve(new Order("XYZ7890", "Rohan", "Table-B1", LocalDateTime.now()));

		Coffee coffee4 = coffeeFactory.getCoffee1(CoffeeType.LATTE_SMALL);
		coffee4.serve(new Order("XYZ7786", "Roshan", "Table-B2", LocalDateTime.now()));

		Coffee coffee5 = coffeeFactory.getCoffee(CoffeeType.CAPPUCCINO_SMALL);
		coffee5.serve(new Order("PQR7890", "Rohan", "Table-B1", LocalDateTime.now()));

		Coffee coffee6 = coffeeFactory.getCoffee(CoffeeType.CAPPUCCINO_SMALL);
		coffee6.serve(new Order("PQR7412", "Rohit", "Table-V1", LocalDateTime.now()));

		System.out.println("All orders processed successfully.");
	}
}
