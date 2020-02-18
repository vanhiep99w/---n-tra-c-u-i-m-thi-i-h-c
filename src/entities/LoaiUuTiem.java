package entities;

import java.io.Serializable;

public class LoaiUuTiem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idLoai;
	private String nameLoai;
	private int diemCong;
	public LoaiUuTiem() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoaiUuTiem [idLoai=" + idLoai + ", nameLoai=" + nameLoai + ", diemCong=" + diemCong + "]";
	}
	public LoaiUuTiem(int idLoai, String nameLoai, int diemCong) {
		super();
		this.idLoai = idLoai;
		this.nameLoai = nameLoai;
		this.diemCong = diemCong;
	}
	public int getIdLoai() {
		return idLoai;
	}
	public void setIdLoai(int idLoai) {
		this.idLoai = idLoai;
	}
	public String getNameLoai() {
		return nameLoai;
	}
	public void setNameLoai(String nameLoai) {
		this.nameLoai = nameLoai;
	}
	public int getDiemCong() {
		return diemCong;
	}
	public void setDiemCong(int diemCong) {
		this.diemCong = diemCong;
	}
}
