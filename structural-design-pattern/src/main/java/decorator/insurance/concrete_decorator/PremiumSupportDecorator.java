package decorator.insurance.concrete_decorator;

import decorator.insurance.component.Insurance;
import decorator.insurance.decorator.InsuranceDecorator;

public class PremiumSupportDecorator extends InsuranceDecorator {

	public PremiumSupportDecorator(Insurance insurance) {
		super(insurance);
	}

	@Override
	public String coverageDetails() {
		return insurance.coverageDetails() + " + PremiumSupport coverage";
	}

	@Override
	public int premiumCost() {
		return insurance.premiumCost() + 450;
	}
}
