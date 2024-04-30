package _test;
import linear.ListWithViewer;
import linear.List;
import sonstiges.Person;
import datenbank.DatabaseConnector;
import datenbank.QueryResult;
import gui.GUI;


public class DatenbankTest {
	private DatabaseConnector connector;
	
	public DatenbankTest() {
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
	public ListWithViewer<String> klassenUnterricht(String pFach){
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
	

	public ListWithViewer<String> klassenUnterricht1(){
		ListWithViewer<String> ergebnis = new ListWithViewer<String>();
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
		}
		return ergebnis;
	}
	
	public static void main(String[] args) {
		new GUI(new DatenbankTest());
	}
}
