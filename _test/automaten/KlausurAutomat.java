package _test.automaten;

import gui.GUI;

public class KlausurAutomat {
	private char[] alphabet = {'0','1','2','3','4','5','6','7','8','9'};
    
    public boolean imAlphabet(Character pZeichen){
        for(int i = 0; i< alphabet.length; i++) {
            if (pZeichen == alphabet[i]) {
                return true;
            }
        }
        return false;
    }
    int zustand = 0;
    public boolean testen(String pEingabe){
        for(int i = 0; i < pEingabe.length(); i++){
            char c = pEingabe.charAt(i);
            if(imAlphabet(c) == false){
                return false;
            }
            switch (zustand) {
                case 0:
                    if(c == '1'){
                        zustand ++;
                    }
                    break;
            
                default:
                    break;
            }
            if (zustand == 0) {
                return true;
            }
        }
                return false;
    

    }
	public static void main(String[] args) {
		new GUI(new KlausurAutomat());
	}


}
