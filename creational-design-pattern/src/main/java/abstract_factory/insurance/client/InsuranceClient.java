package abstract_factory.insurance.client;

import abstract_factory.insurance._01_product.AutoInsurance;
import abstract_factory.insurance._01_product.HealthInsurance;
import abstract_factory.insurance._01_product.HomeInsurance;
import abstract_factory.insurance._03_abstract_product_factory.AbstractInsuranceFactory;
import abstract_factory.insurance._04_concrete_product_factory.BasicInsuranceFactory;
import abstract_factory.insurance._04_concrete_product_factory.PremiumInsuranceFactory;

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
		System.out.println("Testing Basic Insurance Factory:");
		AbstractInsuranceFactory basicFactory = new BasicInsuranceFactory();
		InsuranceClient standardClient = new InsuranceClient(basicFactory);
		standardClient.description();

		System.out.println("\nTesting Premium Insurance Factory:");
		AbstractInsuranceFactory premiumFactory = new PremiumInsuranceFactory();
		InsuranceClient premiumClient = new InsuranceClient(premiumFactory);
		premiumClient.description();
	}

}
