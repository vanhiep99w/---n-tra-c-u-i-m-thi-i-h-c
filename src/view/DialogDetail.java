package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import entities.Student;

public class DialogDetail extends JDialog {

	private String id, name, gender, schoolName, birthDay, address, cumThi, quanLy, tenKhoi, mon1, mon2, mon3, year,
			diemCong, tongDiem,titleDiem;
	Student stu = null;

	public DialogDetail(Student student) {
		stu = student;
		setTitle("CHI TIẾT");
		setData();
		setUI();
		setMainUI();

	}

	public void setData() {
		id = "SBD             : " + stu.getId();
		name = "Họ và Tên    : " + stu.getName();
		gender = "Giới Tính     : " + ((stu.isGender()) ? "Nam" : "Nữ");
		schoolName = "Trường        : " + stu.getSchoolName();
		birthDay = "Ngày Sinh    : " + stu.getBirthDay();
		cumThi = "Cụm Thi       : " + stu.getCum().getNameCum();

		address="Địa Chỉ         : "+ stu.getAddress();
		quanLy = "Quản lý        : " + stu.getCum().getManOrg();
		tenKhoi = "Khối Thi    : " + stu.getChoi().getNameKhoi();
		year = "Kì thi năm   : " + stu.getYear();
		mon1 = stu.getChoi().getMon1() + " : " + stu.getDiem().getMon1();
		mon2 = stu.getChoi().getMon2() + " : " + stu.getDiem().getMon2();
		mon3 = stu.getChoi().getMon3() + " : " + stu.getDiem().getMom3();
		diemCong = "Điểm cộng : " + stu.getIdLoaiUT().getDiemCong();
		NumberFormat format=new DecimalFormat("#.##");
		tongDiem = "Tổng : " + format.format(stu.getDiem().getMon1() + stu.getDiem().getMon2() + stu.getDiem().getMom3()+stu.getIdLoaiUT().getDiemCong());

	}

	public void setUI() {
		Container con = getContentPane();
		con.setBackground(new Color(51, 204, 255));
		con.setLayout(null);

		JPanel pnInfor = new JPanel();
		Border border = BorderFactory.createRaisedBevelBorder();

		TitledBorder titleBorder = BorderFactory.createTitledBorder("Thông Tin");
		pnInfor.setBorder(border);
		pnInfor.setBounds(2, 2, 282, 205);
		pnInfor.setBorder(titleBorder);

		pnInfor.setLayout(new BoxLayout(pnInfor, BoxLayout.Y_AXIS));

		JPanel pnDiem = new JPanel();
		pnDiem.setLayout(new FlowLayout());
		pnDiem.setBounds(2, 210, 282, 80);
		Border borderDiem = BorderFactory.createRaisedBevelBorder();
		titleDiem="KHỐI "+stu.getChoi().getNameKhoi();
		TitledBorder titleBorderDiem = BorderFactory.createTitledBorder(titleDiem);
		pnDiem.setBorder(borderDiem);
		pnDiem.setBorder(titleBorderDiem);

		JLabel lbSBD = new JLabel(id);
		lbSBD.setFont(new Font("TimesRoman", Font.BOLD, 15));
		JLabel lbName = new JLabel(name);
		lbName.setFont(new Font("TimesRoman", Font.BOLD, 15));
		JLabel lbGender = new JLabel(gender);
		lbGender.setFont(new Font("TimesRoman", Font.BOLD, 15));
		JLabel lbtenTruong = new JLabel(schoolName);
		lbtenTruong.setFont(new Font("TimesRoman", Font.BOLD, 15));
		JLabel lbNgaySinh = new JLabel(birthDay);
		lbNgaySinh.setFont(new Font("TimesRoman", Font.BOLD, 15));
		JLabel lbDiaChi = new JLabel(address);
		lbDiaChi.setFont(new Font("TimesRoman", Font.BOLD, 15));
		JLabel lbCum = new JLabel(cumThi);
		lbCum.setFont(new Font("TimesRoman", Font.BOLD, 15));
		JLabel lbQuanLy = new JLabel(quanLy);
		lbQuanLy.setFont(new Font("TimesRoman", Font.BOLD, 15));
		JLabel lbYear = new JLabel(year);
		lbYear.setFont(new Font("TimesRoman", Font.BOLD, 15));

		JLabel lbMon1 = new JLabel(mon1);
		lbMon1.setFont(new Font("TimesRoman", Font.BOLD, 16));
		JLabel lbMon2 = new JLabel(mon2);
		lbMon2.setFont(new Font("TimesRoman", Font.BOLD, 16));
		JLabel lbMon3 = new JLabel(mon3);
		lbMon3.setFont(new Font("TimesRoman", Font.BOLD, 16));
		JLabel lbDiemCong = new JLabel(diemCong);
		lbDiemCong.setFont(new Font("TimesRoman", Font.BOLD, 16));
		JLabel lbDiemTong = new JLabel(tongDiem);
		lbDiemTong.setFont(new Font("TimesRoman", Font.BOLD, 16));

		pnInfor.add(lbSBD);
		pnInfor.add(lbName);
		pnInfor.add(lbGender);
		pnInfor.add(lbDiaChi);
		pnInfor.add(lbtenTruong);
		pnInfor.add(lbNgaySinh);
		pnInfor.add(lbDiaChi);
		pnInfor.add(lbCum);
		pnInfor.add(lbQuanLy);
		pnInfor.add(lbYear);
		pnDiem.add(lbMon1);
		pnDiem.add(lbMon2);
		pnDiem.add(lbMon3);
		
		pnDiem.add(lbDiemCong);
		pnDiem.add(lbDiemTong);
		

		con.add(pnInfor);
		con.add(pnDiem);
	}

	public void setMainUI() {
		setSize(300, 330);
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
	}
}
