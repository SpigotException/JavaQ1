package Zoo;




import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import gui.GUI;
import linear.ListWithViewer;

public class zoo {
	BildAnzeigen b1= new BildAnzeigen();
	
	public ListWithViewer<Tier> zooTiere = new ListWithViewer<>();
	
	public zoo(){
		
		initList();
		
	}
	
	 private Image image;
	public static void main(String[] args) {
		zoo tb = new zoo();
		new GUI(tb);
	}
	
	public void initList() {
		

		Tieger T1= new Tieger("Jürgen", 500.0, false, 10, 7);
		Tieger T2= new Tieger("Joachim", 45.0, true, 1, 6);
		zooTiere.append(T1);
		zooTiere.append(T2);
		
		Löwe l1 = new Löwe("Hans", 234, false,  6);
		
		b1.anzeigen("\\\\MNSSERVER\\maxwei$\\Dokumente\\Informatik LK\\Java_Q1Q2\\javaQ1Q2\\Zoo\\normal.jpg", 1920 ,1080);
	
	
		Löwe l2 = new Löwe("Brigitte", 700, false, 10);
		
		zooTiere.append(l1);
		zooTiere.append(l2);
		
		Nielpferd n1 = new Nielpferd("Jakob", 1000, false );
		Nielpferd n2 = new Nielpferd("Nico", 986, false );
		
		zooTiere.append(n1);
		zooTiere.append(n2);
		
	}
	
	public void fütternAlleFüttern() {
		
		zooTiere.toFirst();
		while (zooTiere.hasAccess()) {
			
			zooTiere.getContent().füttern();
			zooTiere.next();
			
			

			
		}
	
		b1.anzeigen("\\\\MNSSERVER\\maxwei$\\Dokumente\\Informatik LK\\Java_Q1Q2\\javaQ1Q2\\Zoo\\mqdefault.jpg",320,180);
		
	
	}

	
	public void AlleBürsten() {
		
		zooTiere.toFirst();
		while (zooTiere.hasAccess()) {
			
			zooTiere.getContent().bürsten();
			zooTiere.next();
		}
		
	
		
	}
		
	public void brüllenKatzen() {
		
		zooTiere.toFirst();
	while (zooTiere.hasAccess()) {
			if (zooTiere.getContent().getClass().isInstance(Raubkatze.class)) {
				
				((Raubkatze) zooTiere.getContent()).Brüllen();
			
			}
		
			zooTiere.next();
		}
	}


	@Override
	public String toString() {
		return "zoo [zooTiere=" + zooTiere + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
