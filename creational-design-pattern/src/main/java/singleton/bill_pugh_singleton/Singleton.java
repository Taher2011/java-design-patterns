package singleton.bill_pugh_singleton;

public class Singleton {

	private Singleton() {
	}

	private int data;

//	The Bill Pugh Singleton (or Initialization-on-Demand Holder Idiom) is a singleton pattern implementation
//	that ensures lazy initialization and thread-safety without using the synchronized keyword.
//	It uses a private static inner class to hold the singleton instance, which is only loaded when getInstance() is called.

//	Bill Pugh Singleton is thread-safe because JVM guarantees that static inner class initialization is atomic and performed only once, even in multi-threaded environments

	private static class SingletonHelper {
		static final Singleton singleton = new Singleton();
	}

	public static Singleton getSingleton() {
		return SingletonHelper.singleton;
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
