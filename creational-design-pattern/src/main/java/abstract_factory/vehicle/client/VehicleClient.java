package client;

import _01_product.AmericanVehicle;
import _01_product.AsianVehicle;
import _01_product.EuropeanVehicle;
import _03_abstract_product_factory.AbstractVehicleFactory;
import _04_concrete_product_factory.PremiumVehicleFactory;
import _04_concrete_product_factory.StandardVehicleFactory;

public class VehicleClient {
	private AsianVehicle asianVehicle;
	private EuropeanVehicle europeanVehicle;
	private AmericanVehicle americanVehicle;

	public VehicleClient(AbstractVehicleFactory factory) {
		asianVehicle = factory.getAsianVehicle();
		europeanVehicle = factory.getEuropeanVehicle();
		americanVehicle = factory.getAmericanVehicle();
	}

	public void description() {
		if (asianVehicle != null)
			asianVehicle.describe();
		else
			System.out.println("Asian Vehicle not available");
		if (europeanVehicle != null)
			europeanVehicle.describe();
		else
			System.out.println("European Vehicle not available");
		if (americanVehicle != null)
			americanVehicle.describe();
		else
			System.out.println("American Vehicle not available");
	}

	public static void main(String[] args) {

		System.out.println("Testing Standard Vehicle Factory:");
		AbstractVehicleFactory standardFactory = new StandardVehicleFactory();
		VehicleClient standardClient = new VehicleClient(standardFactory);
		standardClient.description();

		// Testing Premium Vehicle Factory
		System.out.println("\nTesting Premium Vehicle Factory:");
		AbstractVehicleFactory premiumFactory = new PremiumVehicleFactory();
		VehicleClient premiumClient = new VehicleClient(premiumFactory);
		premiumClient.description();

	}
}
