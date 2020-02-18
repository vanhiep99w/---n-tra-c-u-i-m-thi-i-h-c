package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingControlDemo extends JFrame {
	public SwingControlDemo() {
		JFileChooser file = new JFileChooser();
		getContentPane().add(file);
		file.setFileSelectionMode(file.DIRECTORIES_ONLY);
		file.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(file.getSelectedFile());
				setVisible(false);
			}
		});
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingControlDemo test = new SwingControlDemo();
	}
}