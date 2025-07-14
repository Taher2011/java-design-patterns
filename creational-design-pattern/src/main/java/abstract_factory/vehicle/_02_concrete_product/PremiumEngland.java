package vehicle._02_concrete_product;

import vehicle._01_product.EuropeanVehicle;

public class PremiumEngland extends EuropeanVehicle {

	@Override
	public void describe() {
		System.out.println("Premium English vehicle with high-end features");
	}
}
