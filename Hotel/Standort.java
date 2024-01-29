package Hotel;

import baeume.ComparableContent;
import linear.ListWithViewer;

public class Standort implements ComparableContent<Standort>{

	 String name;
	 String land;
	ListWithViewer<Hotel> Hotels = new ListWithViewer<Hotel>();
	 public Standort(String name, String land) {
		super();
		this.name = name;
		this.land = land;

	}
	 
	public void addHotel(Hotel pH) {
		
	Hotels.append(pH);
		
	}
	public void loescheHotel(String pH) {
		
	Hotels.toFirst();
	while(Hotels.hasAccess()) {
		if (Hotels.getContent().getName().equals(pH)) {{
			Hotels.remove();
			
		}Hotels.next();
			
		}
	}		
}
	
	public Hotel gibHotel(String pH) {
		Hotel e = null ;
	Hotels.toFirst();
	while(Hotels.hasAccess()) {
		if (Hotels.getContent().getName().equals(pH)) {
			
			
			e = Hotels.getContent();
			
		}Hotels.next();
			
		
	}
	return e;		
}
	public void gibHotelListe() {
		Hotels.toFirst();
		while(Hotels.hasAccess()) {
			System.out.println(Hotels.getContent());
			Hotels.next();
		}
	}

	@Override
	public boolean isGreater(Standort pContent) {
		return this.land.compareTo(pContent.getLand())>0;
	
	}
	@Override
	public boolean isEqual(Standort pContent) {
		return this.land.compareTo(pContent.getLand())==0;
	
	}
	@Override
	public boolean isLess(Standort pContent) {
		return this.land.compareTo(pContent.getLand())<0;
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Standort [name=" + name + ", land=" + land + ", Hotels=" + Hotels + "]";
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public ListWithViewer<Hotel> getHotels() {
		return Hotels;
	}

	public void setHotels(ListWithViewer<Hotel> hotels) {
		Hotels = hotels;
	}

	
}
