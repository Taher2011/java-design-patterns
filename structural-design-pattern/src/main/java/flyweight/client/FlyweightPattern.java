package client;

import java.time.LocalDateTime;

import concrete_flyweight_intrinsic.Coffee;
import enums.CoffeeType;
import extrinsic_entity.Order;
import flywieght_factory.CoffeeFactory;

public class FlyweightPattern {
	public static void main(String[] args) {
		CoffeeFactory coffeeFactory = new CoffeeFactory();

		Coffee coffee1 = coffeeFactory.getCoffee(CoffeeType.CAPPUCCINO_MEDIUM);
		coffee1.serve(new Order("ABC1234", "Taher", "Table-1A", LocalDateTime.now()));

		Coffee coffee2 = coffeeFactory.getCoffee(CoffeeType.CAPPUCCINO_MEDIUM);
		coffee2.serve(new Order("ABC5678", "Taheri", "Table-A2", LocalDateTime.now()));

		Coffee coffee3 = coffeeFactory.getCoffee(CoffeeType.LATTE_SMALL);
		coffee3.serve(new Order("XYZ7890", "Rohan", "Table-B1", LocalDateTime.now()));

		System.out.println("All orders processed successfully.");
	}
}
