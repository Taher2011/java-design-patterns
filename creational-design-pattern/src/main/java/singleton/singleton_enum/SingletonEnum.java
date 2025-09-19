package singleton.singleton_enum;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*Enum-based singleton is thread-safe, serialization-safe, clone-safe, reflection-safe.*/
enum Singleton {

	INSTANCE();

	private int data = 5;

	public Singleton getInstance() {
		return INSTANCE;
	}

	public int getData() {
		return data;
	}

	protected void setData(int data) {
		this.data = data;
	}

}

public class SingletonEnum {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Singleton singleton1 = Singleton.INSTANCE;
		singleton1.setData(10);
		Singleton singleton2 = Singleton.INSTANCE;
		System.out.println(singleton2.getData());

		/* compile time error as enum by default blocks cloning */
		// Singleton singleton3 = (Singleton) singleton2.clone();

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abc.txt"));
		oos.writeObject(singleton2);
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("abc.txt"));
		Singleton singleton3 = (Singleton) ois.readObject();
		ois.close();

		/*
		 * serialization gives the same object by default dont need to overwrite
		 * readResolve method
		 */
		System.out.println(singleton3 == singleton2); // true

		/* it gives java.lang.IllegalArgumentException */
		Constructor<?>[] declaredConstructors = Singleton.class.getDeclaredConstructors();
		for (Constructor<?> constructor : declaredConstructors) {
			constructor.setAccessible(true);
			Singleton singleton4 = (Singleton) constructor.newInstance();
			System.out.println(singleton4 == singleton2); // true
		}

	}
}
