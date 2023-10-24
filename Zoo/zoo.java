package Zoo;




import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import gui.GUI;
import linear.ListWithViewer;

public class zoo {
	
	protected boolean hunger;
	BildAnzeigen b1= new BildAnzeigen();
	
	public ListWithViewer<Tier> zooTiere = new ListWithViewer<>();
	
	public zoo(){
		
		initList();
		hunger = false;
		
	}
	//
	 private Image image;
	public static void main(String[] args) {
		zoo tb = new zoo();
		new GUI(tb);
	}
	
	public void initList() {
		

		Tieger T1= new Tieger("J�rgen", 500.0, false, 10, 7);
		Tieger T2= new Tieger("Joachim", 45.0, true, 1, 6);
		zooTiere.append(T1);
		zooTiere.append(T2);
		
		L�we l1 = new L�we("Hans", 234, false,  6);
		
		b1.anzeigen("\\\\MNSSERVER\\maxwei$\\Dokumente\\Informatik LK\\Java_Q1Q2\\javaQ1Q2\\Zoo\\L�we.jpeg", 680 ,450);
	
	
		L�we l2 = new L�we("Brigitte", 700, false, 10);
		
		zooTiere.append(l1);
		zooTiere.append(l2);
		
		Nielpferd n1 = new Nielpferd("Jakob", 1000, false );
		Nielpferd n2 = new Nielpferd("Nico", 986, false );
		
		zooTiere.append(n1);
		zooTiere.append(n2);
		
	}
	
	public void f�tternAlleF�ttern() {
		
		zooTiere.toFirst();

		while (zooTiere.hasAccess()) {
			
		
			zooTiere.getContent().f�ttern();
		
			zooTiere.next();
			
		}
		
		b1.anzeigen("\\\\MNSSERVER\\maxwei$\\Dokumente\\Informatik LK\\Java_Q1Q2\\javaQ1Q2\\Zoo\\mqdefault.jpg",320,180);
		setTimeout(()-> {
		hunger	= true;
		b1.anzeigen("\\\\MNSSERVER\\maxwei$\\Dokumente\\Informatik LK\\Java_Q1Q2\\javaQ1Q2\\Zoo\\L�we.jpeg", 680 ,450);
		}, 10000);
		

		
		
	
	
	
	}	public boolean isHunger() {
		return hunger;
	}

	public void setHunger(boolean hunger) {
		this.hunger = hunger;
	}

	public static void setTimeout(Runnable runnable, int delay){
	    new Thread(() -> {
	        try {
	            Thread.sleep(delay);
	            runnable.run();
	        }
	        catch (Exception e){
	            System.err.println(e);
	        }
	    }).start();
	}

	
	public void AlleB�rsten() {
		
		zooTiere.toFirst();
		while (zooTiere.hasAccess()) {
			
			zooTiere.getContent().b�rsten();
			zooTiere.next();
		}
		
	
		
	}
		
	public void br�llenKatzen() {
		
		zooTiere.toFirst();
	while (zooTiere.hasAccess()) {
			if (zooTiere.getContent().getClass().isInstance(Raubkatze.class)) {
				
				((Raubkatze) zooTiere.getContent()).Br�llen();
			
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
