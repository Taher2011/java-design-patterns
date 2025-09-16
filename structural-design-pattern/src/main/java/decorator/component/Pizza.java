package decorator.component;

public abstract class Pizza {

	protected static final double BASE_PRICE = 50.0;

	protected double price;

	protected Pizza(double price) {
		this.price = price;
	}

	public abstract String getDescription();

	public abstract double getPrice();

}
