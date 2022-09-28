package _01_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChuckleClicker implements ActionListener {
	JButton jokeButton = new JButton("Joke Button");
	JButton punButton = new JButton("Pun Button");

	void makeButtons() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.add(jokeButton);
		panel.add(punButton);
		frame.pack();
		jokeButton.addActionListener(this);
		punButton.addActionListener(this);
	}

	public static void main(String[] args) {
		ChuckleClicker cc = new ChuckleClicker();
		cc.makeButtons();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()== jokeButton) {
		JOptionPane.showMessageDialog(null, "How do you follow Will Smith in the snow?");
		} else if (arg0.getSource()== punButton) {
		JOptionPane.showMessageDialog(null,  "You follow the fresh prints! AHAHAHAHAAH SO FUNNY");
		}
	}
}
