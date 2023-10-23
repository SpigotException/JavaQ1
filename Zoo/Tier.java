package Zoo;

public abstract class Tier {
	
	protected String name;
	protected double gewicht;
	protected boolean weiblich;
	protected double portionsGröße;

	
	public Tier(String name, double gewicht, boolean weiblich, double portionsGröße) {
		super();
		this.name = name;
		this.gewicht = gewicht;
		this.weiblich = weiblich;
		this.portionsGröße = portionsGröße;
	
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

	public double getPortionsGröße() {
		return portionsGröße;
	}

	public void setPortionsGröße(double portionsGröße) {
		this.portionsGröße = portionsGröße;
	}


	public void füttern() {
		gewicht+= portionsGröße;
	}
		
	
		
		
	
	
	public  abstract void bürsten();

	@Override
	public String toString() {
		return "Tier [name=" + name + ", gewicht=" + gewicht + ", weiblich=" + weiblich + ", portionsGröße="
				+ portionsGröße + ", getName()=" + getName() + ", getGewicht()=" + getGewicht() + ", isWeiblich()="
				+ isWeiblich() + ", getPortionsGröße()=" + getPortionsGröße() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
