package decorator.insurance.concrete_decorator;

import decorator.insurance.component.Insurance;
import decorator.insurance.decorator.InsuranceDecorator;

public class AccidentCoverageDecorator extends InsuranceDecorator {

	public AccidentCoverageDecorator(Insurance insurance) {
		super(insurance);
	}

	@Override
	public String coverageDetails() {
		return insurance.coverageDetails() + " + Accident coverage";
	}

	@Override
	public int premiumCost() {
		return insurance.premiumCost() + 500;
	}
}
