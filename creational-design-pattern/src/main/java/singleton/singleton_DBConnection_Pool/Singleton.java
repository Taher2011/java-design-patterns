package singleton.singleton_DBConnection_Pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class DBConnectionPool {

	private static volatile DBConnectionPool dbConnectionPool;

	private static final int MAX_CONN_LIMITS = 5;

	private final List<Connection> connections;

	private volatile boolean isShutDown;

	private DBConnectionPool() throws SQLException {
		connections = new ArrayList<>(MAX_CONN_LIMITS);
		initializePool();
	}

	private void initializePool() throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String password = "root";

		for (int i = 0; i < MAX_CONN_LIMITS; i++) {
			try {
				Connection connection = DriverManager.getConnection(url, user, password);
				connections.add(connection);
			} catch (SQLException e) {
				// Close any already created connections before failing
				connections.clear();
				throw new SQLException("Failed to initialize connection pool at index " + i + ": " + e.getMessage(), e);
			}
		}
	}

	public static DBConnectionPool getConnectionPoolInstance() throws SQLException {
		if (dbConnectionPool == null) {
			synchronized (DBConnectionPool.class) {
				if (dbConnectionPool == null) {
					dbConnectionPool = new DBConnectionPool();
				}
			}
		}
		return dbConnectionPool;
	}

	public synchronized Connection getDBConnection() throws SQLException {
		if (isShutDown) {
			throw new SQLException("Connection pool is closed");
		}
		if (connections.isEmpty()) {
			throw new SQLException("No connections available in the pool");
		}
		Connection connection = connections.remove(0);
		if (connection.isClosed()) {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "postgres", "root");
		}
		return connection;
	}

	public synchronized void releaseDBConnection(Connection connection) throws SQLException {
		if (isShutDown) {
			throw new SQLException("Connection pool is closed");
		}
		if (connection != null && !connection.isClosed() && connections.size() < MAX_CONN_LIMITS) {
			connections.add(connection);
		}
	}

	public synchronized void closePool() throws SQLException {
		if (isShutDown) {
			return;
		}
		isShutDown = true;
		for (Connection connection : connections) {
			if (connection != null && !connection.isClosed()) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.err.println("Error closing connection: " + e.getMessage());
				}
			}
		}
		connections.clear();
	}
}

public class Singleton {
	public static void main(String[] args) {
		try {
			DBConnectionPool pool1 = DBConnectionPool.getConnectionPoolInstance();
			Connection conn1 = pool1.getDBConnection();
			Connection conn2 = pool1.getDBConnection();

			pool1.releaseDBConnection(conn1);
			pool1.releaseDBConnection(conn2);

			Connection conn3 = pool1.getDBConnection();
			pool1.releaseDBConnection(conn3);

			pool1.closePool();
			System.out.println("Pool closed");

			DBConnectionPool pool3 = DBConnectionPool.getConnectionPoolInstance();
		} catch (SQLException e) {
			System.err.println("Database error: " + e.getMessage());
		}
	}
}