package decorator.insurance.component;

import lombok.Getter;

@Getter
public abstract class Insurance {

	protected String name;

	protected Insurance(String name) {
		this.name = name;
	}

	public abstract String coverageDetails();

	public abstract int premiumCost();

}
