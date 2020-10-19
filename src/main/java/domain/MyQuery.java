package domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyQuery {
	private String orderField;
	private String orderType = "ASC";
	private int limit = 10;
	private int page = 1;
	private List<SearchFilter> filters = new ArrayList<>();

	public MyQuery() {
	}
	
	public MyQuery(int page, int limit) {
		this.page = page;
		this.limit = limit;
	}
	
	public MyQuery(String orderField, String orderType) {
		this.setOrderField(orderField);
		this.setOrderType(orderType);
	}
	
	public MyQuery(int page, int limit, String orderField, String orderType) {
		this.page = page;
		this.limit = limit;
		this.orderField = orderField;
		this.orderType = orderType;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField.replaceAll(".*([';]+|(--)+|=).*", "");;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		if (!orderType.equalsIgnoreCase("ASC") || !orderType.equalsIgnoreCase("DESC")) {
			return ;
		}
		this.orderType = orderType;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		if (limit <= 0) {
			return ;
		}
		this.limit = limit;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			return ;
		}
		this.page = page;
	}
	
	public List<SearchFilter> getFilters() {
		return filters;
	}

	public void setFilters(List<SearchFilter> filters) {
		this.filters = filters;
	}
	
	public void addFilter(String column, String operator, String value, String type) {
		SearchFilter filter = new SearchFilter();
		filter.setColumn(column);
		filter.setOperator(operator);
		filter.setValue(value);
		filter.setType(type);
		filters.add(filter);
	}

	public int getOffset() {
		return (page - 1) * limit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + limit;
		result = prime * result + ((orderField == null) ? 0 : orderField.hashCode());
		result = prime * result + ((orderType == null) ? 0 : orderType.hashCode());
		result = prime * result + page;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyQuery other = (MyQuery) obj;
		if (limit != other.limit)
			return false;
		if (orderField == null) {
			if (other.orderField != null)
				return false;
		} else if (!orderField.equals(other.orderField))
			return false;
		if (orderType == null) {
			if (other.orderType != null)
				return false;
		} else if (!orderType.equals(other.orderType))
			return false;
		if (page != other.page)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyQuery [orderField=" + orderField + ", orderType=" + orderType + ", limit=" + limit + ", page=" + page
				+ ", filters=" + filters + "]";
	}
	
	public static String getWhereStr(List<SearchFilter> filters) {
		StringBuilder builder = new StringBuilder();
		builder.append("1=1");
		for (SearchFilter filter : filters) {
			builder.append(" AND ").append(filter.getColumn()).append(" ")
					.append(filter.getOperator()).append(" ").append(filter.getValue());
		}
		return builder.toString();
	}

}
