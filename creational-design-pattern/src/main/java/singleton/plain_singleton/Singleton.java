package plain_singleton;

public class Singleton {

	private Singleton() {
	}

	private static Singleton singleton;

	public static Singleton getSingleton() {
		if (singleton == null) {
			return new Singleton();
		}
		return singleton;
	}

	public static void main(String[] args) {

	}

}
