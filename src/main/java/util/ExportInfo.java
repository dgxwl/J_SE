package util;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;

public class ExportInfo {

	public static String DATATYPE_ORGVALUE = "ORGVALUE";
	public static String DATATYPE_ENUM = "ENUM";

	public String dataType = DATATYPE_ORGVALUE;
	public LinkedHashMap<Object, String> enumPair;
	private String columnName;

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public LinkedHashMap<Object, String> getEnumPair() {
		return enumPair;
	}

	public void setEnumPair(LinkedHashMap<Object, String> enumPair) {
		this.enumPair = enumPair;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public ExportInfo(String columnname) {
		this.columnName = columnname;
	}

	public ExportInfo(String columnname, LinkedHashMap<Object, String> enumPair) {
		this.columnName = columnname;
		this.enumPair = enumPair;
		this.dataType = DATATYPE_ENUM;
	}

	public String getValue(Object obj) {
		if (obj == null)
			return null;
		if (DATATYPE_ORGVALUE.equalsIgnoreCase(this.getDataType())) {
			if (obj instanceof Integer) {
				return obj.toString();
			} else if (obj instanceof BigDecimal) {
				return ((BigDecimal) obj).toPlainString();
			} else if (obj instanceof Double) {
				return obj.toString();
			} else if (obj instanceof Date) {
				return DateUtil.getFormattedDate((Date) obj, "yyyy-MM-dd HH:mm");
			} else if (obj instanceof Float) {
				return obj.toString();
			}
			return obj.toString();
		} else if (DATATYPE_ENUM.equalsIgnoreCase(this.getDataType())) {
			String key = obj.toString();
			if (this.enumPair.containsKey(key)) {
				return this.enumPair.get(key);
			} else
				return "";
		} else
			return obj.toString();

	}
}
