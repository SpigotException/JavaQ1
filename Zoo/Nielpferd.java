package Zoo;

public class Nielpferd extends Tier{

	public Nielpferd(String name, double gewicht, boolean weiblich) {
		super(name, gewicht, weiblich, gewicht/100*1);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void bürsten() {
	
		System.out.println("Schnauben");

		
	}

}
