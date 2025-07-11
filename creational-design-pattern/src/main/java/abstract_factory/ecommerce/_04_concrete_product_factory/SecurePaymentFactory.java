package _04_concrete_product_factory;

import _01_product.FraudCheck;
import _01_product.PaymentMethod;
import _01_product.TransactionReceipt;
import _02_concrete_product.SecureCreditCard;
import _02_concrete_product.SecureFraudCheck;
import _02_concrete_product.SecurePayPal;
import _02_concrete_product.SecureReceipt;
import _02_concrete_product.SecureUPI;
import _03_abstract_product_factory.AbstractPaymentFactory;

public class SecurePaymentFactory extends AbstractPaymentFactory {

	@Override
	public PaymentMethod createCreditCard() {
		return new SecureCreditCard();
	}

	@Override
	public PaymentMethod createUPI() {
		return new SecureUPI();
	}

	@Override
	public PaymentMethod createPayPal() {
		return new SecurePayPal();
	}

	@Override
	public TransactionReceipt createTransactionReceipt() {
		return new SecureReceipt();
	}

	@Override
	public FraudCheck createFraudCheck() {
		return new SecureFraudCheck();
	}

}
