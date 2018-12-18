package domain;

public class SearchFilter {
	private static final String STRING = "string";
	private static final String NUMBER = "number";
	private static final String BOOL = "bool";
	private static final String DATE = "date";

	private String column;
	private String operator;
	private String value;
	private String type;

	public SearchFilter() {
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column.replaceAll(".*([';]+|(--)+|=).*", "");
	}

	private boolean o = true;
	public String getOperator() {
		if (o) {
			boolean common = false;
			switch (operator) {  //common
			case "eq":
				operator = "=";
				common = true;
				break;
			case "neq":
				operator = "!=";
				common = true;
				break;
			case "isn":
				operator = "IS NULL";
				common = true;
				break;
			case "isnn":
				operator = "IS NOT NULL";
				common = true;
				break;
			case "in":
				operator = "IN";
				common = true;
				break;
			}
			if (common) {return operator;}
			
			if (BOOL.equals(type)) {
				throw new SearchFilterException("type 'bool' invalid oper: " + operator);
			}
			if (STRING.equals(type)) {
				switch (operator) {
				case "l":
					operator = "LIKE";
					break;
				case "nl":
					operator = "NOT LIKE";
					break;
				default:
					throw new SearchFilterException("type 'string' invalid oper: " + operator);
				}
			} else {  //else if (type.equals(NUMBER) || type.equals(DATE))
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
						throw new SearchFilterException("oper 'bw' invalid value: " + value);
					operator = "BETWEEN "+ data[0] + " AND " + data[1];
					break;
				default:
					throw new SearchFilterException("type 'number/date' invalid oper: " + operator);
				}
			}
			o = false;
		}
		return operator;
	}

	public void setOperator(String operator) {
		if (!"eq".equals(operator) && !"neq".equals(operator) && !"isn".equals(operator)
				&& !"isnn".equals(operator) && !"in".equals(operator) && !"l".equals(operator)
				&& !"nl".equals(operator) && !"gt".equals(operator) && !"lt".equals(operator)
				&& !"gte".equals(operator) && !"lte".equals(operator) && !"bw".equals(operator))
		{
			throw new SearchFilterException("invalid oper: " + operator);
		}
		this.operator = operator;
	}

	private boolean v = true;
	public String getValue() {
		if (v) {
			if (BOOL.equals(type)) {
				if (!"true".equalsIgnoreCase(value) && !"false".equalsIgnoreCase(value)
						 && !"t".equalsIgnoreCase(value) && !"f".equalsIgnoreCase(value)) {
					throw new SearchFilterException("type 'bool' value error: " + value);
				}
				if ("t".equalsIgnoreCase(value)) {
					value = "true";
				} else if ("f".equalsIgnoreCase(value)) {
					value = "false";
				}
			}
			if (!BOOL.equals(type) && !type.equals(STRING)) {
				if (!(operator.equals("IS NULL") || operator.equals("IS NOT NULL")) && value.matches("\\w*[a-zA-Z]\\w*")) {
					throw new SearchFilterException("type 'number/date' invalid value: " + value);
				}
			}
			boolean NaN = !NUMBER.equals(type);
			if (operator.equals("IN")) {
				StringBuilder builder = new StringBuilder();
				builder.append("(");
				String[] data = value.split("\\s*,\\s*");
				if (data.length < 1) {
					throw new SearchFilterException("oper 'in' invalid value: " + value);
				}

				for (int i = 0; i < data.length; i++) {
					if (NUMBER.equals(type) && !data[i].matches("[1-9]+(\\.\\d+)?")) {
						throw new SearchFilterException("type 'number' and oper 'in' invalid value: " + data[i]);
					}
					
					if (NaN) builder.append('\'');
					builder.append(data[i]);
					if (NaN) builder.append('\'');
					if (i != data.length - 1) {
						builder.append(',');
					}
				}
				builder.append(')');
				value = builder.toString();
			} else if (operator.equals("=") || operator.equals("!=")) {
				if (NaN && !BOOL.equals(type)) value = "\'" + value + "\'";
			} else if (operator.equals("LIKE") || operator.equals("NOT LIKE")) {
				value = "'%" + value + "%'";
			} else if (operator.equals("IS NULL") || operator.equals("IS NOT NULL") || operator.startsWith("BETWEEN")) {
				value = "";
			} else {
				if (type.equals(STRING)) throw new SearchFilterException("type 'string' invalid value: " + value);
				if (type.equals(DATE)) value = "\'" + value + "\'";
			}
			v = false;
		}
		return value;
	}

	public void setValue(String value) {
		this.value = value.replaceAll(".*([';]+|(--)+|=).*", "");
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		if (!STRING.equals(type) && !NUMBER.equals(type) && !DATE.equals(type) && !BOOL.equals(type))
			throw new SearchFilterException("invalid type: " + type);
		this.type = type;
	}
	
	@Override
	public String toString() {
		return getColumn() + " " + getOperator() + " " + getValue();
	}
	
	public static void main(String[] args) {
		SearchFilter filter = new SearchFilter();
		filter.setType("string");
		filter.setColumn("col");
		filter.setOperator("nl");
		filter.setValue("99,w98");
		System.out.println(filter);
	}
}
