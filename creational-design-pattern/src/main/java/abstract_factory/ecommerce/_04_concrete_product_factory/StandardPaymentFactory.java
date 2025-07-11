package _04_concrete_product_factory;

import _01_product.FraudCheck;
import _01_product.PaymentMethod;
import _01_product.TransactionReceipt;
import _02_concrete_product.StandardCreditCard;
import _02_concrete_product.StandardFraudCheck;
import _02_concrete_product.StandardPayPal;
import _02_concrete_product.StandardReceipt;
import _02_concrete_product.StandardUPI;
import _03_abstract_product_factory.AbstractPaymentFactory;

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
