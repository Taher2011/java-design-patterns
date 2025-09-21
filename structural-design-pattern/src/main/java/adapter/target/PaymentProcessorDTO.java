package adapter.target;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PaymentProcessorDTO {
	private String txnOrderReference;
	private BigDecimal totalAmount;
	private String userIdentifier;
	private String firstName;
	private String lastName;
	private String contactEmail;
	private LocalDateTime paymentRequestTimestamp;
	private String paymentChannel; // CARD, UPI, etc.
	private String paymentStatus;
	private String txnNarration;

	private PaymentProcessorDTO(PaymentProcessorDTOBuilder paymentProcessorDTOBuilder) {
		this.txnOrderReference = paymentProcessorDTOBuilder.txnOrderReference;
		this.totalAmount = paymentProcessorDTOBuilder.totalAmount;
		this.userIdentifier = paymentProcessorDTOBuilder.userIdentifier;
		this.firstName = paymentProcessorDTOBuilder.firstName;
		this.lastName = paymentProcessorDTOBuilder.lastName;
		this.contactEmail = paymentProcessorDTOBuilder.contactEmail;
		this.paymentRequestTimestamp = paymentProcessorDTOBuilder.paymentRequestTimestamp;
		this.paymentChannel = paymentProcessorDTOBuilder.paymentChannel;
		this.paymentStatus = paymentProcessorDTOBuilder.paymentStatus;
		this.txnNarration = paymentProcessorDTOBuilder.txnNarration;
	}

	public static PaymentProcessorDTOBuilder builder() {
		return new PaymentProcessorDTOBuilder();
	}

	public static class PaymentProcessorDTOBuilder {
		private String txnOrderReference;
		private BigDecimal totalAmount;
		private String userIdentifier;
		private String firstName;
		private String lastName;
		private String contactEmail;
		private LocalDateTime paymentRequestTimestamp;
		private String paymentChannel; // CARD, UPI, etc.
		private String paymentStatus;
		private String txnNarration;

		public PaymentProcessorDTOBuilder txnOrderReference(String txnOrderReference) {
			this.txnOrderReference = txnOrderReference;
			return this;
		}

		public PaymentProcessorDTOBuilder totalAmount(BigDecimal totalAmount) {
			this.totalAmount = totalAmount;
			return this;
		}

		public PaymentProcessorDTOBuilder userIdentifier(String userIdentifier) {
			this.userIdentifier = userIdentifier;
			return this;
		}

		public PaymentProcessorDTOBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public PaymentProcessorDTOBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public PaymentProcessorDTOBuilder email(String contactEmail) {
			this.contactEmail = contactEmail;
			return this;
		}

		public PaymentProcessorDTOBuilder paymentRequestTimestamp(LocalDateTime paymentRequestTimestamp) {
			this.paymentRequestTimestamp = paymentRequestTimestamp;
			return this;
		}

		public PaymentProcessorDTOBuilder paymentChannel(String paymentChannel) {
			this.paymentChannel = paymentChannel;
			return this;
		}

		public PaymentProcessorDTOBuilder paymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
			return this;
		}

		public PaymentProcessorDTOBuilder txnNarration(String txnNarration) {
			this.txnNarration = txnNarration;
			return this;
		}

		public PaymentProcessorDTO build() {
			return new PaymentProcessorDTO(this);
		}

	}
}
