package _05_fortune_teller;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class FortuneTellerRunner {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new FortuneTeller());
        begin();
    }

    static void begin() {
        // Welcome the user. Give them a hint for the secret location.
    	JOptionPane.showMessageDialog(null, "450 < x < 500, 200 < y < 250. "
    			+ "Figure that out, "
    			+ "it will lead to the diamond in the rough.");
    }
}
