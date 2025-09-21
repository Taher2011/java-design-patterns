package decorator.insurance.concrete_decorator;

import decorator.insurance.component.Insurance;
import decorator.insurance.decorator.InsuranceDecorator;

public class RoadsideAssistanceDecorator extends InsuranceDecorator {

	public RoadsideAssistanceDecorator(Insurance insurance) {
		super(insurance);
	}

	@Override
	public String coverageDetails() {
		return insurance.coverageDetails() + " + Roadside Assistance";
	}

	@Override
	public int premiumCost() {
		return insurance.premiumCost() + 300;
	}
}
