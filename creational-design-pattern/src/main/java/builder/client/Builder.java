package builder.client;

import java.time.LocalDateTime;

import builder.builder.Price;
import builder.builder.Product;

public class Builder {

	public static void main(String[] args) {
		Price price = Price.builder().basePrice(256.0).discount(2.0).build();
		Product product = Product.builder().id(1).name("Laptop").price(price).color("Silver").modelNo("XYZ123")
				.expiryDate(LocalDateTime.now()).build();

		System.out.println("Product: " + product.getName() + ", Price: " + product.getPrice().getBasePrice()
				+ ", Discount: " + product.getPrice().getDiscount() + "%, Expiry: " + product.getExpiryDate());
	}

}
