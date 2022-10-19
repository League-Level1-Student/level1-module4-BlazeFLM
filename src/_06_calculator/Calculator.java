package _06_calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JButton button1 = new JButton("Add");	 
	JButton button2 = new JButton("Subtract");
	JButton button3 = new JButton("Divide");
	JButton button4 = new JButton("Multiply");
	JTextField field1 = new JTextField("  ");
	JTextField field2 = new JTextField("  ");
	double ans;
	
	public void run() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 500);
		frame.setVisible(true);
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(field1);
		panel.add(field2);
		panel.add(label);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
			if(arg0.getSource() == button1) {
			add();
		} else if(arg0.getSource() == button2) {
			subtract();
		} else if(arg0.getSource() == button3) {
			divide();
		} else if(arg0.getSource() == button4) {
			multiply();
		}
	}
	void add() {
		String text1 = field1.getText();
		String text2 = field2.getText();
		double field1Int = Double.parseDouble(text1);
		double field2Int = Double.parseDouble(text2);
		ans = field1Int + field2Int;
		JOptionPane.showMessageDialog(null, ans);
	}

	void subtract() {
		String text1 = field1.getText();
		String text2 = field2.getText();
		double field1Int = Double.parseDouble(text1);
		double field2Int = Double.parseDouble(text2);
		ans = field1Int - field2Int;
		JOptionPane.showMessageDialog(null, ans);
	}

	void divide() {
		String text1 = field1.getText();
		String text2 = field2.getText();
		double field1Int = Double.parseDouble(text1);
		double field2Int = Double.parseDouble(text2);
		ans = field1Int / field2Int;
		JOptionPane.showMessageDialog(null, ans);
	}

	void multiply() {
		String text1 = field1.getText();
		String text2 = field2.getText();
		double field1Int = Double.parseDouble(text1);
		double field2Int = Double.parseDouble(text2);
		ans = field1Int * field2Int;
		JOptionPane.showMessageDialog(null, ans);
	}
}
