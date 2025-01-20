package _test.automaten.spionage;



import gui.GUI;

public class KGBAutomat {
	public int zustand;
	private char[] alphabet = {'0','1','2','3','4','5','6','7','8','9'};

	public boolean imAlphabet(char pZeichen){

		for(int i = 0; i< alphabet.length; i++) {
			if (pZeichen == alphabet[i]) {
				return true;
			}
		}
		return false;
	}

	public boolean teste(String pEingabe){
		zustand = 0;
		for(int i = 0; i< pEingabe.length(); i++) {
			if (!imAlphabet(pEingabe.charAt(i))) {
				return false;
			}
			switch (zustand) {
			case 0:
				if (pEingabe.charAt(i) == '0') {
					zustand  ++;
				}
				break;
			case 1:
				if (pEingabe.charAt(i) == '0') {
					zustand ++;
				}
				break;
			case 2: 
				if (pEingabe.charAt(i) == '7') {
					zustand ++;
				}
				break;

			}if ( zustand == 2) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		new GUI(new KGBAutomat());
	}

}
