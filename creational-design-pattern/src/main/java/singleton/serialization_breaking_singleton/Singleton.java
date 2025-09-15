package singleton.serialization_breaking_singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Singleton implements Serializable {

	private Singleton() {
	}

	private static Singleton singleton;

	private int data;

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

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Singleton singleton1 = getSingleton();
		singleton1.setData(55);
		System.out.println("First reference: " + singleton1.hashCode());
		System.out.println("Singleton data value is: " + singleton1.getData());

		System.out.println();

		Singleton singleton2 = getSingleton();
		System.out.println("Second reference: " + singleton2.hashCode());
		System.out.println("Singleton data value is: " + singleton2.getData());

		System.out.println();

		FileOutputStream fos = new FileOutputStream("abc.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(singleton2);

		FileInputStream fis = new FileInputStream("abc.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Singleton singleton3 = (Singleton) ois.readObject();
		System.out.println("Serialized reference: " + singleton3.hashCode());
		System.out.println("SerializedSingleton data value is: " + singleton3.getData());

	}

}
