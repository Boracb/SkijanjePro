package app.utility;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

// pomagala za grafièke komponente i final stringovi
public class Pomagala {
	
	public static final boolean RAZVOJ = true;
	public static final int BROJ_ZNAKOVA_STAVKE = 10;
	public static final int MAKSIMALNO_REDOVA_IZ_BAZE_UPLATITELJI = Integer.MAX_VALUE;
	public static final int MAKSIMALNO_REDOVA_IZ_BAZE_ISPLATITELJI = Integer.MAX_VALUE;
	
	public static final String NASLOV_APLIKACIJE = "Skijaško trèanje";
	
	public static final String NASLOV_IZOBRNIK_PROZORA = "Izbornik";
	
	public static void centrirajFrame(JFrame frame) {
		
		Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimensions.getWidth() - frame.getWidth()) / 2);
		int y = (int)((dimensions.getHeight() - frame.getHeight())  / 2);
		
		frame.setLocation(x, y);
		
		
		
		
		
	}
	
	public static void greska(JFrame frame, String poruka ) {
		
		JOptionPane.showMessageDialog(frame.getRootPane(), poruka, "Greška", JOptionPane.ERROR_MESSAGE);
		
	}
	
	
public static void centrirajLabel(JLabel label, JFrame frame) {
		
		Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimensions.getWidth() - frame.getWidth()) / 2);
		int y = (int)((dimensions.getHeight() - frame.getHeight())  / 7);
		
		label.setLocation(x, y);
		
		
		
		
		
	}

public static void centrirajButton(JButton button, JFrame frame) {
	
	Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
	int x = (int) ((dimensions.getWidth() - frame.getWidth()) / 2);
	int y = (int)((dimensions.getHeight() - frame.getHeight())  / 5);
	
	button.setLocation(x, y);
	
	
	
	
	
}


	

}
