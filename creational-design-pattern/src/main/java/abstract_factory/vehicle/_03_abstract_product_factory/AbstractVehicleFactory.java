package abstract_factory.vehicle._03_abstract_product_factory;

import java.util.EnumMap;
import java.util.Map;

import abstract_factory.vehicle._01_product.Hatchback;
import abstract_factory.vehicle._01_product.SUV;
import abstract_factory.vehicle._01_product.Sedan;
import abstract_factory.vehicle._04_concrete_product_factory.AmericanVehicleFactory;
import abstract_factory.vehicle._04_concrete_product_factory.ChineseVehicleFactory;
import abstract_factory.vehicle._04_concrete_product_factory.IndianVehicleFactory;
import abstract_factory.vehicle._05_enum.RegionType;

public abstract class AbstractVehicleFactory {

	private static Map<RegionType, AbstractVehicleFactory> factory = new EnumMap<>(RegionType.class);
	static {
		factory.put(RegionType.INDIAN, new IndianVehicleFactory());
		factory.put(RegionType.CHINESE, new ChineseVehicleFactory());
		factory.put(RegionType.AMERICAN, new AmericanVehicleFactory());
	}

	public static AbstractVehicleFactory createVehicleFactory(RegionType regionType) {
		AbstractVehicleFactory abstractVehicleFactory = factory.get(regionType);
		if (abstractVehicleFactory == null) {
			throw new IllegalArgumentException("invalid region type");
		}
		return abstractVehicleFactory;
	}

	public abstract Hatchback createHatchbackVehicle();

	public abstract Sedan createSedanVehicle();

	public abstract SUV createSUVVehilce();
}
