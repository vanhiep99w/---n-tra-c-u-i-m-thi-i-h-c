package entities;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	private int id;
	private String name;
	private boolean gender;
	private String schoolName;
	private String birthDay;
	private String address;
	private CumThi cum;
	private KhoiThi choi;
	private int year;
	private LoaiUuTiem idLoaiUT;
	private DiemThi diem;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, boolean gender, String schoolName, String birthDay, String address, CumThi cum,
			KhoiThi choi, int year, LoaiUuTiem idLoaiUT, DiemThi diem) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.schoolName = schoolName;
		this.birthDay = birthDay;
		this.address = address;
		this.cum = cum;
		this.choi = choi;
		this.year = year;
		this.idLoaiUT = idLoaiUT;
		this.diem = diem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public CumThi getCum() {
		return cum;
	}

	public void setCum(CumThi cum) {
		this.cum = cum;
	}

	public KhoiThi getChoi() {
		return choi;
	}

	public void setChoi(KhoiThi choi) {
		this.choi = choi;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public LoaiUuTiem getIdLoaiUT() {
		return idLoaiUT;
	}

	public void setIdLoaiUT(LoaiUuTiem idLoaiUT) {
		this.idLoaiUT = idLoaiUT;
	}

	public DiemThi getDiem() {
		return diem;
	}

	public void setDiem(DiemThi diem) {
		this.diem = diem;
	}
	public float getDiemTong() {
		System.out.println(this.getDiem().getMon1()+" "+this.getDiem().getMon2()+" "+this.getDiem().getMom3()+" "+this.getIdLoaiUT().getDiemCong());
		return this.getDiem().getMon1()+this.getDiem().getMon2()+this.getDiem().getMom3()+this.getIdLoaiUT().getDiemCong();
		
	}

}
