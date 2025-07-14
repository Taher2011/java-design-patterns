package ecommerce._04_concrete_product_factory;

import ecommerce._01_product.FraudCheck;
import ecommerce._01_product.PaymentMethod;
import ecommerce._01_product.TransactionReceipt;
import ecommerce._02_concrete_product.StandardCreditCard;
import ecommerce._02_concrete_product.StandardFraudCheck;
import ecommerce._02_concrete_product.StandardPayPal;
import ecommerce._02_concrete_product.StandardReceipt;
import ecommerce._02_concrete_product.StandardUPI;
import ecommerce._03_abstract_product_factory.AbstractPaymentFactory;

public class StandardPaymentFactory extends AbstractPaymentFactory {

	@Override
	public PaymentMethod createCreditCard() {
		return new StandardCreditCard();
	}

	@Override
	public PaymentMethod createUPI() {
		return new StandardUPI();
	}

	@Override
	public PaymentMethod createPayPal() {
		return new StandardPayPal();
	}

	@Override
	public TransactionReceipt createTransactionReceipt() {
		return new StandardReceipt();
	}

	@Override
	public FraudCheck createFraudCheck() {
		return new StandardFraudCheck();
	}
}
