package abstract_factory.ecommerce.client;

import abstract_factory.ecommerce._01_product.FraudCheck;
import abstract_factory.ecommerce._01_product.PaymentMethod;
import abstract_factory.ecommerce._01_product.TransactionReceipt;
import abstract_factory.ecommerce._03_abstract_product_factory.AbstractPaymentFactory;
import abstract_factory.ecommerce._05_enum.ModeType;

public class PaymentClient {

	private final PaymentMethod paymentMethod;
	private final TransactionReceipt transactionReceipt;
	private final FraudCheck fraudCheck;

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
		System.out.println("Testing Standard Payment method:");
		AbstractPaymentFactory standardPaymentMethod = AbstractPaymentFactory.createPaymentFactory(ModeType.STANDARD);
		PaymentClient client = new PaymentClient(standardPaymentMethod, "creditcard");
		System.out.println("\nStandard Credit Card Transaction:");
		client.processTransaction();

		System.out.println("========================================================");

		System.out.println("\nTesting Secure Payment method:");
		AbstractPaymentFactory securePaymentMethod = AbstractPaymentFactory.createPaymentFactory(ModeType.SECURE);
		client = new PaymentClient(securePaymentMethod, "paypal");
		System.out.println("\nSecure PayPal Transaction:");
		client.processTransaction();
	}
}
