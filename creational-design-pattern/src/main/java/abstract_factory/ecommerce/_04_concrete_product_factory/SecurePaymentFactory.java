package ecommerce._04_concrete_product_factory;

import ecommerce._01_product.FraudCheck;
import ecommerce._01_product.PaymentMethod;
import ecommerce._01_product.TransactionReceipt;
import ecommerce._02_concrete_product.SecureCreditCard;
import ecommerce._02_concrete_product.SecureFraudCheck;
import ecommerce._02_concrete_product.SecurePayPal;
import ecommerce._02_concrete_product.SecureReceipt;
import ecommerce._02_concrete_product.SecureUPI;
import ecommerce._03_abstract_product_factory.AbstractPaymentFactory;

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
