package _02_concrete_product;

import _01_product.AmericanVehicle;

public class PremiumAmerica extends AmericanVehicle {

	@Override
	public void describe() {
		System.out.println("Premium American vehicle with high-end features");
	}
}
