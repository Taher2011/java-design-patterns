package builder.builder;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class Product {

	public Product(ProductBuilder productBuilder) {
		this.id = productBuilder.id;
		this.price = productBuilder.price;
		this.color = productBuilder.color;
		this.name = productBuilder.name;
		this.modelNo = productBuilder.modelNo;
		this.expiryDate = productBuilder.expiryDate;
	}

	private int id;
	private Price price;
	private String color;
	private String name;
	private String modelNo;
	private LocalDateTime expiryDate;

	public static ProductBuilder builder() {
		return new ProductBuilder();
	}

	public static class ProductBuilder {

		private int id;
		private Price price;
		private String color;
		private String name;
		private String modelNo;
		private LocalDateTime expiryDate;

		public ProductBuilder id(int id) {
			this.id = id;
			return this;
		}

		public ProductBuilder price(Price price) {
			this.price = price;
			return this;
		}

		public ProductBuilder color(String color) {
			this.color = color;
			return this;
		}

		public ProductBuilder name(String name) {
			this.name = name;
			return this;
		}

		public ProductBuilder modelNo(String modelNo) {
			this.modelNo = modelNo;
			return this;
		}

		public ProductBuilder expiryDate(LocalDateTime expiryDate) {
			this.expiryDate = expiryDate;
			return this;
		}

		public Product build() {
			if (id <= 0) {
				throw new IllegalArgumentException("id must be positive");
			}
			if (name == null || name.isEmpty()) {
				throw new IllegalArgumentException("name cannot be null or empty");
			}
			return new Product(this);
		}

	}
}
