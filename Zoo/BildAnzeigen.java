package Zoo;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class BildAnzeigen {
	
	public BildAnzeigen() {
		// TODO Auto-generated constructor stub
		 frame = new JFrame("Zoo");
		 label = new JLabel();
	}
	private static JFrame frame;
	private static JLabel label;
	public void anzeigen(String bildPfad,int Breite, int Hoehe) {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Breite,Hoehe);
		
		ImageIcon icon = new ImageIcon(bildPfad);
		label.setIcon(icon);
		frame.add(label);
		frame.setVisible(true);
	}

}
