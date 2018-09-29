package util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyQuery {
	private String orderfield;
	private String ordertype;
	private int limit = 10;
	private int page = 1;

	public MyQuery() {
	}

	public String getOrderfield() {
		return orderfield;
	}

	public void setOrderfield(String orderfield) {
		if (orderfield.length() > 20) {
			return ;
		}
		this.orderfield = orderfield;
	}

	public String getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(String ordertype) {
		if (!ordertype.equalsIgnoreCase("ASC") || !ordertype.equalsIgnoreCase("DESC")) {
			return ;
		}
		this.ordertype = ordertype;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getOffset() {
		return (page - 1) * limit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + limit;
		result = prime * result + ((orderfield == null) ? 0 : orderfield.hashCode());
		result = prime * result + ((ordertype == null) ? 0 : ordertype.hashCode());
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
		if (orderfield == null) {
			if (other.orderfield != null)
				return false;
		} else if (!orderfield.equals(other.orderfield))
			return false;
		if (ordertype == null) {
			if (other.ordertype != null)
				return false;
		} else if (!ordertype.equals(other.ordertype))
			return false;
		if (page != other.page)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyQuery [orderfield=" + orderfield + ", ordertype=" + ordertype + ", limit=" + limit + ", page=" + page
				+ "]";
	}

}
