package _08_pig_latin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game_tools.Sound;

public class PigLatinTranslator implements ActionListener {
	/**
	 * Method to translate a english to pig latin.
	 * 
	 * @param s The sentence in English
	 * @return The pig latin version
	 */
	JFrame frame = new JFrame("Pig Latin Translator");
	JPanel panel = new JPanel();
	JTextField field1 = new JTextField(10);
	JTextField field2 = new JTextField(10);
	JButton leftButton = new JButton(">>");
	JButton rightButton = new JButton("<<");
	JButton speak = new JButton("speak");

	void pigLatinRun() {
		frame.setSize(600, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		leftButton.addActionListener(this);
		rightButton.addActionListener(this);
		speak.addActionListener(this);
		panel.add(field1);
		panel.add(leftButton);
		panel.add(rightButton);
		panel.add(field2);
		panel.add(speak);
		frame.add(panel);
		}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == leftButton) {
		String translatedPig = translateEnglishToPigLatin(field1.getText()); 
		field2.setText(translatedPig);
		} else if (arg0.getSource() == rightButton) {
		String translatedEng = translatePigLatinToEnglish(field2.getText());
		field1.setText(translatedEng);
		} else if (arg0.getSource() == speak) {
			Sound.speak(field2.getText());
		}
	}

	public static String translateEnglishToPigLatin(String s) {
		String latin = "";
		int i = 0;
		while (i < s.length()) {
			// Take care of punctuation and spaces
			while (i < s.length() && !isLetter(s.charAt(i))) {
				latin = latin + s.charAt(i);
				i++;
			}
			// If there aren't any words left, stop.
			if (i >= s.length())
				break;
			// Otherwise we're at the beginning of a word.
			int begin = i;
			while (i < s.length() && isLetter(s.charAt(i))) {
				i++;
			}
			// Now we're at the end of a word, so translate it.
			int end = i;
			latin = latin + pigWord(s.substring(begin, end));
		}
		return latin;
	}

	/**
	 * Method to translate a pig latin to english.
	 * 
	 * @param s The sentence in pig latin
	 * @return The english version
	 */
	public static String translatePigLatinToEnglish(String s) {
		String english = "";

		String[] words = s.split(" ");

		for (String word : words) {
			String[] hyphenSplit = word.split("-");
			String translatedWord = word;
			String punctuation = "";

			if (hyphenSplit.length == 2) {
				if (hyphenSplit[1].startsWith("ay")) {
					// Started with a vowel

					translatedWord = hyphenSplit[0];
				} else {
					// Started with a consonant

					translatedWord = hyphenSplit[1].substring(0, firstVowel(hyphenSplit[1])) + hyphenSplit[0];
				}

				// Handle punctuation at the end of a word
				int lastLetterIndex = hyphenSplit[1].length() - 1;

				while (!Character.isLetter(hyphenSplit[1].charAt(lastLetterIndex))) {
					lastLetterIndex -= 1;
				}

				punctuation = hyphenSplit[1].substring(lastLetterIndex + 1);
			}

			// Add word
			if (english.isEmpty()) {
				english += translatedWord + punctuation;
			} else {
				english = english + " " + translatedWord + punctuation;
			}
		}

		return english;
	}

	/**
	 * Method to test whether a character is a letter or not.
	 * 
	 * @param c The character to test
	 * @return True if it's a letter
	 */
	private static boolean isLetter(char c) {
		return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
	}

	/**
	 * Method to translate one word into pig latin.
	 * 
	 * @param word The word in english
	 * @return The pig latin version
	 */
	private static String pigWord(String word) {
		int split = firstVowel(word);
		return word.substring(split) + "-" + word.substring(0, split) + "ay";
	}

	/**
	 * Method to find the index of the first vowel in a word.
	 * 
	 * @param word The word to search
	 * @return The index of the first vowel
	 */
	private static int firstVowel(String word) {
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++)
			if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o'
					|| word.charAt(i) == 'u')
				return i;
		return 0;
	}
}