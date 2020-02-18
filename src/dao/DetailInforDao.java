package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectDB;
import entities.CumThi;
import entities.DiemThi;
import entities.KhoiThi;
import entities.LoaiUuTiem;
import entities.Student;

public class DetailInforDao {

	private ConnectDB conDB = null;
	private Connection conn =null;
	private PreparedStatement preSta = null;
	private Statement sta = null;
	private ResultSet res = null;
	public DetailInforDao() {
		conDB =new ConnectDB();
		conn = conDB.getConnection();
	}
		
	
	public Student setDataForStudent() {
		Student stuTemp = null;
		entities.CumThi cum = null;
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
	public List<Student> getStuDetailInfor(String searchStr, String target) {
		List<Student>list = new ArrayList<Student>();
		Student temp = null;
		try {

			String excute = "SELECT * FROM student " + "LEFT JOIN cumthi ON student.idCum = cumthi.idCum "
					+ "LEFT JOIN khoithi ON student.idKhoiThi = khoithi.idKHoi "
					+ "LEFT JOIN loaiuutien ON student.idLoaiUuTien = loaiuutien.idLoai "
					+ "LEFT JOIN diemthi ON student.idHS = diemthi.idStudent " + "WHERE CAST(" + target
					+ " AS CHAR) LIKE ?  " ;
			preSta = conn.prepareStatement(excute);
			preSta.setString(1, "%" + searchStr + "%");
			res = preSta.executeQuery();

			while (res.next()) {
				temp = setDataForStudent();
				list.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
}
