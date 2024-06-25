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
	
	public int ermittleMaxAbgabe(Attraktion pNachbar) {
		lageplan
		return -1;
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
