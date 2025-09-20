package abstract_factory.vehicle.client;

import abstract_factory.vehicle._01_product.Hatchback;
import abstract_factory.vehicle._01_product.SUV;
import abstract_factory.vehicle._01_product.Sedan;
import abstract_factory.vehicle._03_abstract_product_factory.AbstractVehicleFactory;
import abstract_factory.vehicle._05_enum.RegionType;

public class VehicleClient {

	private final Hatchback hatchback;
	private final Sedan sedan;
	private final SUV suv;

	public VehicleClient(AbstractVehicleFactory factory) {
		hatchback = factory.createHatchbackVehicle();
		sedan = factory.createSedanVehicle();
		suv = factory.createSUVVehilce();
	}

	public void description() {
		hatchback.describe();
		suv.describe();
		sedan.describe();
	}

	public static void main(String[] args) {

		System.out.println("Details about American Vehicle :");
		AbstractVehicleFactory americanAbstractVehicleFactory = AbstractVehicleFactory
				.createVehicleFactory(RegionType.AMERICAN);
		VehicleClient standardClient = new VehicleClient(americanAbstractVehicleFactory);
		standardClient.description();

		System.out.println("===============================================================");

		System.out.println("\nDetails about Chinese Vehicle :");
		AbstractVehicleFactory chineseAbstractVehicleFactory = AbstractVehicleFactory
				.createVehicleFactory(RegionType.CHINESE);
		standardClient = new VehicleClient(chineseAbstractVehicleFactory);
		standardClient.description();

		System.out.println("===============================================================");

		System.out.println("\nDetails about Indian Vehicle :");
		AbstractVehicleFactory indianAbstractVehicleFactory = AbstractVehicleFactory
				.createVehicleFactory(RegionType.INDIAN);
		standardClient = new VehicleClient(indianAbstractVehicleFactory);
		standardClient.description();

		System.out.println("===============================================================");

	}
}
