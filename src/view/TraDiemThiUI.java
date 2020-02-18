package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entities.Request;
import entities.Student;
import tcp.ServerConnection;

public class TraDiemThiUI extends JFrame {
	
	private JTextField tfSearch = null;
	private JButton btSearch = null;
	private JTable table = null;
	private String[] columnNames = { "SBD", "Tên", "Giới Tính", "Trường", "Địa Chỉ" };
	private DefaultTableModel mdTable = null;
	private String[] comboboxName = { "Mặc Định", "SBD", "Tên", "Điểm Tổng" };
	private String[] comboboxUtil = { "Mặc Định", "Trường", "Thành Phố", "Khối" };
	private JComboBox jComboBox = null;
	private String cbBoxSeclected = "";
	private JScrollPane sc = null;
	private String strSearch = "";
	private JLabel lbCount = null;
	private List<Student> list = null;
	private String stringCount = "";
	private DialogDetail detailDialog = null;
	private ServerConnection serverConn = null;
	private JButton btUtil = null;
	

	public TraDiemThiUI(String title, List<Student> students,ServerConnection serverConn) {
		super(title);
		this.list = students;
		this.serverConn = serverConn;
		addCenterLayout();
		showTableData(list);
		stringCount = "Tìm kiếm được " + mdTable.getRowCount()+" kết quả.";
		lbCount.setText(stringCount);
		addEvent();
		addMainUI();
	}

	public void addEvent() {

		btSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				strSearch = tfSearch.getText();
				cbBoxSeclected = (String) jComboBox.getSelectedItem();
				mdTable.setRowCount(0);
				if ("".equals(strSearch) ) {
					lbCount.setText("Xin nhập vào thông tin tìm kiếm ");
					lbCount.setVisible(true);
				} else {
					Request request = new Request(strSearch, cbBoxSeclected);
					list = serverConn.getData(request);
					
					stringCount = "Tìm kiếm được " + list.size()+" kết quả.";
					lbCount.setText(stringCount);
					lbCount.setVisible(true);
				}
				showTableData(list);
				//list = new ArrayList<Student>();
				//list.forEach(t-> list.remove(t));
				//System.out.println(list.size());
			}
		});
		
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectRow = table.getSelectedRow();
				int chossedID = (int) mdTable.getValueAt(SelectRow, 0);
				System.out.println(chossedID);
				for (Student stu : list) {
					if (stu.getId() == chossedID) {
						detailDialog = new DialogDetail(stu);
						detailDialog.setVisible(true);
						break;
					}

				}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btUtil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UtilUI utilUI = new UtilUI(serverConn,list);
				utilUI.setVisible(true);
				tfSearch.setText("");
				list = utilUI.getStudents();
			}
		});
	}

	public void showTableData(List<Student> students) {
		list.forEach(t -> mdTable.addRow(new Object[] { t.getId(), t.getName(), (t.isGender() ? "Nam" : "Nữ"),
				t.getSchoolName(), t.getAddress() }));
	}

	public void setTable() {
		mdTable.setColumnIdentifiers(columnNames);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(170);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
	}

	public void addCenterLayout() {
		

		Container con = getContentPane();
		con.setLayout(null);

		// panelTop

		JPanel pnTop = new JPanel();
		pnTop.setLayout(null);
		pnTop.setBounds(0, 0, 700, 70);
		pnTop.setBackground(new Color(51, 204, 255));

		// tfSearch
		tfSearch = new JTextField();
		tfSearch.setBounds(10, 15, 293, 35);
		// tfSearch.setColumns(10);

		// lbCount
		lbCount = new JLabel();
		lbCount.setBounds(240, 50, 200, 22);
		lbCount.setForeground(new Color(102, 102, 102));
		// lbCount.setVisible(false);

		// btSearch
		btSearch = new JButton("Search");
		btSearch.setBounds(390, 15, 80, 35);

		// jcombobox
		jComboBox = new JComboBox<String>(comboboxName);
		jComboBox.setBounds(305, 15, 80, 35);
		
		btUtil = new JButton("More Util");
		btUtil.setBounds(510, 15, 120, 35);

		pnTop.add(tfSearch);
		pnTop.add(btSearch);
		pnTop.add(lbCount);
		pnTop.add(jComboBox);
		pnTop.add(btUtil);

		// panelBottom
		JPanel pnbottom = new JPanel();
		pnbottom.setLayout(null);
		pnbottom.setBounds(0, 70, 700, 430);

		mdTable = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		table = new JTable(mdTable);
		table.setBackground(new Color(51, 204, 255));
		setTable();
		sc = new JScrollPane(table);
		sc.setBounds(0, 0, 680, 400);

		pnbottom.add(sc);

		// con add
		con.add(pnTop);
		con.add(pnbottom);

	}

	
	public void addMainUI() {

		setSize(700, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	

}
