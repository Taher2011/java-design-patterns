package decorator.insurance.concrete_component;

import decorator.insurance.component.Insurance;

public class LifeInsurance extends Insurance {

	public LifeInsurance(String name) {
		super(name);
	}

	@Override
	public String coverageDetails() {
		return "Basic " + name + " : coverage up to $50,000";
	}

	@Override
	public int premiumCost() {
		return 1500;
	}
}
