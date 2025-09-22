package proxy.proxy_subject;

import java.sql.Connection;
import java.sql.SQLException;

import lombok.Getter;
import proxy.real_subject.RealDatabase;
import proxy.subject.Database;
import proxy.util.DatabaseConnectionManager;

@Getter
public class ProxyDatabase extends Database {

	private String currentUser;

	private RealDatabase realDatabase;

	private boolean isClosed;

	public ProxyDatabase(String dbName) {
		super(dbName);
	}

	@Override
	public void executeQuery(String query) throws SQLException {

		// Authentication
		if (!isAuthorized()) {
			throw new SecurityException("Access Denied for user: " + getCurrentUser());
		}

		// Validation
		validateQuery(query);

		if (isClosed || (connection != null && connection.isClosed())) {
			this.connection = initializeDB();
			this.isClosed = false;
		}

		// Lazy initialization
		if (realDatabase == null) {
			this.connection = initializeDB();
			realDatabase = new RealDatabase(databaseName, connection);
		}
		realDatabase.executeQuery(query);
	}

	private boolean isAuthorized() {
		return "admin".equalsIgnoreCase(getCurrentUser()) || "super_user".equalsIgnoreCase(getCurrentUser());
	}

	private void validateQuery(String query) {
		if (query == null || query.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid query");
		}
	}

	private Connection initializeDB() throws SQLException {
		Connection connection = DatabaseConnectionManager.databaseConnection(databaseName);
		return connection;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	@Override
	public void connectionclose() throws SQLException {
		DatabaseConnectionManager.closeConnection(databaseName);
		reset();
	}

	private void reset() {
		this.isClosed = true;
		this.connection = null;
		this.realDatabase = null;
	}
}
