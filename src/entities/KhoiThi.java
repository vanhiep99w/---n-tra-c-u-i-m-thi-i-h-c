package entities;

import java.io.Serializable;

public class KhoiThi implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idKhoi;
	private String nameKhoi;
	private String mon1;
	private String mon2;
	private String mon3;
	public KhoiThi() {
		// TODO Auto-generated constructor stub
	}
	public KhoiThi(int idKhoi, String nameKhoi, String mon1, String mon2, String mon3) {
		super();
		this.idKhoi = idKhoi;
		this.nameKhoi = nameKhoi;
		this.mon1 = mon1;
		this.mon2 = mon2;
		this.mon3 = mon3;
	}
	public int getIdKhoi() {
		return idKhoi;
	}
	public void setIdKhoi(int idKhoi) {
		this.idKhoi = idKhoi;
	}
	public String getNameKhoi() {
		return nameKhoi;
	}
	public void setNameKhoi(String nameKhoi) {
		this.nameKhoi = nameKhoi;
	}
	public String getMon1() {
		return mon1;
	}
	public void setMon1(String mon1) {
		this.mon1 = mon1;
	}
	public String getMon2() {
		return mon2;
	}
	@Override
	public String toString() {
		return "KhoiThi [idKhoi=" + idKhoi + ", nameKhoi=" + nameKhoi + ", mon1=" + mon1 + ", mon2=" + mon2 + ", mon3="
				+ mon3 + "]";
	}
	public void setMon2(String mon2) {
		this.mon2 = mon2;
	}
	public String getMon3() {
		return mon3;
	}
	public void setMon3(String mon3) {
		this.mon3 = mon3;
	}

}
