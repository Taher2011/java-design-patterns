package ecommerce.client;

import ecommerce._01_product.FraudCheck;
import ecommerce._01_product.PaymentMethod;
import ecommerce._01_product.TransactionReceipt;
import ecommerce._03_abstract_product_factory.AbstractPaymentFactory;
import ecommerce._04_concrete_product_factory.SecurePaymentFactory;
import ecommerce._04_concrete_product_factory.StandardPaymentFactory;

public class PaymentClient {

	PaymentMethod paymentMethod;
	TransactionReceipt transactionReceipt;
	FraudCheck fraudCheck;

	public PaymentClient(AbstractPaymentFactory factory, String paymentType) {
		switch (paymentType.toLowerCase()) {
		case "creditcard":
			paymentMethod = factory.createCreditCard();
			break;
		case "upi":
			paymentMethod = factory.createUPI();
			break;
		case "paypal":
			paymentMethod = factory.createPayPal();
			break;
		default:
			throw new IllegalArgumentException("Invalid payment type: " + paymentType);
		}
		transactionReceipt = factory.createTransactionReceipt();
		fraudCheck = factory.createFraudCheck();
	}

	public void processTransaction() {
		paymentMethod.processPayment();
		transactionReceipt.generateReceipt();
		fraudCheck.checkFraud();
	}

	public static void main(String[] args) {
		System.out.println("Testing Standard Payment Factory:");
		AbstractPaymentFactory standardFactory = new StandardPaymentFactory();
		PaymentClient client = new PaymentClient(standardFactory, "creditcard");
		System.out.println("\nStandard Credit Card Transaction:");
		client.processTransaction();

		System.out.println("\nTesting Secure Payment Factory:");
		AbstractPaymentFactory secureFactory = new SecurePaymentFactory();
		client = new PaymentClient(secureFactory, "paypal");
		System.out.println("\nSecure PayPal Transaction:");
		client.processTransaction();
	}
}
