package Hotel;

import baeume.BinarySearchTree;

public class Hotelbewertungssystem {
	private BinarySearchTree<Standort> standortBaum = new BinarySearchTree<Standort>();

	
	public Hotel gibHotel( String pName, String pLand) {
		
		
		
		

		Standort s1 = new Standort(pName, pLand);
		if (standortBaum.search(s1) == null) {
			return null;
		}
		return standortBaum.search(s1).gibHotel(pName);
		
	
		
		
	}
	public void Bewerten(String pName, String pLand, double pBewertung) {
		Hotel h1 = gibHotel(pName, pLand);
		h1.setAnzahlBewertungen(h1.getAnzahlBewertungen()+1);
		if(pBewertung <=5) {
			h1.setBewertungszahl(h1.getAnzahlBewertungen()+pBewertung);
			
		}
		
		
	}
	public void getBewertung() {
		
	}
	
	
    public void generateOrte() {
        //TODO generate orte
        //Hamburg
        Standort s1 = new Standort("Hamburg", "Deutschland");
        Hotel h11 = new Hotel("Hamburg Inn", "CityHotels", 7.8, 5);
        s1.addHotel(h11);
        Hotel h12 = new Hotel("St. Pauli Stern", "", 4.1, 10);
        s1.addHotel(h12);
        //Amsterdam
        Standort s2 = new Standort("Amsterdam", "Niederlande");
        Hotel h21 = new Hotel("Best Plus", "NTH", 9.0, 57);
        s2.addHotel(h21);
        Hotel h22 = new Hotel("Old Town", "CityHotels", 5.8, 55);
        s2.addHotel(h22);
        Hotel h23 = new Hotel("New Town", "", 5.75, 24);
        s2.addHotel(h23);
        Hotel h24 = new Hotel("River Boat", "New Hotels", 4.8, 10);
        s2.addHotel(h24);
        Hotel h25 = new Hotel("Art Hotel", "", 4.44, 25);
        s2.addHotel(h25);
        //M�nchen
        Standort s3 = new Standort("M�nchen", "Deutschland");
        Hotel h31 = new Hotel("An den Wies'n", "NTH", 9.2, 15);
        s3.addHotel(h31);
        Hotel h32 = new Hotel("M�nchner Park", "", 3.8, 25);
        s3.addHotel(h32);
        //Los Angeles
        Standort s4 = new Standort("Los Angeles", "Amerika");
        Hotel h41 = new Hotel("St. Mary", "", 9.5, 2);
        s4.addHotel(h41);
        Hotel h42 = new Hotel("Hollywood Stars", "CityHotels", 6.25, 8);
        s4.addHotel(h42);
        Hotel h43 = new Hotel("Beverly Inn", "", 6.1, 250);
        s4.addHotel(h43);
        Hotel h44 = new Hotel("California Dream", "City Hotels", 2.2, 75);
        s4.addHotel(h44);
        //New York
        Standort s5 = new Standort("New York", "Amerika");
        Hotel h51 = new Hotel("Art Hotel", "NTH", 9.8, 95);
        s5.addHotel(h51);
        Hotel h52 = new Hotel("Delaware", "", 7.12, 400);
        s5.addHotel(h52);
        Hotel h53 = new Hotel("Wailkill River", "CityHotels", 0.0, 0);
        s5.addHotel(h53);

        standortBaum.insert(s1);
        standortBaum.insert(s2);
        standortBaum.insert(s3);
        standortBaum.insert(s4);
        standortBaum.insert(s5);
    }
    
    public Hotelbewertungssystem() {
        this.generateOrte();
    }

    public void main(){
        Hotelbewertungssystem h1 = new Hotelbewertungssystem();
    }
}
