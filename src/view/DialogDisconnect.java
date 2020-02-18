package view;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class DialogDisconnect extends JDialog {
	JButton btGetConnect = null;

	public DialogDisconnect(String title) {
		setTitle(title);
		setUI();
		setEvent();
		setMainUI();
	}

	public void setUI() {

		Container con = getContentPane();
		con.setLayout(null);

		JLabel lbDisconnect = new JLabel(" MẤT KẾT NỐI ");
		lbDisconnect.setFont(new Font("TimesRoman", Font.BOLD, 18));
		lbDisconnect.setBounds(30, 35, 160, 30);

		con.add(lbDisconnect);

	}

	public void setEvent() {

	}

	public void setMainUI() {
		setSize(200, 150);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}
}
