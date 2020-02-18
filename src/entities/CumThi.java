package entities;

import java.io.Serializable;

public class CumThi implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCum;
	private String nameCum;
	private String manOrg;
	
	public CumThi() {
		// TODO Auto-generated constructor stub
	}
	public CumThi(int idCum, String nameCum, String manOrg) {
		super();
		this.idCum = idCum;
		this.nameCum = nameCum;
		this.manOrg = manOrg;
	}
	public int getIdCum() {
		return idCum;
	}
	public void setIdCum(int idCum) {
		this.idCum = idCum;
	}
	public String getNameCum() {
		return nameCum;
	}
	public void setNameCum(String nameCum) {
		this.nameCum = nameCum;
	}
	public String getManOrg() {
		return manOrg;
	}
	public void setManOrg(String manOrg) {
		this.manOrg = manOrg;
	}
	@Override
	public String toString() {
		return "CumThi [idCum=" + idCum + ", nameCum=" + nameCum + ", manOrg=" + manOrg + "]";
	}
	
}
