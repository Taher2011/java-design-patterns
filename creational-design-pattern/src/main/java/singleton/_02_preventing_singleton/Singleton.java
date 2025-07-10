package _02_preventing_singleton;

class Thread1 extends Thread {

	public void run() {
		Singleton singleton = Singleton.getSingleton();
		singleton.setPrice(55);
		System.out.println("First reference: " + Thread.currentThread().getName() + " " + singleton.hashCode());
		System.out.println("Singleton data value is: " + singleton.getPrice());
	}

}

class Thread2 extends Thread {

	public void run() {
		Singleton singleton = Singleton.getSingleton();
		System.out.println("First reference: " + Thread.currentThread().getName() + " " + singleton.hashCode());
		System.out.println("Singleton data value is: " + singleton.getPrice());
	}

}

public class Singleton {

	private Singleton() {
	}

	private static Singleton singleton;

	private double price;

	// To make Singleton class thread-safe in java there are 3 common approaches

	// a. Synchronized Method:
	// Pros: Simple and thread-safe.
	// Cons: Synchronization overhead on every call, which can impact performance.

	public static synchronized Singleton getSingleton2() {
		if (singleton == null) {
			singleton = new Singleton();
			return singleton;
		}
		return singleton;
	}

	// b. Double-Checked Locking (Generally Preferred):
	// Pros: Better performance than full synchronization.
	// Cons: Slightly complex
	public static Singleton getSingleton() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}

	// c. Eager Initialization (Alternative):
	// private static final Singleton singleton = new Singleton();
	// Pros: No synchronization overhead, instance is created at class loading time.
	// Cons: Does not provide the benefits of lazy initialization.
	public static Singleton getSingleton3() {
		return singleton;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();

		t1.start();
		t2.start();

//	    alternative approach using lambda

//		new Thread(() -> {
//			Singleton singleton = Singleton.getSingleton();
//			singleton.setPrice(55);
//			System.out.println("First reference: " + Thread.currentThread().getName() + " " + singleton.hashCode());
//			System.out.println("Singleton data value is: " + singleton.getPrice());
//		}).start();
//
//		new Thread(() -> {
//			Singleton singleton = Singleton.getSingleton();
//			System.out.println("First reference: " + Thread.currentThread().getName() + " " + singleton.hashCode());
//			System.out.println("Singleton data value is: " + singleton.getPrice());
//		}).start();
	}

}
