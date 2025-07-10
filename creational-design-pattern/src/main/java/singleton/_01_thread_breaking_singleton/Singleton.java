package _01_thread_breaking_singleton;

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

	public static Singleton getSingleton() {
		if (singleton == null) {
			singleton = new Singleton();
			return singleton;
		}
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
