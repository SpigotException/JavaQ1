package Zoo;

public abstract class Raubkatze extends Tier{
	
	@SuppressWarnings("unused")
	private int danger;

	public Raubkatze(String name, double gewicht, boolean weiblich, double portionsGröße, int pdanger) {
		super(name, gewicht, weiblich, portionsGröße);
		danger = pdanger;
	
	
	}


	
	public abstract void Brüllen();
	
	

}
