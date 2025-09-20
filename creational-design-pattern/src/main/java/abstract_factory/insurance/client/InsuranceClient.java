package abstract_factory.insurance.client;

import abstract_factory.insurance._01_product.AutoInsurance;
import abstract_factory.insurance._01_product.HealthInsurance;
import abstract_factory.insurance._01_product.HomeInsurance;
import abstract_factory.insurance._03_abstract_product_factory.AbstractInsuranceFactory;

public class InsuranceClient {

	AutoInsurance autoInsurance;
	HealthInsurance healthInsurance;
	HomeInsurance homeInsurance;

	public InsuranceClient(AbstractInsuranceFactory factory) {
		autoInsurance = factory.autoInsurance();
		healthInsurance = factory.healthInsurance();
		homeInsurance = factory.homeInsurance();
	}

	public void description() {
		autoInsurance.getPolicyDetails();
		healthInsurance.getPolicyDetails();
		homeInsurance.getPolicyDetails();
	}

	public static void main(String[] args) {
		System.out.println("Details about Basic Insurance Policies:");
		AbstractInsuranceFactory basicFactory = AbstractInsuranceFactory.createFactory("basic");
		InsuranceClient standardClient = new InsuranceClient(basicFactory);
		standardClient.description();

		System.out.println("===============================================================");

		System.out.println("\nDetails about Premium Insurance Policies:");
		AbstractInsuranceFactory premiumFactory = AbstractInsuranceFactory.createFactory("premium");
		InsuranceClient premiumClient = new InsuranceClient(premiumFactory);
		premiumClient.description();
	}

}
