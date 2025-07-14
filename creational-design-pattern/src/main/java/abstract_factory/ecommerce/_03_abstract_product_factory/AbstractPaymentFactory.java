package ecommerce._03_abstract_product_factory;

import ecommerce._01_product.FraudCheck;
import ecommerce._01_product.PaymentMethod;
import ecommerce._01_product.TransactionReceipt;

public abstract class AbstractPaymentFactory {
	public abstract PaymentMethod createCreditCard();

	public abstract PaymentMethod createUPI();

	public abstract PaymentMethod createPayPal();

	public abstract TransactionReceipt createTransactionReceipt();

	public abstract FraudCheck createFraudCheck();
}
