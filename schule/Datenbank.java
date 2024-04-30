package schule;
import linear.ListWithViewer;
import linear.List;
import sonstiges.Person;
import datenbank.DatabaseConnector;
import datenbank.QueryResult;
import gui.GUI;


@SuppressWarnings("unused")
public class Datenbank {
	private DatabaseConnector connector;
	
	public Datenbank() {
		//                                    ip                       port database  user   password
		connector = new DatabaseConnector("10.232.130.4", 3306, "schule", "root", "");
		String errorMessage = connector.getErrorMessage();
		if(errorMessage != null) System.err.println(errorMessage);
	}
	

	/**
	 * Beispielmethode
	 * gibt eine Liste zurueck, in der fuer jede Klasse angegeben ist,
	 * wie viel Unterricht die Klasse in dem Fach hat.
	 * @param pFach das Fach
	 * @return
	 */
	/*public ListWithViewer<String> klassenUnterricht(String pFach){
		ListWithViewer<String> ergebnis = new ListWithViewer<String>();
		String sqlStatement = 
		  " SELECT k.name AS klasse, SUM(u.stunden) AS stunden "+
	      " FROM klasse k LEFT JOIN unterricht u "+
		  " ON k.id = u.klasse_id " +
          " AND u.fach = '"+pFach+"'"+
	      " GROUP BY k.name ";
		System.out.println(sqlStatement);

		connector.executeStatement(sqlStatement);

		String errorMessage = connector.getErrorMessage();
		if(errorMessage != null)
		{
			System.err.println(errorMessage);
			return null;
		}
		
		QueryResult queryResult = connector.getCurrentQueryResult();

		String[][] data = queryResult.getData();
		for (int i = 0; i < data.length; i++) {
			String klasse = data[i][0];
			String stundenString = data[i][1];
			int stunden = -1;
			if(stundenString == null || stundenString.toLowerCase().equals("null")) {
				stunden = 0;
			}
			else {
				stunden = Integer.parseInt(stundenString);
			}
			String zeile = klasse+": "+stunden+" "+pFach;
			System.out.println(zeile);
			ergebnis.append(zeile);
		}
		return ergebnis;
	}
	*/

	public ListWithViewer<String> klassenUnterricht1(){
		ListWithViewer<String> ergebnis = new ListWithViewer<String>();
		ListWithViewer<schueler> ergebnis1 = new ListWithViewer<schueler>();
		
		String sqlStatement = 
				"SELECT s.name , s.vorname, k.name\r\n"
				+ "FROM schueler  s\r\n"
				+ "JOIN klasse k ON\r\n"
				+ "s.klasse_id = k.id";
		System.out.println(sqlStatement);

		connector.executeStatement(sqlStatement);

		String errorMessage = connector.getErrorMessage();
		if(errorMessage != null)
		{
			System.err.println(errorMessage);
			return null;
		}
		
		QueryResult queryResult = connector.getCurrentQueryResult();

		String[][] data = queryResult.getData();
		for (int i = 0; i < data.length; i++) {
			String Name = data[i][0];
			String vorname = data[i][1];
			String klasse = data[i][2];


			String zeile = Name+": "+vorname +": "+ klasse;
			System.out.println(zeile);
			ergebnis.append(zeile);
			schueler s1 =		new schueler(klasse, Name, vorname);
			ergebnis1.append(s1);
		}
		return ergebnis;
	}
	public ListWithViewer<String> alleInfosZuKlasse(String pKlasse){
		ListWithViewer<String> ergebnis = new ListWithViewer<String>();
		ListWithViewer<schueler> ergebnis1 = new ListWithViewer<schueler>();
		
		String sqlStatement = 
				"SELECT k.name , l.vorname, l.name ,u.fach ,r.nummer\r\n"
				+ "FROM klasse k\r\n"
				+ "JOIN lehrer l \r\n"
				+ "ON k.klassenlehrer_id = l.id\r\n"
				+ "JOIN unterricht u \r\n"
				+ "ON k.id= u.klasse_id\r\n"
				+ "LEFT JOIN raum r\r\n"
				+ "ON r.id = u.raum_id\r\n"
				+ "WHERE k.name = '"+pKlasse+"'";
		
		
		
		System.out.println(sqlStatement);

		connector.executeStatement(sqlStatement);

		String errorMessage = connector.getErrorMessage();
		if(errorMessage != null)
		{
			System.err.println(errorMessage);
			return null;
		}
		
		QueryResult queryResult = connector.getCurrentQueryResult();

		String[][] data = queryResult.getData();
		for (int i = 0; i < data.length; i++) {
			String klassenName = data[i][0];

			String vorname = data[i][1];
			String name = data[i][2];
			String fach = data[i][3];
			String raum = data[i][4];

			int raumnummer = 0;

			String zeile = klassenName+": "+vorname +": " +name+fach+raum;
			System.out.println(zeile);
			ergebnis.append(zeile);
		//	schueler s1 =		new schueler(klasse, Name, vorname);
			//ergebnis1.append(s1);
		}
		return ergebnis;
	}
	
	
	public ListWithViewer<String> alleInfosZuLehrer(){
		ListWithViewer<String> ergebnis = new ListWithViewer<String>();
		ListWithViewer<schueler> ergebnis1 = new ListWithViewer<schueler>();
		
		String sqlStatement = 
				"SELECT l.name, l.vorname ,SUM(u.stunden)\r\n"
				+ "FROM lehrer l \r\n"
				+ "LEFT JOIN unterricht u\r\n"
				+ "ON u.lehrer_id = l.id\r\n"
				+ "GROUP BY l.id";
		
		
		
		System.out.println(sqlStatement);

		connector.executeStatement(sqlStatement);

		String errorMessage = connector.getErrorMessage();
		if(errorMessage != null)
		{
			System.err.println(errorMessage);
			return null;
		}
		
		QueryResult queryResult = connector.getCurrentQueryResult();

		String[][] data = queryResult.getData();
		for (int i = 0; i < data.length; i++) {
			String name = data[i][0];

			String vorname = data[i][1];
			String stundenstring = data[i][2];
			if (stundenstring == null) {
				stundenstring = "0";
			}


			int stunden = 0;
			stunden = Integer.parseInt(stundenstring);

			String zeile = vorname+name+ stunden;
			System.out.println(zeile);
			ergebnis.append(zeile);
		//	schueler s1 =		new schueler(klasse, Name, vorname);
			//ergebnis1.append(s1);
		}
		return ergebnis;
	}
	
	public static void main(String[] args) {
		new GUI(new Datenbank());
	}
}
