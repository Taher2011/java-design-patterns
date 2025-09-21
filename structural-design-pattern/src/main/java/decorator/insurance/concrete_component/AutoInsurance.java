package decorator.insurance.concrete_component;

import decorator.insurance.component.Insurance;

public class AutoInsurance extends Insurance {

	public AutoInsurance(String name) {
		super(name);
	}

	@Override
	public String coverageDetails() {
		return "Basic " + name + " : coverage up to $20,000";
	}

	@Override
	public int premiumCost() {
		return 1000;
	}
}
