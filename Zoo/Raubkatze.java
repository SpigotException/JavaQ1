package Zoo;

public abstract class Raubkatze extends Tier{
	
	@SuppressWarnings("unused")
	private int danger;

	public Raubkatze(String name, double gewicht, boolean weiblich, double portionsGr��e, int pdanger) {
		super(name, gewicht, weiblich, portionsGr��e);
		danger = pdanger;
	
	
	}


	
	public abstract void Br�llen();
	
	

}
