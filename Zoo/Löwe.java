package Zoo;

import javax.media.j3d.Sound;

public class L�we extends Raubkatze{

	public L�we(String name, int gewicht, boolean weiblich, int pdanger) {
		super(name, gewicht, weiblich, gewicht/100*2.5, pdanger);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Br�llen() {
		
		// TODO Auto-generated method stub
		System.out.println("Roar");
	}
	
	
	@Override
	public void b�rsten() {
	
		System.out.println("Roar");
	}

}
