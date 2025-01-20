package zooAttraktionen;

import graph.Graph;
import graph.GraphWithViewer;
import graph.Vertex;
import linear.List;

public class Attraktion extends Vertex {
	private GraphWithViewer lageplan;
	private int maxBesucherzahl;
	private int aktBesucherzahl;
	private boolean wirdGeraeumt;
	private boolean istGesperrt;
	
	public Attraktion(String pID, GraphWithViewer lageplan, int maxBesucherzahl, int aktBesucherzahl, boolean wirdGeraeumt,
			boolean istGesperrt) {
		super(pID);
		this.lageplan = lageplan;
		this.maxBesucherzahl = maxBesucherzahl;
		this.aktBesucherzahl = aktBesucherzahl;
		this.wirdGeraeumt = wirdGeraeumt;
		this.istGesperrt = istGesperrt;
	}

	public int getAktBesucherzahl() {
		return aktBesucherzahl;
	}

	public void setAktBesucherzahl(int aktBesucherzahl) {
		this.aktBesucherzahl = aktBesucherzahl;
	}

	public boolean wirdGeraeumt() {
		return wirdGeraeumt;
	}

	public void setzeWirdGeraeumt(boolean wirdGeraeumt) {
		this.wirdGeraeumt = wirdGeraeumt;
	}

	public boolean istGesperrt() {
		return istGesperrt;
	}

	public void setzeIstGesperrt(boolean istGesperrt) {
		this.istGesperrt = istGesperrt;
	}

	public int getMaxBesucherzahl() {
		return maxBesucherzahl;
	}
	
	public double ermittleMaxAbgabe(Attraktion pNachbar) {
		double ergebniss = 0;
		List<Vertex> nachbarn = lageplan.getNeighbours(this);
		nachbarn.toFirst();
		Attraktion a =	(Attraktion) nachbarn.getContent();
		while(nachbarn.hasAccess()) {
			 a =	(Attraktion) nachbarn.getContent();
			if(pNachbar.equals(a)) {
				ergebniss = -1;
				nachbarn.next();
			}else ergebniss = 1;
			nachbarn.remove();
			nachbarn.next();
		}
		if(ergebniss == 1) {
			int m = Integer.min(pNachbar.getMaxBesucherzahl()-pNachbar.getAktBesucherzahl(), this.aktBesucherzahl);
			int e = Integer.min(m, (int) lageplan.getEdge(pNachbar, this).getWeight());
			return e;
		}else return -1;
	}


	
	public List<Attraktion> wasLiefereIch(){
		
		
		return null;
	}

	@Override
	public String toString() {
		return "max=" + maxBesucherzahl + ", akt=" + aktBesucherzahl
				+ ", wirdGeraeumt=" + wirdGeraeumt + ", istGesperrt=" + istGesperrt + "]";
	}
	
	
	
	

	

}
