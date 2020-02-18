package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import connection.ConnectDB;
import entities.Student;
import util.InforUtil;
import entities.ChiTietKhoi;
import entities.CumThi;
import entities.DiemThi;
import entities.KhoiThi;
import entities.LoaiUuTiem;

public class CommonInforDao {
	private ConnectDB conDB = null;
	private Connection conn = null;
	private PreparedStatement preSta = null;
	private Statement sta = null;
	private ResultSet res = null;

	public CommonInforDao() {
		conDB = new ConnectDB();
		conn = conDB.getConnection();
	}

	public Student setDataForStudent() {
		Student stuTemp = null;
		CumThi cum = null;
		KhoiThi khoi = null;
		LoaiUuTiem loai = null;
		DiemThi diem = null;

		try {
			cum = new CumThi(res.getInt("idCum"), res.getString("tenCum"), res.getString("donViQL"));
			khoi = new KhoiThi(res.getInt("idKHoi"), res.getString("tenKhoi"), res.getString("mon1"),
					res.getString("mon2"), res.getString("mon3"));
			loai = new LoaiUuTiem(res.getInt("idLoai"), res.getString("tenLoai"), res.getInt("diemCong"));
			diem = new DiemThi(res.getInt("idStudent"), res.getFloat("diem1"), res.getFloat("diem2"),
					res.getFloat("diem3"));
			int idHS = res.getInt("idHS");
			String name = res.getString("tenHS");
			boolean gender = res.getBoolean("gioiTinh");
			String nameScholl = res.getString("tenTruong");
			String birthDay = res.getString("ngaySinh");
			String address = res.getString("diaChi");
			int year = res.getInt("namThi");

			stuTemp = new Student(idHS, name, gender, nameScholl, birthDay, address, cum, khoi, year, loai, diem);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stuTemp;
	}

	public List<Student> getTop10stu(int idKhoi) {
		List<Student> list = new ArrayList<Student>();
		Student temp = null;
		try {
			String excute = "SELECT *,(dt.diem1+dt.diem2+dt.diem3+lut.diemCong) diemTong FROM student "
					+ "LEFT JOIN cumthi ON student.idCum = cumthi.idCum "
					+ "LEFT JOIN khoithi ON student.idKhoiThi = khoithi.idKHoi "
					+ "LEFT JOIN loaiuutien lut ON student.idLoaiUuTien = lut.idLoai "
					+ "LEFT JOIN diemthi dt ON student.idHS = dt.idStudent " + "WHERE student.idKhoiThi = ? "
					+ "ORDER BY diemTong DESC LIMIT 10";
			preSta = conn.prepareStatement(excute);
			preSta.setInt(1, idKhoi);
			res = preSta.executeQuery();
			while (res.next()) {
				temp = setDataForStudent();
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Student> getDataOfSchool(String schoolName) {
		List<Student> list = new ArrayList<Student>();
		Student temp = null;
		try {
			String excute = "SELECT * FROM student " + "LEFT JOIN cumthi ON student.idCum = cumthi.idCum "
					+ "LEFT JOIN khoithi ON student.idKhoiThi = khoithi.idKHoi "
					+ "LEFT JOIN loaiuutien lut ON student.idLoaiUuTien = lut.idLoai "
					+ "LEFT JOIN diemthi dt ON student.idHS = dt.idStudent " + "WHERE student.tenTruong = ?";
			preSta = conn.prepareStatement(excute);
			preSta.setString(1, schoolName);
			res = preSta.executeQuery();
			while (res.next()) {
				temp = setDataForStudent();
				list.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void inserDataIntoStudent(int i, int id) {
		Random rd = new Random();

		String excute = "INSERT INTO student(idHS,tenHS,gioiTinh,tenTruong,ngaySinh,diaChi,idCum,idKhoiThi,namThi,idLoaiUuTien)"
				+ " VALUES(?,?,?,?,?,?,?,?,2019,?)";
		try {
			preSta = conn.prepareStatement(excute);
			preSta.setInt(1, id);
			preSta.setString(2, InforUtil.getFullName());
			preSta.setBoolean(3, rd.nextInt(2) == 1);
			preSta.setString(4, InforUtil.getSchool(i));
			preSta.setString(5, InforUtil.getDayOfBirth());
			preSta.setString(6, InforUtil.getAddress());
			preSta.setInt(7, InforUtil.getIDCum());
			preSta.setInt(8, InforUtil.getIDKhoi());
			preSta.setInt(9, 1 + rd.nextInt(2));
			preSta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void inserDataIntoDiem(int id) {

		NumberFormat format = new DecimalFormat("0.00");
		float diem = Float.parseFloat(format.format(InforUtil.getDiem()));
		float diem2 = Float.parseFloat(format.format(InforUtil.getDiem()));
		float diem3 = Float.parseFloat(format.format(InforUtil.getDiem()));
		String excute = "INSERT INTO diemthi(idStudent,diem1,diem2,diem3)" + " VALUES(?,?,?,?)";
		try {
			preSta = conn.prepareStatement(excute);
			preSta.setInt(1, id);
			preSta.setFloat(2, diem);
			preSta.setFloat(3, diem2);
			preSta.setFloat(4, diem3);

			preSta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<KhoiThi> getKhoiList() {
		List<KhoiThi> khoiThis = new ArrayList<KhoiThi>();
		KhoiThi khoiThi = new KhoiThi();
		try {
			String excute = "SELECT * FROM khoithi";

			sta = conn.createStatement();
			res = sta.executeQuery(excute);

			while (res.next()) {
				khoiThi = new KhoiThi(res.getInt("idKHoi"), res.getString("tenKhoi"), res.getString("mon1"),
						res.getString("mon2"), res.getString("mon3"));
				khoiThis.add(khoiThi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return khoiThis;
	}

	public KhoiThi getKhoiThi(int idKhoi) {

		KhoiThi khoiThi = new KhoiThi();
		try {
			String excute = "SELECT * FROM khoithi WHERE idKhoi = ?";

			preSta = conn.prepareStatement(excute);
			preSta.setInt(1, idKhoi);
			res = preSta.executeQuery();

			while (res.next()) {
				khoiThi = new KhoiThi(res.getInt("idKHoi"), res.getString("tenKhoi"), res.getString("mon1"),
						res.getString("mon2"), res.getString("mon3"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return khoiThi;
	}

	public KhoiThi getKhoiThi(String tenKhoi) {

		KhoiThi khoiThi = new KhoiThi();
		try {
			String excute = "SELECT * FROM khoithi WHERE khoithi.tenKhoi = ? ";

			preSta = conn.prepareStatement(excute);
			preSta.setString(1, tenKhoi);
			res = preSta.executeQuery();

			res.next();
			khoiThi = new KhoiThi(res.getInt("idKHoi"), res.getString("tenKhoi"), res.getString("mon1"),
					res.getString("mon2"), res.getString("mon3"));

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return khoiThi;
	}

	public Student getStudentById(int idStudent) {

		Student temp = null;
		try {
			String excute = "SELECT * FROM student " + "LEFT JOIN cumthi ON student.idCum = cumthi.idCum "
					+ "LEFT JOIN khoithi ON student.idKhoiThi = khoithi.idKHoi "
					+ "LEFT JOIN loaiuutien lut ON student.idLoaiUuTien = lut.idLoai "
					+ "LEFT JOIN diemthi dt ON student.idHS = dt.idStudent " + "WHERE student.idHS = ?";
			preSta = conn.prepareStatement(excute);
			preSta.setInt(1, idStudent);
			res = preSta.executeQuery();
			res.next();
			temp = setDataForStudent();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

	public Student getStudentDiemCaoNhat(int idKhoi) {

		Student student = new Student();
		try {
			String excute = "SELECT student.idHS FROM student "
					+ "JOIN (SELECT idHS,MAX(diemthi.diem1+diemthi.diem2+diemthi.diem3) "
					+ "FROM student JOIN diemthi ON student.idHS = diemthi.idStudent WHERE student.idKhoiThi = ?) AS abc ON abc.idHS = student.idHS ";

			preSta = conn.prepareStatement(excute);
			preSta.setInt(1, idKhoi);
			res = preSta.executeQuery();
			res.next();
			int idHS = res.getInt("idHS");
			student = getStudentById(idHS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	public ChiTietKhoi getDataKhoi(int idKhoi) {

		KhoiThi khoi = getKhoiThi(idKhoi);
		Student studentMax = getStudentDiemCaoNhat(idKhoi);
		int soluongNam = getGenderCount(1, idKhoi);
		int soluongNu = getGenderCount(0, idKhoi);

		ChiTietKhoi temp = null;
		try {
			String excute = "SELECT idKhoiThi,COUNT(*) SL,AVG(diemthi.diem1) diem1,AVG(diemthi.diem2) diem2,AVG(diemthi.diem3) diem3"
					+ " FROM student JOIN diemthi ON student.idHS = diemthi.idStudent"
					+ " WHERE student.idKhoiThi = ? GROUP BY student.idKhoiThi  ";

			preSta = conn.prepareStatement(excute);
			preSta.setInt(1, idKhoi);
			res = preSta.executeQuery();
			while (res.next()) {
				temp = new ChiTietKhoi(khoi, res.getInt("SL"), soluongNam, soluongNu, res.getFloat("diem1"),
						res.getFloat("diem2"), res.getFloat("diem3"), studentMax);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

	public int getGenderCount(int gender, int idKhoi) {
		int genderCount = 0;
		try {
			String excute = "SELECT idKhoiThi,COUNT(*) SoLuong FROM student WHERE idKhoiThi = ? AND student.gioiTinh = ? GROUP BY student.idKhoiThi ";

			preSta = conn.prepareStatement(excute);
			preSta.setInt(1, idKhoi);
			preSta.setInt(2, gender);
			res = preSta.executeQuery();

			res.next();
			genderCount = res.getInt("SoLuong");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return genderCount;
	}

}
