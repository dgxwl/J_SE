package domain;

public class SearchFilter {
	private static final String STRING = "string";
	private static final String NUMBER = "number";
	private static final String DATE = "date";

	private String column;
	private String operator;
	private String value;

	public SearchFilter() {
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {

		this.value = value.replaceAll(".*([';]+|(--)+|=).*", "");
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public void parseCondition(String type) {
		if (!type.equals(STRING) && !type.equals(NUMBER) && !type.equals(DATE))
			throw new SearchFilterException("type error: " + type);

		parseColumn();
		parseOperator(type);
		parseValue(type);
	}

	private void parseColumn() {
		column = column.replaceAll(".*([';]+|(--)+|=).*", "");
	}

	private void parseOperator(String type) {
		switch (operator) {
		case "eq":
			operator = "=";
			return;
		case "neq":
			operator = "!=";
			return;
		case "isn":
			operator = "IS NULL";
			return;
		case "isnn":
			operator = "IS NOT NULL";
			return;
		case "in":
			operator = "IN";
			return;
		}
		if (type.equals(STRING)) {
			switch (operator) {
			case "l":
				operator = "LIKE";
				break;
			case "nl":
				operator = "NOT LIKE";
				break;
			default:
				throw new SearchFilterException("oper error: " + operator);
			}
		} else {
			switch (operator) {
			case "gt":
				operator = ">";
				break;
			case "lt":
				operator = "<";
				break;
			case "gte":
				operator = ">=";
				break;
			case "lte":
				operator = "<=";
				break;
			case "bw":
				String[] data = value.split("-");
				if (data.length != 2)
					throw new SearchFilterException("value error: " + value);
				operator = "BETWEEN "+ data[0] + " AND " + data[1];
				break;
			default:
				throw new SearchFilterException("oper error: " + operator);
			}
		}
	}
	
	private void parseValue(String type) {
		value = value.replaceAll(".*([';]+|(--)+|=).*", "");
		
		if (!type.equals(STRING)) {
			if (value.matches("\\w*[a-zA-Z]\\w*")) {
				throw new SearchFilterException("value error: " + value);
			}
		}
		boolean NaN = !type.equals(NUMBER);
		if (operator.equals("IN")) {
			StringBuilder builder = new StringBuilder();
			builder.append("(");
			String[] data = value.split("\\s*,\\s*");
			if (data.length < 1) {
				throw new SearchFilterException("value error: " + value);
			}
			if (NaN) builder.append('\'');
			builder.append(data[0]);
			if (NaN) builder.append('\'');
			for (int i = 1; i < data.length; i++) {
				builder.append(',');
				if (NaN) builder.append('\'');
				builder.append(data[i]);
				if (NaN) builder.append('\'');
			}
			builder.append(')');
			value = builder.toString();
		} else if (operator.equals("=") || operator.equals("!=")) {
			if (NaN) value = "\'" + value + "\'";
		} else if (operator.equals("LIKE") || operator.equals("NOT LIKE")) {
			value = "'%" + value + "%'";
		} else if (operator.equals("IS NULL") || operator.equals("IS NOT NULL") || operator.startsWith("BETWEEN")) {
			value = "";
		} else {
			if (type.equals(STRING)) throw new SearchFilterException("value error: " + value);
			if (type.equals(DATE)) value = "\'" + value + "\'";
		}
	}
	
}
