package decorator.component;

public abstract class Pizza {

	protected double price;

	protected static final double BASE_PRICE = 50.0;

	protected Pizza(double price) {
		this.price = price;
	}

	public abstract String getDescription();

	public abstract double getPrice();

}
