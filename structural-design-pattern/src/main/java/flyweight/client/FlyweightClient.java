package flyweight.client;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import flyweight.concrete_flyweight_intrinsic.Coffee;
import flyweight.enums.CoffeeType;
import flyweight.extrinsic_entity.Order;
import flyweight.flywieght_factory.CoffeeFactory;

public class FlyweightClient {
	public static void main(String[] args) {
		CoffeeFactory coffeeFactory = new CoffeeFactory();

		Coffee coffee1 = coffeeFactory.getCoffeeByMapApproach("cappuccino", "medium", new BigDecimal("106.00"));
		coffee1.serve(new Order("ABC1234", "Taher", "Table-1A", LocalDateTime.now()));

		Coffee coffee2 = coffeeFactory.getCoffeeByMapApproach("cappuccino", "medium", new BigDecimal("106.00"));
		coffee2.serve(new Order("ABC5678", "Taheri", "Table-A2", LocalDateTime.now()));

		Coffee coffee3 = coffeeFactory.getCoffeeByMapApproach("latte", "small", new BigDecimal("87.00"));
		coffee3.serve(new Order("XYZ7890", "Rohan", "Table-B1", LocalDateTime.now()));

		Coffee coffee4 = coffeeFactory.getCoffeeByMapApproach("latte", "small", new BigDecimal("87.00"));
		coffee4.serve(new Order("XYZ7786", "Roshan", "Table-B2", LocalDateTime.now()));

		Coffee coffee5 = coffeeFactory.getCoffeeByEnumApproach(CoffeeType.CAPPUCCINO_SMALL);
		coffee5.serve(new Order("PQR7890", "Rohan", "Table-B1", LocalDateTime.now()));

		Coffee coffee6 = coffeeFactory.getCoffeeByEnumApproach(CoffeeType.CAPPUCCINO_SMALL);
		coffee6.serve(new Order("PQR7412", "Rohit", "Table-V1", LocalDateTime.now()));

		Coffee coffee7 = coffeeFactory.getCoffeeByMapApproach("espresso", "medium", new BigDecimal("97.00"));
		coffee7.serve(new Order("DEF4562", "Sunil", "Table-Z1", LocalDateTime.now()));

		Coffee coffee8 = coffeeFactory.getCoffeeByMapApproach("espresso", "small", new BigDecimal("97.00"));
		coffee8.serve(new Order("DEF4563", "Raju", "Table-B2", LocalDateTime.now()));

		System.out.println("All orders processed successfully.");
	}
}
