package entities;

import java.io.Serializable;

public class DiemThi implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idStudent;
	private float mon1;
	private float mon2;
	private float mom3;
	public DiemThi() {
		// TODO Auto-generated constructor stub
	}
	public DiemThi(int idStudent, float mon1, float mon2, float mom3) {
		super();
		this.idStudent = idStudent;
		this.mon1 = mon1;
		this.mon2 = mon2;
		this.mom3 = mom3;
	}
	@Override
	public String toString() {
		return "DiemThi [idStudent=" + idStudent + ", mon1=" + mon1 + ", mon2=" + mon2 + ", mom3=" + mom3 + "]";
	}
	public int getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	public float getMon1() {
		return mon1;
	}
	public void setMon1(float mon1) {
		this.mon1 = mon1;
	}
	public float getMon2() {
		return mon2;
	}
	public void setMon2(float mon2) {
		this.mon2 = mon2;
	}
	public float getMom3() {
		return mom3;
	}
	public void setMom3(float mom3) {
		this.mom3 = mom3;
	}
	public float getSum() {
		return mon1+mon2+mom3;
	}
}
