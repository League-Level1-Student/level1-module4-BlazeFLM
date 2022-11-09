package _09_whack_a_mole;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
	JFrame frame = new JFrame("Whack a Button");
	JPanel panel = new JPanel();
	JButton button = new JButton();
	Random rand = new Random();
	
	void whackyMole() {
		int ran = rand.nextInt(23);
	drawButtons(ran);
	}

	void drawButtons(int random) {
		frame.dispose();
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(400, 800);
		panel = new JPanel();
		panel.setLayout(new GridLayout(5,5));
		for (int i = 0; i < 23; i++) {
			JButton button2 = new JButton();
			panel.add(button2);
			button2.addActionListener(this);
			if (i == random) {
				button = button2;
				button.setText("Mole");
			}
		}
		frame.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int ran = rand.nextInt(23);
		if (arg0.getSource() == button) {
			drawButtons(ran);
		} else {
			speak("You missed, try again!");
			System.out.println("You missed, try again!");
			drawButtons(ran);
		}
		
	}

	static void speak(String words) {
		if (System.getProperty("os.name").contains("Windows")) {
			String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
					+ words + "');\"";
			try {
				Runtime.getRuntime().exec(cmd).waitFor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				Runtime.getRuntime().exec("say " + words).waitFor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
