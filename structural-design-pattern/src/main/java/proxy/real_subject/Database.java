package proxy.real_subject;

import lombok.Getter;
import proxy.subject.IDatabase;

@Getter
public class Database implements IDatabase {

	protected String dbName;

	public Database(String dbName) {
		this.dbName = dbName;
		connectToDB(dbName); // based on DB name will create diff db objects
	}

	private void connectToDB(String dbName) {
		try {
			// Simulate DB connection
			System.out.println("Connecting to " + dbName);
		} catch (Exception e) {
			throw new RuntimeException("Failed to connect to " + dbName, e);
		}
	}

	@Override
	public void executeQuery(String query) {
		System.out.println("executing " + dbName + " DB query: " + query);
	}
}
