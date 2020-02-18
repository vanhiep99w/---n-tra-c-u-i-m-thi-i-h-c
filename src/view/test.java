package view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dao.CommonInforDao;

public class test {

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(300, 300);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		List<Color> colors = Arrays.asList(Color.black, Color.blue, Color.CYAN, Color.GREEN);
		Random rd = new Random();
		JButton button = new JButton();
		button.setBounds(10,10,10,10);
		frame.getContentPane().add(button);
		
		frame.setVisible(true);
		/*
		 * while (true) { int r = rd.nextInt(4); frame.setBackground(colors.get(r)); }
		 */

	}
}
