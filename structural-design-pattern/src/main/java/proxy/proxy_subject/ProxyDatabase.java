package proxy_subject;

import real_subject.Database;
import subject.IDatabase;

public class ProxyDatabase implements IDatabase {

	private String dbName;

	private Database dataBase;

	public ProxyDatabase(String dbName) {
		this.dbName = dbName;
	}

	@Override
	public void executeQuery(String query) {
		String key = dbName + ":" + query;
		// Validation
		if (!isValidQuery(query)) {
			System.out.println("Invalid query: " + query);
			return;
		}
		if (dataBase == null) {
			dataBase = new Database(this.dbName);
		}
		dataBase.executeQuery(query);
	}

	private boolean isValidQuery(String query) {
		return query != null && !query.trim().isEmpty();
	}

}
