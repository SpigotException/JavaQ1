package schule;

public class schueler {
	private String klasse;
	private String Name;
	private String vorname;


	

	public schueler(String klasse, String name, String vorname) {
		super();
		this.klasse = klasse;
		Name = name;
		this.vorname = vorname;
	}




	@Override
	public String toString() {
		return "schueler [klasse=" + klasse + ", Name=" + Name + ", vorname=" + vorname + "]";
	}



}
