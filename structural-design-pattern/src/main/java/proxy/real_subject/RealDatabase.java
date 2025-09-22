package proxy.real_subject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import proxy.subject.Database;

public class RealDatabase extends Database {

	public RealDatabase(String dbName, Connection connection) {
		super(dbName);
		this.connection = connection;
	}

	@Override
	public void executeQuery(String query) throws SQLException {
		if (query.contains("person")) {
			System.out.println("---- Persons data from ---- " + this.databaseName + " DB");
			try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
				while (rs.next()) {
					System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Age: "
							+ rs.getInt("age"));
				}
			}
		} else if (query.contains("product")) {
			System.out.println("---- Products data from ---- " + this.databaseName + " DB");
			try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
				while (rs.next()) {
					System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Price: "
							+ rs.getBigDecimal("price"));
				}
			}
		}
	}
}
