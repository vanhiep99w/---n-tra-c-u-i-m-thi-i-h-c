package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.Request;
import entities.Student;
import tcp.ServerConnection;

public class StartingFrame extends JFrame {
	
	private JTextField tfSearch = null;
	private JButton btSearch = null;
	private String strSearch = "";
	private JLabel lbCount = null;
	DialogDisconnect dialogDis = null;
	private List<Student> students = null;
	private ServerConnection serverCon = null;
	Request request ;

	public StartingFrame(String title,ServerConnection serverConn) {
		super(title);
		this.serverCon  = serverConn;
		addCenterLayout();
		addEvent();
		addMainUI();

	}

	public void addCenterLayout() {
		Container con = getContentPane();
		con.setLayout(null);

		// panelTop

		JPanel pnTop = new JPanel();
		pnTop.setLayout(null);
		pnTop.setBounds(0, 0, 500, 200);
		// pnTop.setBackground(Color.GRAY);

		JLabel lbTitle = new JLabel("TRA CỨU ĐIỂM THI ĐẠI HỌC ");
		lbTitle.setBounds(37, 10, 450, 70);
		lbTitle.setFont(new Font("TimesRoman", Font.BOLD, 30));
		// tfSearch
		tfSearch = new JTextField();
		tfSearch.setBounds(60, 85, 370, 30);
		// tfSearch.setColumns(10);

		lbCount = new JLabel();
		lbCount.setBounds(150, 60, 200, 20);

		lbCount.setVisible(false);

		// btSearch
		btSearch = new JButton("Search");
		btSearch.setBounds(190, 120, 100, 35);

		pnTop.add(tfSearch);
		pnTop.add(lbCount);
		pnTop.add(btSearch);
		pnTop.add(lbTitle);
		pnTop.setBackground(new Color(51, 204, 255));
		con.add(pnTop);

	}

	public void addEvent() {

		btSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				strSearch = tfSearch.getText();

				if ("".equals(strSearch) ) {
					lbCount.setText("Xin nhập vào thông tin tìm kiếm ");
					lbCount.setVisible(true);
				} 
				else {

					students = serverCon.getData(new Request(strSearch,"MacDinh"));
					if(students == null){
						lbCount.setText("Không tìm thấy sinh viên này trung khớp ");
						lbCount.setVisible(true);
					}else {
						TraDiemThiUI nextPanel = new TraDiemThiUI(getTitle(), students,serverCon);
						setVisible(false);
					}
					
				}
			}
		});

	}

	
	public void addMainUI() {

		setSize(500, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	

}
