package abstract_factory.ecommerce._05_enum;

public enum ModeType {

	SECURE("secure"), STANDARD("standard");

	private String mode;

	private ModeType(String mode) {
		this.mode = mode;
	}

	public String getMode() {
		return mode;
	}
}
