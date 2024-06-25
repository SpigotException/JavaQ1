package zooAttraktionen;

import graph.Edge;
import graph.Graph;
import graph.GraphWithViewer;
import gui.GUI;
import linear.List;

public class Besucherverwaltung {
	private GraphWithViewer lageplan;
	
	public Besucherverwaltung() {
		initGraph();
	}
	
	// Liste der Attraktionen, die von einem Startort aus NICHT in zwei Schritten zu erreichen sind
	public List<Attraktion> gibWeitentfernte(Attraktion pStart){
		List ergList = new List<Attraktion>();
		// TODO
		
		
		return ergList;
	}

	private void initGraph() {
		lageplan = new GraphWithViewer();
		Attraktion a01 = new Attraktion("Toiletten", lageplan, 20, 4, false, false);
		Attraktion a02 = new Attraktion("Spielplatz", lageplan, 1000, 397, false, false);
		Attraktion a03 = new Attraktion("Ein-/Ausgang", lageplan, Integer.MAX_VALUE, 99, false, false);
		Attraktion a04 = new Attraktion("Streicheltiere", lageplan, 100, 87, false, false);
		Attraktion a05 = new Attraktion("Delfinarium", lageplan, 2000, 1365, false, false);
		Attraktion a06 = new Attraktion("Loewen", lageplan, 400, 223, false, false);
		Attraktion a07 = new Attraktion("Ziegen", lageplan, 80, 74, false, false);
		Attraktion a08 = new Attraktion("Esel", lageplan, 80, 55, false, false);
		Attraktion a09 = new Attraktion("Ausgang 1", lageplan, Integer.MAX_VALUE, 71, false, false);
		Attraktion a10 = new Attraktion("Ausgang 2", lageplan, Integer.MAX_VALUE, 211, false, false);
		lageplan.addVertex(a01);
		lageplan.addVertex(a02);
		lageplan.addVertex(a03);
		lageplan.addVertex(a04);
		lageplan.addVertex(a05);
		lageplan.addVertex(a06);
		lageplan.addVertex(a07);
		lageplan.addVertex(a08);
		lageplan.addVertex(a09);
		lageplan.addVertex(a10);
		Edge e01 = new Edge(a01, a02, 5); // Toi - Sp.pl.
		Edge e02 = new Edge(a02, a03, 500); // Sp.pl. - EinAus
		Edge e03 = new Edge(a02, a04, 150); // Sp.pl. - Str.t.
		Edge e04 = new Edge(a02, a05, 250);  // Sp.pl. - Delf.
		Edge e05 = new Edge(a04, a07, 15);  // Str.t. - Zieg
		Edge e06 = new Edge(a04, a05, 100);  // Str.t - Delf.
		Edge e07 = new Edge(a04, a08, 10);   // Str.t. - Esel
		Edge e08 = new Edge(a05, a06, 100);  // Delf - Löw
		Edge e09 = new Edge(a06, a10, 150);   // Löw - Ausg2
		Edge e10 = new Edge(a07, a08, 50);  // Zieg - Esel
		Edge e11 = new Edge(a08, a09, 80);   // Esel - Ausg1
		lageplan.addEdge(e01);
		lageplan.addEdge(e02);
		lageplan.addEdge(e03);
		lageplan.addEdge(e04);
		lageplan.addEdge(e05);
		lageplan.addEdge(e06);
		lageplan.addEdge(e07);
		lageplan.addEdge(e08);
		lageplan.addEdge(e09);
		lageplan.addEdge(e10);
		lageplan.addEdge(e11);
		
		lageplan.switchToISOMLayout();
		
	}

	public static void main(String[] args) {
		new GUI(new Besucherverwaltung());

	}

}
