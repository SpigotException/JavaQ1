package bacheloristin;

public class Kandidat {
	
	String name;
	int gebDatum;
	boolean weiblich;
	int quotenPunkte;
	boolean nochdabei;
	
	public Kandidat(String pName, int pGbd, boolean pWeiblich) {
		
		this.name = pName;
		this.gebDatum = pGbd;
		this.weiblich = pWeiblich;
		this.quotenPunkte = 0;
		this.nochdabei = true;
		
		

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGebDatum() {
		return gebDatum;
	}

	public void setGebDatum(int gebDatum) {
		this.gebDatum = gebDatum;
	}

	public boolean isWeiblich() {
		return weiblich;
	}

	public void setWeiblich(boolean weiblich) {
		this.weiblich = weiblich;
	}

	public int getQuotenPunkte() {
		return quotenPunkte;
	}

	public void setQuotenPunkte(int quotenPunkte) {
		this.quotenPunkte = quotenPunkte;
	}

	public boolean isNochdabei() {
		return nochdabei;
	}

	public void setNochdabei(boolean nochdabei) {
		this.nochdabei = nochdabei;
	}

}
