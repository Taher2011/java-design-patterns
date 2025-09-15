package proxy.enums;

import lombok.Getter;

@Getter
public enum DatabaseTypes {

	MySQL("mysql"), PostGRE("postgre");

	private String dbName;

	private DatabaseTypes(String dbName) {
		this.dbName = dbName;
	}
}
