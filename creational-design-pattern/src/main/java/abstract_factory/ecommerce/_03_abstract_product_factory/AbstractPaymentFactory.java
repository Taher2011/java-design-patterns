package abstract_factory.ecommerce._03_abstract_product_factory;

import java.util.EnumMap;
import java.util.Map;

import abstract_factory.ecommerce._01_product.FraudCheck;
import abstract_factory.ecommerce._01_product.PaymentMethod;
import abstract_factory.ecommerce._01_product.TransactionReceipt;
import abstract_factory.ecommerce._04_concrete_product_factory.SecurePaymentFactory;
import abstract_factory.ecommerce._04_concrete_product_factory.StandardPaymentFactory;
import abstract_factory.ecommerce._05_enum.ModeType;

public abstract class AbstractPaymentFactory {

	private static Map<ModeType, AbstractPaymentFactory> factories = new EnumMap<>(ModeType.class);
	static {
		factories.put(ModeType.SECURE, new SecurePaymentFactory());
		factories.put(ModeType.STANDARD, new StandardPaymentFactory());
	}

	public static AbstractPaymentFactory createPaymentFactory(ModeType modeType) {
		AbstractPaymentFactory abstractPaymentFactory = factories.get(modeType);
		if (abstractPaymentFactory == null) {
			throw new IllegalArgumentException("invalid mode type");
		}
		return abstractPaymentFactory;
	}

	public abstract PaymentMethod createCreditCard();

	public abstract PaymentMethod createUPI();

	public abstract PaymentMethod createPayPal();

	public abstract TransactionReceipt createTransactionReceipt();

	public abstract FraudCheck createFraudCheck();
}
