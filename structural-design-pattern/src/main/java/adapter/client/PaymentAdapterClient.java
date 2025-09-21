package adapter.client;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import adapter.adaptee.PayPal;
import adapter.adaptee.Stripe;
import adapter.adapter.PaymentAdapter;
import adapter.target.DefaultPaymentProcessor;
import adapter.target.PaymentProcessor;
import adapter.target.PaymentProcessorDTO;

public class PaymentAdapterClient {
	public static void main(String[] args) {
		// Legacy payment processing
		System.out.println("Using Legacy DefaultPaymentProcessor:");
		PaymentProcessor legacyProcessor = new DefaultPaymentProcessor();
		PaymentProcessorDTO legacyDTO = PaymentProcessorDTO.builder().txnOrderReference("TXN001")
				.totalAmount(new BigDecimal("500.00")).userIdentifier("CUST001").firstName("Rahul").lastName("Sharma")
				.email("rahul.sharma@example.com").paymentRequestTimestamp(LocalDateTime.now()).paymentChannel("CARD")
				.paymentStatus("PENDING").txnNarration("Legacy payment for order").build();
		legacyProcessor.processPayment(legacyDTO);

		// Modern payment processing using Adapter pattern with Stripe
		System.out.println("\nUsing Adapter Pattern with Stripe:");
		PaymentProcessor stripeProcessor = new PaymentAdapter(new Stripe());
		PaymentProcessorDTO stripeDTO = PaymentProcessorDTO.builder().txnOrderReference("TXN002")
				.totalAmount(new BigDecimal("1000.00")).userIdentifier("CUST002").firstName("Priya").lastName("Verma")
				.email("priya.verma@example.com").paymentRequestTimestamp(LocalDateTime.now()).paymentChannel("UPI")
				.paymentStatus("PENDING").txnNarration("Stripe payment for subscription").build();
		stripeProcessor.processPayment(stripeDTO);

		// Modern payment processing using Adapter pattern with PayPal
		System.out.println("\nUsing Adapter Pattern with PayPal:");
		PaymentProcessor payPalProcessor = new PaymentAdapter(new PayPal());
		PaymentProcessorDTO payPalDTO = PaymentProcessorDTO.builder().txnOrderReference("TXN003")
				.totalAmount(new BigDecimal("750.00")).userIdentifier("CUST003").firstName("Amit").lastName("Patel")
				.email("amit.patel@example.com").paymentRequestTimestamp(LocalDateTime.now()).paymentChannel("WALLET")
				.paymentStatus("PENDING").txnNarration("PayPal payment for purchase").build();
		payPalProcessor.processPayment(payPalDTO);
	}
}