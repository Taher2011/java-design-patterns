package clone_preventing_singleton;

public class Singleton implements Cloneable {

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

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Singleton singleton1 = getSingleton();
		System.out.println("First reference: " + singleton1.hashCode());
		System.out.println("Singleton data value is: " + singleton1.getData());

		System.out.println();

		Singleton singleton2 = getSingleton();
		System.out.println(singleton2.hashCode());
		System.out.println("Second reference: " + singleton2.hashCode());
		System.out.println("Singleton data value is: " + singleton2.getData());

		System.out.println();

		Singleton singleton3 = (Singleton) singleton2.clone();
		System.out.println(singleton3.hashCode());
		System.out.println("Cloned reference: " + singleton3.hashCode());
		System.out.println("ClonedSingleton data value is: " + singleton3.getData());

	}

}
