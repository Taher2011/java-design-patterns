package client;

import enums.DatabaseTypes;
import factory.DatabaseFactory;
import subject.IDatabase;

public class ProxyPattern {

	public static void main(String[] args) {

		IDatabase database = DatabaseFactory.getDatabase(DatabaseTypes.MySQL);
		database.executeQuery("select * from users");
		System.out.println("===============================================");

		database = DatabaseFactory.getDatabase(DatabaseTypes.PostGRE);
		database.executeQuery("select * from users");
		System.out.println("===============================================");

		database = DatabaseFactory.getDatabase(DatabaseTypes.MySQL);
		database.executeQuery("select * from products");
		System.out.println("===============================================");

		database = DatabaseFactory.getDatabase(DatabaseTypes.PostGRE);
		database.executeQuery("select * from products");
		System.out.println("===============================================");

		database = DatabaseFactory.getDatabase("oracle");
		database.executeQuery("select * from employees");
		System.out.println("===============================================");
	}

}
