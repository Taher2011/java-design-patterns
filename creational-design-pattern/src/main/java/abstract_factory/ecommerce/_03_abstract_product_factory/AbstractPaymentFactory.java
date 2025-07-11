package _03_abstract_product_factory;

import _01_product.FraudCheck;
import _01_product.PaymentMethod;
import _01_product.TransactionReceipt;

public abstract class AbstractPaymentFactory {
	public abstract PaymentMethod createCreditCard();

	public abstract PaymentMethod createUPI();

	public abstract PaymentMethod createPayPal();

	public abstract TransactionReceipt createTransactionReceipt();

	public abstract FraudCheck createFraudCheck();
}
