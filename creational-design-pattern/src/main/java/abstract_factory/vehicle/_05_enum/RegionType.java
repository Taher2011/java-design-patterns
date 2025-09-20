package abstract_factory.vehicle._05_enum;

public enum RegionType {

	INDIAN("indian"), CHINESE("chinese"), AMERICAN("american");

	private String region;

	private RegionType(String regionType) {
		this.region = regionType;
	}

	public String getRegion() {
		return region;
	}

}
