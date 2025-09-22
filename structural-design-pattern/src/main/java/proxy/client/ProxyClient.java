package proxy.client;

import java.sql.SQLException;

import proxy.enums.DatabaseType;
import proxy.enums.QueryType;
import proxy.proxy_subject.ProxyDatabase;

public class ProxyClient {

	public static void main(String[] args) throws SQLException {

		ProxyDatabase mysqlDatabase1 = DatabaseType.MYSQL.getDatabase();
		mysqlDatabase1.setCurrentUser("admin");
		mysqlDatabase1.executeQuery(QueryType.PERSON_SELECT.getQuery());

		System.out.println("====================================================================");

		ProxyDatabase mysqlDatabase2 = DatabaseType.MYSQL.getDatabase();
		mysqlDatabase2.setCurrentUser("super_user");
		mysqlDatabase2.executeQuery(QueryType.PRODUCT_SELECT.getQuery());

		System.out.println("====================================================================");

		ProxyDatabase mysqlDatabase3 = DatabaseType.POSTGRES.getDatabase();
		mysqlDatabase3.setCurrentUser("admin");
		mysqlDatabase3.executeQuery(QueryType.PRODUCT_SELECT.getQuery());

		System.out.println("====================================================================");

		ProxyDatabase mysqlDatabase4 = DatabaseType.POSTGRES.getDatabase();
		mysqlDatabase4.setCurrentUser("super_user");
		mysqlDatabase4.executeQuery(QueryType.PERSON_SELECT.getQuery());

		System.out.println("====================================================================");

		System.out.println("Closing all DB Connections after use:");

		mysqlDatabase1.connectionclose();
		mysqlDatabase2.connectionclose();
		mysqlDatabase3.connectionclose();
		mysqlDatabase4.connectionclose();

		System.out.println("====================================================================");

		mysqlDatabase4.executeQuery(QueryType.PERSON_SELECT.getQuery());
		mysqlDatabase4.executeQuery(QueryType.PRODUCT_SELECT.getQuery());

		System.out.println("====================================================================");

		System.out.println("Closing all DB Connections after use:");
		mysqlDatabase4.connectionclose();
	}

}
