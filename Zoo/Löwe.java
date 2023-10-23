package Zoo;

import javax.media.j3d.Sound;

public class Löwe extends Raubkatze{

	public Löwe(String name, int gewicht, boolean weiblich, int pdanger) {
		super(name, gewicht, weiblich, gewicht/100*2.5, pdanger);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Brüllen() {
		
		// TODO Auto-generated method stub
		System.out.println("Roar");
	}
	
	
	@Override
	public void bürsten() {
	
		System.out.println("Roar");
	}

}
