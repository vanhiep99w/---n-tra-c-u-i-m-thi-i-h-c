package entities;

import java.io.Serializable;

public class Request2 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String kind ;
	private String khoi ;
	
	public Request2() {
		// TODO Auto-generated constructor stub
	}

	public Request2(String kind, String khoi) {
		super();
		this.kind = kind;
		this.khoi = khoi;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getKhoi() {
		return khoi;
	}

	public void setKhoi(String khoi) {
		this.khoi = khoi;
	}
	
}
