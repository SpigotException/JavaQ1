package _test;



import org.apache.commons.collections15.functors.WhileClosure;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import graph.GraphWithViewer;
import gui.GUI;
import linear.List;
import linear.ListWithViewer;


public class GraphTest {

	// Attribut, in dem die Karte gespeichert wird.
	public GraphWithViewer karte;

	// Rahmenmethode zum testen
	public List<Vertex> tiefendurchlaufVonKassel(){
		karte.setAllVertexMarks(false);
		karte.setAllEdgeMarks(false);
		Vertex vKassel = karte.getVertex("Kassel");
		return tiefendurchlauf(vKassel);
	}

	// rekursive Methode
	private List<Vertex> tiefendurchlauf(Vertex pVertex) {
		List<Vertex> ergebnis = new ListWithViewer<>();

		if (pVertex.isMarked() == true) {
			return ergebnis;

		}
		ergebnis.append(pVertex);
		pVertex.setMark(true);

		List<Vertex> nachbar = karte.getNeighbours(pVertex);
		nachbar.toFirst();
		while(nachbar.hasAccess()) {
			ergebnis.concat(tiefendurchlauf(nachbar.getContent()));
			nachbar.next();
		}

		return ergebnis;
	}

	// Rahmenmethode zum testen
	public List<Vertex> breitendurchlaufVonKassel(){
		karte.setAllVertexMarks(false);
		karte.setAllEdgeMarks(false);
		Vertex vKassel = karte.getVertex("Kassel");
		return breitendurchlauf(vKassel);
	}

	// NICHT-rekursive Methode
	private List<Vertex> breitendurchlauf(Vertex pVertex) {
		List<Vertex> ergebnis = new ListWithViewer<>();
		ergebnis.append(pVertex);
		pVertex.setMark(true);
		ergebnis.toFirst();
		while(ergebnis.hasAccess()) {
			List<Vertex> nachbarn = karte.getNeighbours(ergebnis.getContent());
			nachbarn.toFirst();
			while(nachbarn.hasAccess()) {
				if(nachbarn.getContent().isMarked() == false) {
					nachbarn.getContent().setMark(true);
					ergebnis.append(nachbarn.getContent());	
				}
				nachbarn.next();		
			}
			ergebnis.next();	
		}
		return ergebnis;
	}


	public GraphTest(){
		karte = new GraphWithViewer();
		Vertex dortmund = new Vertex("Dortmund");
		karte.addVertex(dortmund);
		Vertex koeln = new Vertex("Koeln");
		karte.addVertex(koeln);
		Vertex frankfurt = new Vertex("Frankfurt");
		karte.addVertex(frankfurt);
		Vertex kassel = new Vertex("Kassel");
		karte.addVertex(kassel);
		Vertex wuerzburg = new Vertex("Wuerzburg");
		karte.addVertex(wuerzburg);

		Edge kassel_dortmund = new Edge(kassel, dortmund, 160);
		karte.addEdge(kassel_dortmund);
		Edge dortmund_koeln = new Edge(dortmund, koeln, 93);
		karte.addEdge(dortmund_koeln);
		Edge frankfurt_kassel = new Edge(frankfurt, kassel, 193);
		karte.addEdge(frankfurt_kassel);
		Edge kassel_wuerzburg = new Edge(kassel, wuerzburg, 209);
		karte.addEdge(kassel_wuerzburg);
		Edge wuerzburg_frankfurt = new Edge(wuerzburg, frankfurt, 119);
		karte.addEdge(wuerzburg_frankfurt);
		Edge frankfurt_koeln = new Edge(frankfurt, koeln, 189);
		karte.addEdge(frankfurt_koeln);

		// *** weitere Vertices und Edges! ***

		Vertex hamburg = new Vertex("Hamburg");
		karte.addVertex(hamburg);
		Vertex berlin = new Vertex("Berlin");
		karte.addVertex(berlin);
		Vertex bremen = new Vertex("Bremen");
		karte.addVertex(bremen);
		Vertex hannover = new Vertex("Hannover");
		karte.addVertex(hannover);
		Vertex leipzig = new Vertex("Leipzig");
		karte.addVertex(leipzig);
		Vertex nuernberg = new Vertex("Nuernberg");
		karte.addVertex(nuernberg);
		Vertex stuttgart = new Vertex("Stuttgart");
		karte.addVertex(stuttgart);
		Vertex muenchen = new Vertex("Muenchen");
		karte.addVertex(muenchen);
		Vertex karlsruhe = new Vertex("Karlsruhe");
		karte.addVertex(karlsruhe);
		Vertex aachen = new Vertex("Aachen");
		karte.addVertex(aachen);

		Edge e = new Edge(berlin, hamburg, 289);
		karte.addEdge(e);
		Edge hamburg_bremen = new Edge(hamburg, bremen, 119);
		karte.addEdge(hamburg_bremen);
		Edge bremen_hannover = new Edge(bremen, hannover, 122);
		karte.addEdge(bremen_hannover);
		Edge hannover_hamburg = new Edge(hannover, hamburg, 150);
		karte.addEdge(hannover_hamburg);
		Edge berlin_hannover = new Edge(berlin, hannover, 290);
		karte.addEdge(berlin_hannover);
		Edge berlin_leipzig = new Edge(berlin, leipzig, 188);
		karte.addEdge(berlin_leipzig);
		Edge hannover_kassel = new Edge(hannover, kassel, 167);
		karte.addEdge(hannover_kassel);
		Edge leipzig_kassel = new Edge(leipzig, kassel, 250);
		karte.addEdge(leipzig_kassel);
		Edge dortmund_bremen = new Edge(dortmund, bremen, 234);
		karte.addEdge(dortmund_bremen);
		Edge dortmund_hannover = new Edge(dortmund, hannover, 210);
		karte.addEdge(dortmund_hannover);
		Edge leipzig_nuernberg = new Edge(leipzig, nuernberg, 278);
		karte.addEdge(leipzig_nuernberg);
		Edge wuerzburg_nuernberg = new Edge(wuerzburg, nuernberg, 110);
		karte.addEdge(wuerzburg_nuernberg);
		Edge nuernberg_muenchen = new Edge(nuernberg, muenchen, 166);
		karte.addEdge(nuernberg_muenchen);
		Edge muenchen_stuttgart = new Edge(muenchen, stuttgart, 223);
		karte.addEdge(muenchen_stuttgart);
		Edge nuernberg_stuttgart = new Edge(nuernberg, stuttgart, 208);
		karte.addEdge(nuernberg_stuttgart);
		Edge stuttgart_karlsruhe = new Edge(stuttgart, karlsruhe, 82);
		karte.addEdge(stuttgart_karlsruhe);
		Edge karlsruhe_frankfurt = new Edge(karlsruhe, frankfurt, 147);
		karte.addEdge(karlsruhe_frankfurt);
		Edge aachen_koeln = new Edge(aachen, koeln, 68);
		karte.addEdge(aachen_koeln);

		// auf ein geeignetes Layout umstellen
		karte.switchToISOMLayout();
	}


	public String getClosestNeighbour(String pID) {

		Vertex v = karte.getVertex(pID);
		List<Edge> edge = karte.getEdges(v);
		edge.toFirst();
		Edge kleinstes = edge.getContent();




		while(edge.hasAccess()) {
			Edge aktuell = edge.getContent();
			if (aktuell.getWeight() >  edge.getContent().getWeight()) {
				aktuell=  kleinstes;

			}
			edge.next();
		}

		Vertex[] vertexArray = kleinstes.getVertices();
		if (!vertexArray[0].getID().equals(pID)) {
			return vertexArray[0].getID();


		}

		return  vertexArray[1].getID();
	}

	public static void main(String[] args) {
		GraphTest gt = new GraphTest();
		new GUI(gt);
	}

}
