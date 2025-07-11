package _02_concrete_product;

import _01_product.AmericanVehicle;

public class StandardCanada extends AmericanVehicle {

	@Override
	public void describe() {
		System.out.println("Standard Canadian vehicle with high-end features");
	}
}
