package builder.builder;

import lombok.Getter;

@Getter
public class Price {

	public Price(PriceBuilder priceBuilder) {
		this.basePrice = priceBuilder.basePrice;
		this.currency = priceBuilder.currency;
		this.discount = priceBuilder.discount;
		this.finalPrice = priceBuilder.finalPrice;
	}

	private Double basePrice;
	private String currency;
	private Double discount;
	private Double finalPrice;

	public static PriceBuilder builder() {
		return new PriceBuilder();
	}

	public static class PriceBuilder {

		private Double basePrice;
		private String currency;
		private Double discount;
		private Double finalPrice;

		public PriceBuilder basePrice(Double basePrice) {
			this.basePrice = basePrice;
			return this;
		}

		public PriceBuilder currency(String currency) {
			this.currency = currency;
			return this;
		}

		public PriceBuilder discount(Double discount) {
			this.discount = discount;
			return this;
		}

		public PriceBuilder finalPrice(Double finalPrice) {
			this.finalPrice = finalPrice;
			return this;
		}

		public Price build() {
			if (basePrice <= 0) {
				throw new IllegalArgumentException("price must be positive");
			}
			if (discount <= 0) {
				throw new IllegalArgumentException("discount must be positive");
			}
			return new Price(this);
		}
	}
}
