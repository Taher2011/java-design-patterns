package abstract_factory.ecommerce._03_abstract_product_factory;

import abstract_factory.ecommerce._01_product.FraudCheck;
import abstract_factory.ecommerce._01_product.PaymentMethod;
import abstract_factory.ecommerce._01_product.TransactionReceipt;

public abstract class AbstractPaymentFactory {
	public abstract PaymentMethod createCreditCard();

	public abstract PaymentMethod createUPI();

	public abstract PaymentMethod createPayPal();

	public abstract TransactionReceipt createTransactionReceipt();

	public abstract FraudCheck createFraudCheck();
}
