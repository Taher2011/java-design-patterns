package reflection_preventing_singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton {

	private Singleton() {
		if (singleton != null) {
			throw new InstantiationError("creating of this object is not allowed.");
		}
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

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Singleton singleton1 = getSingleton();
		singleton1.setData(55);
		System.out.println("First reference: " + singleton1.hashCode());
		System.out.println("Singleton data value is: " + singleton1.getData());

		System.out.println();

		Constructor<?>[] declaredConstructors = Singleton.class.getDeclaredConstructors();
		for (Constructor<?> constructor : declaredConstructors) {
			constructor.setAccessible(true);
			Singleton reflectionedSingleton = (Singleton) constructor.newInstance();
			System.out.println("Second reference: " + reflectionedSingleton.hashCode());
			System.out.println("Singleton data value is: " + reflectionedSingleton.getData());
		}

	}

}
