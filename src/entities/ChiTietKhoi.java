package entities;

import java.io.Serializable;

public class ChiTietKhoi implements Serializable{

	private KhoiThi khoi;
	private int soLuongStudent;
	private int soLuongNam;
	private int soLuongNu;
	private Float diemTrungBinhmon1;
	private Float diemTrungBinhmon2;
	private Float diemTrungBinhmon3;
	private Student thiSinhDiemCaoNhat;
	
	
	public ChiTietKhoi() {
		// TODO Auto-generated constructor stub
	}


	public KhoiThi getKhoi() {
		return khoi;
	}


	public void setKhoi(KhoiThi khoi) {
		this.khoi = khoi;
	}


	public int getSoLuongStudent() {
		return soLuongStudent;
	}


	public void setSoLuongStudent(int soLuongStudent) {
		this.soLuongStudent = soLuongStudent;
	}


	public int getSoLuongNam() {
		return soLuongNam;
	}


	public void setSoLuongNam(int soLuongNam) {
		this.soLuongNam = soLuongNam;
	}


	public int getSoLuongNu() {
		return soLuongNu;
	}


	public void setSoLuongNu(int soLuongNu) {
		this.soLuongNu = soLuongNu;
	}


	public Float getDiemTrungBinhmon1() {
		return diemTrungBinhmon1;
	}


	public void setDiemTrungBinhmon1(Float diemTrungBinhmon1) {
		this.diemTrungBinhmon1 = diemTrungBinhmon1;
	}


	public Float getDiemTrungBinhmon2() {
		return diemTrungBinhmon2;
	}


	public void setDiemTrungBinhmon2(Float diemTrungBinhmon2) {
		this.diemTrungBinhmon2 = diemTrungBinhmon2;
	}


	public Float getDiemTrungBinhmon3() {
		return diemTrungBinhmon3;
	}


	public void setDiemTrungBinhmon3(Float diemTrungBinhmon3) {
		this.diemTrungBinhmon3 = diemTrungBinhmon3;
	}


	public Student getThiSinhDiemCaoNhat() {
		return thiSinhDiemCaoNhat;
	}


	public void setThiSinhDiemCaoNhat(Student thiSinhDiemCaoNhat) {
		this.thiSinhDiemCaoNhat = thiSinhDiemCaoNhat;
	}


	public ChiTietKhoi(KhoiThi khoi, int soLuongStudent, int soLuongNam, int soLuongNu, Float diemTrungBinhmon1,
			Float diemTrungBinhmon2, Float diemTrungBinhmon3, Student thiSinhDiemCaoNhat) {
		super();
		this.khoi = khoi;
		this.soLuongStudent = soLuongStudent;
		this.soLuongNam = soLuongNam;
		this.soLuongNu = soLuongNu;
		this.diemTrungBinhmon1 = diemTrungBinhmon1;
		this.diemTrungBinhmon2 = diemTrungBinhmon2;
		this.diemTrungBinhmon3 = diemTrungBinhmon3;
		this.thiSinhDiemCaoNhat = thiSinhDiemCaoNhat;
	}





	
}
