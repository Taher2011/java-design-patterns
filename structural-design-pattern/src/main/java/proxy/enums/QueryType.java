package proxy.enums;

import lombok.Getter;

@Getter
public enum QueryType {

	PRODUCT_SELECT("select * from products"), PERSON_SELECT("select * from person");

	private String query;

	private QueryType(String query) {
		this.query = query;
	}
}
