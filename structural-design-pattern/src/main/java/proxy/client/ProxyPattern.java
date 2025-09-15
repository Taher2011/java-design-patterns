package proxy.client;

import proxy.enums.DatabaseTypes;
import proxy.factory.DatabaseFactory;
import proxy.subject.IDatabase;

public class ProxyPattern {

	public static void main(String[] args) {

		IDatabase database = DatabaseFactory.getDatabase(DatabaseTypes.MySQL);
		database.executeQuery("select * from users");
		System.out.println("===============================================");

		database = DatabaseFactory.getDatabase("mysql");
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
