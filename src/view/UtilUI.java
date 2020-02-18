package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import dao.CommonInforDao;
import entities.ChiTietKhoi;
import entities.KhoiThi;
import entities.Request2;
import entities.Student;
import tcp.ServerConnection;

public class UtilUI extends JDialog {

	private String nameKhoi, soLuong, diemTrungBinhMon1, diemTrungBinhMon2, diemTrungBinhMon3, thisinhcaonhat,
			soluongGender;
	Student stu = null;
	private JComboBox comboBox = null;
	private String[] comboboxName = { "Mặc Định", "TOP 10 ", "Thông Tin" };
	private JComboBox comboBox1 = null;
	private String[] comboboxName1 = { "A", "A1 ", "B", "C", "D" };
	private JButton buttonSearch = null;
	private JButton buChiTiet = null;
	private List<Student> students = null;
	private ServerConnection serverConn = null;
	private ChiTietKhoi khoi = null;
	private String cbBoxSeclected1 = "";
	private String cbBoxSeclected = "";
	private JPanel pnInfor = null;
	private Container con = null;
	private JLabel lbname = null;
	private JLabel lbSL = null;
	private JLabel lbSLG = null;
	private JLabel lbD1 = null;
	private JLabel lbD2 = null;
	private JLabel lbD3 = null;
	private JPanel pnFinal = null;
	private JLabel lbThiSinh = null;
	
	public UtilUI(ServerConnection serverConn,List<Student> students) {
		this.serverConn = serverConn;
		this.students = students;
		setTitle("Chức Năng");
		setUI();
		setEvent();
		setMainUI();

	}
	public void setVisiblePanel() {
		setVisible(false);
	}
	public List<Student> getStudents() {
		return students;
	}
	
	

	private void setEvent() {

		buttonSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cbBoxSeclected = (String) comboBox.getSelectedItem();
				cbBoxSeclected1 = (String) comboBox1.getSelectedItem();
				
				Request2 request = new Request2(cbBoxSeclected, cbBoxSeclected1);
				if(cbBoxSeclected.equals("TOP 10 ")) {
					students = serverConn.getData2_1(request);
					System.out.println(students.size());
					dispose();
				}if(cbBoxSeclected.equals("Thông Tin")) {
					setSize(300, 330);
					khoi = serverConn.getData2_2(request);
					setPannelDetail();
					
				}
						
			}
		});
		buChiTiet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DialogDetail dialogDetail= new DialogDetail(khoi.getThiSinhDiemCaoNhat());
				dialogDetail.setVisible(true);
				
			}
		});

		
	}

	public void setData() {

		nameKhoi = "                      Khối " + khoi.getKhoi().getNameKhoi();
		soLuong = "-  Số Lượng :";
		soluongGender = "          Nam: " + khoi.getSoLuongNam() + "          Nữ: " + khoi.getSoLuongNu();
		diemTrungBinhMon1 = "-  Môn Thi(Điểm TB) :";
		diemTrungBinhMon2 = "    " + khoi.getKhoi().getMon1() + "             " + khoi.getKhoi().getMon2()
				+ "             " + khoi.getKhoi().getMon3();
		NumberFormat format = new DecimalFormat("#.##");
		diemTrungBinhMon3 = "    " + format.format(khoi.getDiemTrungBinhmon1()) + "             "
				+ format.format(khoi.getDiemTrungBinhmon2()) + "             "
				+ format.format(khoi.getDiemTrungBinhmon3());
		thisinhcaonhat = "Tổng Điểm cao Nhât : " + khoi.getThiSinhDiemCaoNhat().getDiemTong();

	}

	public void setUI() {
		con = getContentPane();

		con.setLayout(null);
		JPanel pnSearch = new JPanel();
		pnSearch.setBounds(0, 0, 300, 65);
		pnSearch.setLayout(null);
		pnSearch.setBackground(new Color(51, 204, 255));

		// jcombobox
		comboBox = new JComboBox<String>(comboboxName);
		comboBox.setBounds(15, 15, 80, 35);

		JLabel lbKhoi = new JLabel("Khối");
		lbKhoi.setBounds(100, 15, 50, 35);

		comboBox1 = new JComboBox<String>(comboboxName1);
		comboBox1.setBounds(135, 15, 50, 35);
		buttonSearch = new JButton("Search");
		buttonSearch.setBounds(200, 15, 80, 35);

		pnSearch.add(comboBox);
		pnSearch.add(lbKhoi);
		pnSearch.add(comboBox1);
		pnSearch.add(buttonSearch);
		con.add(pnSearch);
		pnInfor = new JPanel();
		pnInfor.setLayout(new BoxLayout(pnInfor, BoxLayout.Y_AXIS));
		pnInfor.setBounds(3, 65, 280, 225);
		
		Border border = BorderFactory.createRaisedBevelBorder();
		TitledBorder titleBorder = BorderFactory.createTitledBorder("Thông Tin");
		pnInfor.setBorder(titleBorder);
		pnInfor.setBorder(titleBorder);
		lbname = new JLabel();
		lbSL = new JLabel();
		lbSLG = new JLabel();
		lbD1 = new JLabel();
		lbD2 = new JLabel();
		lbD3 = new JLabel();
		pnFinal = new JPanel();
		pnFinal.setLayout(null);
		lbThiSinh = new JLabel();
		lbThiSinh.setBounds(20, 0, 300, 20);
		buChiTiet = new JButton("Chi Tiết");
		buChiTiet.setBounds(85, 25, 90, 30);
		pnFinal.add(lbThiSinh);
		pnFinal.add(buChiTiet);

		pnInfor.add(lbname);
		pnInfor.add(lbSL);
		pnInfor.add(lbSLG);
		pnInfor.add(lbD1);
		pnInfor.add(lbD2);
		pnInfor.add(lbD3);
		pnInfor.add(pnFinal);

		con.add(pnInfor);
	}
	public void setPannelDetail() {
		setData();
		
		lbname.setText(nameKhoi);
		lbname.setFont(new Font("TimesRoman", Font.BOLD, 18));
		lbSL.setText(soLuong);
		lbSL.setFont(new Font("TimesRoman", Font.BOLD, 18));
		lbSLG.setText(soluongGender);
		lbSLG.setFont(new Font("TimesRoman", Font.BOLD, 18));
		lbD1.setText(diemTrungBinhMon1);
		lbD1.setFont(new Font("TimesRoman", Font.BOLD, 18));
		lbD2.setText(diemTrungBinhMon2);
		lbD2.setFont(new Font("TimesRoman", Font.BOLD, 18));
		lbD3.setText(diemTrungBinhMon3);
		lbD3.setFont(new Font("TimesRoman", Font.BOLD, 18));
		
		
		

		lbThiSinh.setText(thisinhcaonhat);
		lbThiSinh.setFont(new Font("TimesRoman", Font.BOLD, 18));
		


	}

	public void setMainUI() {
		setSize(300, 100);
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
	}
}
