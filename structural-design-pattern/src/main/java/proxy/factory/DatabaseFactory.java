package proxy.factory;

import java.util.HashMap;
import java.util.Map;

import proxy.enums.DatabaseTypes;
import proxy.proxy_subject.ProxyDatabase;

public class DatabaseFactory {

	private DatabaseFactory() {
	}

	private static Map<String, ProxyDatabase> map = new HashMap<>();

	public static ProxyDatabase getDatabase(DatabaseTypes type) {
		return getDatabase(type.getDbName());
	}

	public static ProxyDatabase getDatabase(String dbName) {
		if (dbName == null || dbName.trim().isEmpty()) {
			throw new IllegalArgumentException("Database name cannot be null or empty");
		}
		synchronized (map) {
			if (map.containsKey(dbName)) {
				return map.get(dbName);
			}
			ProxyDatabase proxyDatabase = new ProxyDatabase(dbName);
			map.put(dbName, proxyDatabase);
			return proxyDatabase;
		}
	}
}
