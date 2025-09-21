package decorator.insurance.client;

import decorator.insurance.component.Insurance;
import decorator.insurance.concrete_component.AutoInsurance;
import decorator.insurance.concrete_decorator.AccidentCoverageDecorator;
import decorator.insurance.concrete_decorator.PremiumSupportDecorator;

public class DecoratorClient {

	public static void main(String[] args) {
		Insurance autoInsurance = new AutoInsurance("Auto Insurance");
		System.out.println(autoInsurance.coverageDetails());
		System.out.println("premium cost of " + autoInsurance.getName() + " is " + autoInsurance.premiumCost() + "$");

		System.out.println(
				"============================================================================================================");

		autoInsurance = new AccidentCoverageDecorator(autoInsurance);
		System.out.println(autoInsurance.coverageDetails());
		System.out.println(
				"updated premium cost of " + autoInsurance.getName() + " is " + autoInsurance.premiumCost() + "$");

		System.out.println(
				"============================================================================================================");

		autoInsurance = new PremiumSupportDecorator(autoInsurance);
		System.out.println(autoInsurance.coverageDetails());
		System.out.println(
				"updated premium cost of " + autoInsurance.getName() + " is " + autoInsurance.premiumCost() + "$");
	}

}
