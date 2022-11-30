package _10_slot_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton("Spin that!");
	JLabel slot1 = new JLabel();
	JLabel slot2 = new JLabel();
	JLabel slot3 = new JLabel();
	Random rand = new Random();
	JLabel counter = new JLabel();
	int winCount = 0;

	public SlotMachine() {
		button.addActionListener(this);
	}

	void pictures() {
		frame.dispose();
		frame = new JFrame("Slot Machine");
		panel = new JPanel();
		frame.setVisible(true);
		panel.add(button);
		spinSlots();
		panel.add(slot1);
		panel.add(slot2);
		panel.add(slot3);
		panel.add(button);
		panel.add(counter);
		frame.add(panel);
		frame.pack();
	}

	void spinSlots() {
		int one = rand.nextInt(3);
		int two = rand.nextInt(3);
		int three = rand.nextInt(3);
		try {
			if (one == 0) {
				slot1 = createLabelImage("pikachu.png");
			}
			if (one == 1) {
				slot1 = createLabelImage("bolt.png");
			}
			if (one == 2) {
				slot1 = createLabelImage("seven.jpg");
			}
			if (two == 0) {
				slot2 = createLabelImage("pikachu.png");
			}
			if (two == 1) {
				slot2 = createLabelImage("bolt.png");
			}
			if (two == 2) {
				slot2 = createLabelImage("seven.jpg");
			}
			if (three == 0) {
				slot3 = createLabelImage("pikachu.png");
			}
			if (three == 1) {
				slot3 = createLabelImage("bolt.png");
			}
			if (three == 2) {
				slot3 = createLabelImage("seven.jpg");
			}
			System.out.println(one + " " + two + " " + three);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (one == two && two == three) {
			JOptionPane.showMessageDialog(null, "Jackpot Baby!");
			winCount++;
			counter.setText(winCount + "");
		} 
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == button) {
			pictures();
		}
	}

	private JLabel createLabelImage(String fileName) throws MalformedURLException {
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null) {
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}
}
