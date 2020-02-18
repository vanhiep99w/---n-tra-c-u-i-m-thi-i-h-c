package entities;

import java.io.Serializable;

public class Request implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7479498537698420700L;
	

	private String value;
	private String kindOfOrderBy;
	
	public Request() {
		// TODO Auto-generated constructor stub
	}

	public Request(String value, String kindOfOrderBy) {
		this.value = value;
		this.kindOfOrderBy = kindOfOrderBy;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getKindOfOrderBy() {
		return kindOfOrderBy;
	}

	public void setKindOfOrderBy(String kindOfOrderBy) {
		this.kindOfOrderBy = kindOfOrderBy;
	}
	
	
}
