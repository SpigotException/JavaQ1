package Zoo;

public abstract class Tier {
	
	protected String name;
	protected double gewicht;
	protected boolean weiblich;
	protected double portionsGr��e;

	
	public Tier(String name, double gewicht, boolean weiblich, double portionsGr��e) {
		super();
		this.name = name;
		this.gewicht = gewicht;
		this.weiblich = weiblich;
		this.portionsGr��e = portionsGr��e;
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGewicht() {
		return gewicht;
	}

	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}

	public boolean isWeiblich() {
		return weiblich;
	}

	public void setWeiblich(boolean weiblich) {
		this.weiblich = weiblich;
	}

	public double getPortionsGr��e() {
		return portionsGr��e;
	}

	public void setPortionsGr��e(double portionsGr��e) {
		this.portionsGr��e = portionsGr��e;
	}


	public void f�ttern() {
		gewicht+= portionsGr��e;
	}
		
	
		
		
	
	
	public  abstract void b�rsten();

	@Override
	public String toString() {
		return "Tier [name=" + name + ", gewicht=" + gewicht + ", weiblich=" + weiblich + ", portionsGr��e="
				+ portionsGr��e + ", getName()=" + getName() + ", getGewicht()=" + getGewicht() + ", isWeiblich()="
				+ isWeiblich() + ", getPortionsGr��e()=" + getPortionsGr��e() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
