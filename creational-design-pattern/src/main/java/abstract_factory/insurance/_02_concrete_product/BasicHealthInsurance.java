package _02_concrete_product;

import _01_product.HealthInsurance;

public class BasicHealthInsurance extends HealthInsurance {

	@Override
	public void getPolicyDetails() {
		System.out.println("Basic Health: Hospitalization up to $50,000");
	}
}
