package proxy.enums;

import lombok.Getter;
import proxy.proxy_subject.ProxyDatabase;

@Getter
public enum DatabaseType {

	MYSQL("mysql"), POSTGRES("postgres");

	private String databaseName;

	private DatabaseType(String database) {
		this.databaseName = database;
	}

	public ProxyDatabase getDatabase() {
		return new ProxyDatabase(databaseName);
	}

}
