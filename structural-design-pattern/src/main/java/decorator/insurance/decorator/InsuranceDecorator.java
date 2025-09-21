package decorator.insurance.decorator;

import decorator.insurance.component.Insurance;

public abstract class InsuranceDecorator extends Insurance {

	protected Insurance insurance;

	protected InsuranceDecorator(Insurance insurance) {
		super(insurance.getName());
		this.insurance = insurance;
	}
}
