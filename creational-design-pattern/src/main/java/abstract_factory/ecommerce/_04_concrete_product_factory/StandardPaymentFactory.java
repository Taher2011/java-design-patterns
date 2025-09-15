package abstract_factory.ecommerce._04_concrete_product_factory;

import abstract_factory.ecommerce._01_product.FraudCheck;
import abstract_factory.ecommerce._01_product.PaymentMethod;
import abstract_factory.ecommerce._01_product.TransactionReceipt;
import abstract_factory.ecommerce._02_concrete_product.StandardCreditCard;
import abstract_factory.ecommerce._02_concrete_product.StandardFraudCheck;
import abstract_factory.ecommerce._02_concrete_product.StandardPayPal;
import abstract_factory.ecommerce._02_concrete_product.StandardReceipt;
import abstract_factory.ecommerce._02_concrete_product.StandardUPI;
import abstract_factory.ecommerce._03_abstract_product_factory.AbstractPaymentFactory;

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
