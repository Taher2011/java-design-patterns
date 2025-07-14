package enums;

import lombok.Getter;

@Getter
public enum FoodTypes {

	PIZZA("pizza"), BURGER("burger");

	String type;

	private FoodTypes(String type) {
		this.type = type;
	}
}
