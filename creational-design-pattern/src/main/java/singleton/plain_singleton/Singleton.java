package plain_singleton;

public class Singleton {

	private Singleton() {
	}

	private static Singleton singleton;

	public static Singleton getSingleton() {
		if (singleton == null) {
			singleton = new Singleton();
			return singleton;
		}
		return singleton;
	}

	public static void main(String[] args) {
		Singleton singleton1 = getSingleton();
		System.out.println(singleton1.hashCode());

		Singleton singleton2 = getSingleton();
		System.out.println(singleton2.hashCode());
	}

}
