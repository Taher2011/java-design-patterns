package plain_singleton;

public class Singleton {

	private Singleton() {
	}

	private static Singleton singleton;

	private int data;

	public static Singleton getSingleton() {
		if (singleton == null) {
			singleton = new Singleton();
			return singleton;
		}
		return singleton;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public static void main(String[] args) {
		Singleton singleton1 = getSingleton();
		singleton1.setData(55);
		System.out.println("First reference: " + singleton1.hashCode());
		System.out.println("Singleton data value is: " + singleton1.getData());

		System.out.println();

		Singleton singleton2 = getSingleton();
		System.out.println("Second reference: " + singleton2.hashCode());
		System.out.println("Singleton data value is: " + singleton2.getData());
	}

}
