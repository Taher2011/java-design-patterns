package factory.enums;

public enum FoodTypes {

	PIZZA("pizza"), BURGER("burger"), SANDWICH("sandwich");

	String type;

	private FoodTypes(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
