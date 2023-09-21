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
	public void fliegeRaus( ) {
		nochdabei = false;
	}
	public void resetQuotenPunkte() {
		quotenPunkte = 0;
		
	}
	public void erhöheQuotenPunkte(int pPunkte) {
		if (pPunkte>0) {
			quotenPunkte += pPunkte;
		}

		
	}
	public void senkeQuotenPunkte(int pPunkte) {

		if (quotenPunkte-pPunkte< 0) {
			quotenPunkte -= pPunkte;
		}
		
	}
	

	@Override
	public String toString() {
		return "Kandidat [name=" + name + ", gebDatum=" + gebDatum + ", weiblich=" + weiblich + ", quotenPunkte="
				+ quotenPunkte + ", nochdabei=" + nochdabei + "]";
	}

	public boolean istAelterAls(Kandidat pKandidat) {
		if (pKandidat.getGebDatum()> gebDatum) {
			return true;
		}
		
		return false;
		
	}
}
