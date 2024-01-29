package Hotel;

public class Hotel {

	private String name;
	private String anschrift;
	private String hotelkette;
	private Double bewertungszahl;
	private int anzahlBewertungen;
	public Hotel(String name, String hotelkette, Double bewertungszahl, int anzahlBewertungen) {
		super();
		this.name = name;

		this.hotelkette = hotelkette;
		this.bewertungszahl = bewertungszahl;
		this.anzahlBewertungen = anzahlBewertungen;
		
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAnschrift() {
		return anschrift;
	}


	public void setAnschrift(String anschrift) {
		this.anschrift = anschrift;
	}


	public String getHotelkette() {
		return hotelkette;
	}


	public void setHotelkette(String hotelkette) {
		this.hotelkette = hotelkette;
	}


	public Double getBewertungszahl() {
		return bewertungszahl;
	}


	public void setBewertungszahl(Double bewertungszahl) {
		this.bewertungszahl = bewertungszahl;
	}


	public int getAnzahlBewertungen() {
		return anzahlBewertungen;
	}


	public void setAnzahlBewertungen(int anzahlBewertungen) {
		this.anzahlBewertungen = anzahlBewertungen;
	}
	public double getBewertungsdurchschnitt() {
		 return bewertungszahl/anzahlBewertungen;
	}


	@Override
	public String toString() {
		return "Hotel [name=" + name + ", anschrift=" + anschrift + ", hotelkette=" + hotelkette + ", bewertungszahl="
				+ bewertungszahl + ", anzahlBewertungen=" + anzahlBewertungen + "]";
	}
}
