package proxy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DatabaseConnectionManager {

	private DatabaseConnectionManager() {
	}

	private static Map<String, Connection> connections = new HashMap<>();

	public static synchronized Connection databaseConnection(String databaseName) throws SQLException {
		Connection connection = connections.get(databaseName);
		if (connection == null) {
			if (databaseName.equalsIgnoreCase("mysql")) {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			} else if (databaseName.equalsIgnoreCase("postgres")) {
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "postgres", "root");
			} else {
				throw new IllegalArgumentException("Unsupported database: " + databaseName);
			}
			connections.put(databaseName, connection);
		}
		return connections.get(databaseName);
	}

	public static synchronized void closeConnection(String databaseName) throws SQLException {
		Connection connection = connections.get(databaseName);
		if (connection != null && !connection.isClosed()) {
			connection.close();
			System.out.println("closed " + databaseName + " database connection");
			connections.remove(databaseName);
		}
	}

	public static synchronized void closeAllConnections() throws SQLException {
		for (Connection conn : connections.values()) {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		}
		connections.clear();
	}
}
