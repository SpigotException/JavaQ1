package Zoo;

public class Tieger extends Raubkatze {

	private int streifen;
	public Tieger(String name, double gewicht, boolean weiblich, int pdanger, int pStreifen) {
		super(name, gewicht, weiblich, gewicht/100*2, pdanger);
		// TODO Auto-generated constructor stub
		streifen = pStreifen;
	}

	
	
	@Override
	public void bürsten() {
	
		System.out.println("ch chu hcuc hcu");
	}
	
	public int getStreifen() {
		return streifen;
	}


	@Override
	public void Brüllen() {
		System.err.println("Chchchau");
		
	}





}
