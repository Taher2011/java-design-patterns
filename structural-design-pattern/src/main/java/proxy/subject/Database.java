package proxy.subject;

import java.sql.Connection;
import java.sql.SQLException;

import lombok.Getter;

@Getter
public abstract class Database {

	protected String databaseName;

	protected Connection connection;

	protected Database(String dbName) {
		this.databaseName = dbName;
	}

	public abstract void executeQuery(String query) throws SQLException;

	public void connectionclose() throws SQLException {
		// blank
	}
}
