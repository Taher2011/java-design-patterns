package adapter.adaptee;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class PaymentDTO {
	private String orderId;
	private BigDecimal amount;
	private String customerId;
	private String name;
	private String email;
	private LocalDateTime createdDate;
	private String paymentMode; // e.g., CARD, UPI, WALLET
	private String status; // Optional: e.g., SUCCESS, FAILED
	private String description;

	private PaymentDTO(PaymentDTOBuilder paymentDTOBuilder) {
		this.orderId = paymentDTOBuilder.orderId;
		this.amount = paymentDTOBuilder.amount;
		this.customerId = paymentDTOBuilder.customerId;
		this.name = paymentDTOBuilder.name;
		this.email = paymentDTOBuilder.email;
		this.createdDate = paymentDTOBuilder.createdDate;
		this.paymentMode = paymentDTOBuilder.paymentMode;
		this.status = paymentDTOBuilder.status;
		this.description = paymentDTOBuilder.description;
	}

	public static PaymentDTOBuilder builder() {
		return new PaymentDTOBuilder();
	}

	public static class PaymentDTOBuilder {
		private String orderId;
		private BigDecimal amount;
		private String customerId;
		private String name;
		private String email;
		private LocalDateTime createdDate;
		private String paymentMode; // e.g., CARD, UPI, WALLET
		private String status; // Optional: e.g., SUCCESS, FAILED
		private String description;

		public PaymentDTOBuilder orderId(String orderId) {
			this.orderId = orderId;
			return this;
		}

		public PaymentDTOBuilder amount(BigDecimal amount) {
			this.amount = amount;
			return this;
		}

		public PaymentDTOBuilder customerId(String customerId) {
			this.customerId = customerId;
			return this;
		}

		public PaymentDTOBuilder name(String name) {
			this.name = name;
			return this;
		}

		public PaymentDTOBuilder email(String email) {
			this.email = email;
			return this;
		}

		public PaymentDTOBuilder createdDate(LocalDateTime createdDate) {
			this.createdDate = createdDate;
			return this;
		}

		public PaymentDTOBuilder paymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
			return this;
		}

		public PaymentDTOBuilder status(String status) {
			this.status = status;
			return this;
		}

		public PaymentDTOBuilder description(String description) {
			this.description = description;
			return this;
		}

		public PaymentDTO build() {
			return new PaymentDTO(this);
		}

	}
}
