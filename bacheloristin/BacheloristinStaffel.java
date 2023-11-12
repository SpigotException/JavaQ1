package bacheloristin;


import java.sql.Date;
import java.util.Iterator;

import gui.GUI;
import linear.List;
import linear.ListWithViewer;




/* @author Manuel Grifka
  @version v0.2 2019-10-28
 */
public class BacheloristinStaffel {


	// Attribute
	private int jahr; 
	private Kandidat bacheloristin; private static
	ListWithViewer<Kandidat> jungsListe;

	// Attribut testkandidat dient nur zum Testen der Methoden, die einen
	//	 * Kandidat-Objekt als Parameter brauchen 
	private Kandidat testkandidat;

	// * Konstruktor für Objekte der Klasse BacheloristinStaffel

	public BacheloristinStaffel(int pJahr)
	{
		jahr = pJahr;		
		setJungsListe(new ListWithViewer<Kandidat>());
		

		initJungsListeTestkandidatBacheloristin(pJahr);

		
	}

	// TODO: Teil 2: Aufgabe a) rausschmeissen
	
	public void rausschmeissen(Kandidat pKandidat) {
		pKandidat.fliegeRaus();
	}


	// TODO: Teil 2: Aufgabe b) alleResetten
		public void alleResetten() {
			getJungsListe().toFirst();
			while(getJungsListe().hasAccess()) {
				getJungsListe().getContent().resetQuotenPunkte();
				getJungsListe().next();
				
			}
		}

	// TODO: Teil 2: Aufgabe c) 
		public int anzahlAusgeschiedener() {
			getJungsListe().toFirst();
			int result =0;
			while(getJungsListe().hasAccess()) {
				if (getJungsListe().getContent().nochdabei == false) {
					result++;
					
				}
				getJungsListe().next();
			}return result;
		}



	// TODO: Teil 2: Aufgabe d) hatGelaestert

		public void hatGelaestert(String pNameWer,String wurdeUeberGelestert ){
			getJungsListe().toFirst();

			while(getJungsListe().hasAccess()) {
				if (getJungsListe().getContent().getName().equals(pNameWer)) {
					getJungsListe().getContent().erhoeheQuotenPunkte(20);
				
					//getJungsListe().getCurrentNode().getNextNode().getContentObject().getName().equals(wurdeUeberGelestert);
				}
				getJungsListe().next();
		}
			getJungsListe().toFirst();
			while(getJungsListe().hasAccess()) {
				if (getJungsListe().getContent().getName().equals(wurdeUeberGelestert)) {
					getJungsListe().getContent().erhoeheQuotenPunkte(10);
				
					
				}
				getJungsListe().next();
			
			}
		}
	// TODO: Teil 2: Aufgabe e) knutschtBacheloristin
		public void knutschtBacheloristin(String pString){
			getJungsListe().toFirst();
			while(getJungsListe().hasAccess()) {
				if (getJungsListe().getContent().getName().equals(pString)) {
					getJungsListe().getContent().erhoeheQuotenPunkte(50);
					
				}
				
				getJungsListe().next();
			}
			
		}

	// TODO: Teil 2: Aufgabe f) gibQuotenLetzten
			
		public Kandidat gibQuotenPunkte() {
			if(jungsListe == null) {
				return null;
			}
			
			Kandidat result = null;
			
			getJungsListe().toFirst();
		result =	jungsListe.getContent();
			while(getJungsListe().hasAccess()) {

				if (result.getQuotenPunkte()> jungsListe.getContent().getQuotenPunkte()) {
					
					result = jungsListe.getContent();
				
				}
					jungsListe.next();
			
			}
			
			return result;
			
		}
		
		public int zählebis(String pName) {
			int i = 0;
			jungsListe.toFirst();
			while(jungsListe.hasAccess()) {
				i++;
					if(jungsListe.getContent().getName().equals(pName)) {
					
						return i;
					}
					
			jungsListe.next();
			}
			return i;
			
		}
		
	
		//klausur Lernen
		public void insertaAfterPString(String pName) {
				
			zählebis(pName);
				int i = 0;
				jungsListe.toFirst();
				 while(i!=zählebis(pName)-1) {
					 jungsListe.next();
					 i++;
				 }
			
				Kandidat k1 = new Kandidat("radnom", 1999, false);
				jungsListe.insert(k1);

				printList();
		}
		
		public void printList() {
		//System.out.println(i);
			System.out.println("_______________");
			
			
			
			jungsListe.toFirst();
		while(jungsListe.hasAccess()) {
			
			System.out.println(jungsListe.getContent().getName());
			jungsListe.next();
			
		}
		}

	public ListWithViewer<Kandidat> gibRenter(){
		ListWithViewer<Kandidat> l = new ListWithViewer<>();
		
		
		
		return l;
		
	}





	/* * -------------------------------------------------------------------------------------------
	 * ab hier nur noch init und main
	 * -------------------------------------------------------------------------------------------
	 */

	private void initJungsListeTestkandidatBacheloristin(int pJahr) {
		switch (pJahr) {
		case 2019:
			bacheloristin = new Kandidat("Fiona Diaz", 19900106, true);

			getJungsListe().append(new Kandidat("Diego de Deus", 19601030, false)); 
			getJungsListe().append(new Kandidat("George Coolknee", 19610506, false));
			getJungsListe().append(new Kandidat("Shria Ekstroem", 19900102, false));
			getJungsListe().append(new Kandidat("Edward Heran", 19910217, false));
			getJungsListe().append(new Kandidat("Adam Douglas", 19520311, false));
			getJungsListe().append(new Kandidat("Wolfgang Howowitz", 19810229, false));
			getJungsListe().append(new Kandidat("Stefan Falking", 19420108, false));
			getJungsListe().append(new Kandidat("Thomas Enis", 19980906, false));

			// Attribut testkandidat zum Testen von Methoden, die ein Kandidat-Objekt als Parameter erhalten
			testkandidat = new Kandidat("Don Dump", 19460614, false);
			getJungsListe().append(testkandidat);

			getJungsListe().append(new Kandidat("Christian Ronald", 19850205, false));
			break;

		case 2018:
			bacheloristin = new Kandidat("Bibi Botox", 19910909, true);

			getJungsListe().append(new Kandidat("Paul Poser", 19860107, false)); 
			getJungsListe().append(new Kandidat("Leo Lackaffe", 19891117, false));
			getJungsListe().append(new Kandidat("Alex Honey", 19920102, false));

			// Attribut testkandidat zum Testen von Methoden, die ein Kandidat-Objekt als Parameter erhalten
			testkandidat = new Kandidat("Anton Donis", 19821223, false);
			getJungsListe().append(testkandidat);

			getJungsListe().append(new Kandidat("Robert Geissbock", 19720429, false));
			getJungsListe().append(new Kandidat("Magnus Dautit", 19890802, false));
			getJungsListe().append(new Kandidat("Thomas Hayopai", 19711109, false));
			getJungsListe().append(new Kandidat("Shawn Schoenling", 19990107, false));
			getJungsListe().append(new Kandidat("Gustave Giro", 20000505, false));
			getJungsListe().append(new Kandidat("Alfons Bergmeier", 19990431, false));
			break;

		case 2017:
			bacheloristin = new Kandidat("Anna Krohn-Ismus", 19900722, true);

			getJungsListe().append(new Kandidat("Kai Pirinha", 19970324, false)); 
			getJungsListe().append(new Kandidat("Bill Dung", 19791009, false));
			getJungsListe().append(new Kandidat("Jim Panse", 20000315, false));
			getJungsListe().append(new Kandidat("Dieter Moskanne", 19670419, false));

			// Attribut testkandidat zum Testen von Methoden, die ein Kandidat-Objekt als Parameter erhalten
			testkandidat = new Kandidat("Ernst Haft", 19990101, false);
			getJungsListe().append(testkandidat);

			getJungsListe().append(new Kandidat("Lars Vegas", 19930602, false));
			getJungsListe().append(new Kandidat("Andi Arbeit", 19890501, false));
			getJungsListe().append(new Kandidat("Gerd Raenkaux-Tomate", 19871223, false));
			getJungsListe().append(new Kandidat("Ismael Lieba", 19871030, false));
			getJungsListe().append(new Kandidat("Karl Auer", 19931111, false));
			break;

		}
	}
	public void name() {
		
		
		BacheloristinStaffel.getJungsListe().toFirst();
		while(BacheloristinStaffel.getJungsListe().hasAccess()) {

			BacheloristinStaffel.getJungsListe().getContent().setQuotenPunkte(10);

			BacheloristinStaffel.getJungsListe().next();
		}
		
		BacheloristinStaffel.getJungsListe().toFirst();
		int i = 0;
		while(BacheloristinStaffel.getJungsListe().hasAccess()&&i <1) {
			i++;
			BacheloristinStaffel.getJungsListe().getContent().setQuotenPunkte(10);
			BacheloristinStaffel.getJungsListe().getContent().setQuotenPunkte(9);
			BacheloristinStaffel.getJungsListe().next();
			
		}
	}
	
	public int getAktuellesDatum() {
		long m = System.currentTimeMillis();
		Date date = new Date(m);
		String string = date.toString();
		string = string.replaceAll("-", "");
		
		int i = Integer.parseInt(string);
		return i;
	}


	@Override
	public String toString() {
		return "Jahr " + jahr + ", Bacheloristin: " + bacheloristin;
	}


	public static void alleAusgebn() {
		getJungsListe().toFirst();
		while(getJungsListe().hasAccess()) {
			System.out.println(getJungsListe().getContent().getQuotenPunkte());
			getJungsListe().next();
		
		}
	}
	
	public static void main(String[] args) {
		BacheloristinStaffel bs = new BacheloristinStaffel(2019);

		new GUI(bs);
	}

	public static ListWithViewer<Kandidat> getJungsListe() {
		return jungsListe;
	}

	public static void setJungsListe(ListWithViewer<Kandidat> jungsListe) {
		BacheloristinStaffel.jungsListe = jungsListe;
	}

	
		public boolean isKandidat(String pKandidatName) {
			if(jungsListe== null) {
				return false;
			}
			jungsListe.toFirst();
			while(jungsListe.hasAccess()) {
				if(pKandidatName.equals(jungsListe.getContent().getName())) {
					return true;
				}
				jungsListe.next();
			}
			return false;
		
	

}
}
