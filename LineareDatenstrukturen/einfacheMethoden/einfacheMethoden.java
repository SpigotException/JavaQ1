package LineareDatenstrukturen.einfacheMethoden;

import gui.GUI;
import linear.ListWithViewer;

public class einfacheMethoden {
    public static void main(String[] args) {
        new GUI(new einfacheMethoden());
    }

    ListWithViewer<objekt> list = new ListWithViewer<objekt>();

    public einfacheMethoden() {

        list.append(new objekt(0));

        list.append(new objekt(7));
        list.append(new objekt(2));
        list.append(new objekt(3));
        list.append(new objekt(8));
        list.append(new objekt(5));
        list.append(new objekt(6));
        list.append(new objekt(1));
        list.append(new objekt(9));
        list.append(new objekt(4));
    }

    // größtes Objekt finden
    public objekt maxObjekt() {

        list.toFirst();
        objekt max = list.getContent();
        while (list.hasAccess()) {
            objekt current = list.getContent();
            if (current.getZahl() > max.getZahl()) {
                max = current;

            }
            list.next();
        }
        return max;

    }

    // Liste einfach sortieren
    public ListWithViewer<objekt> sortieren() {
        ListWithViewer<objekt> ergebnis = new ListWithViewer<>();
        ListWithViewer<objekt> h = list;
        while (!h.isEmpty()) {
            // größtest objekt finden
            h.toFirst();
            objekt max = h.getContent();
            while (h.hasAccess()) {
                objekt current = h.getContent();
                if (current.getZahl() > max.getZahl()) {
                    max = current;

                }
                h.next();
            }
            // größtes objekt aus der Liste entfern
            h.toFirst();
            while (h.hasAccess()) {
                objekt current = h.getContent();
                if (current.equals(max)) {
                    ergebnis.append(max);
                    h.remove();
                }
                h.next();
            }
            h.toFirst();
            max = h.getContent();
        }
        return ergebnis;

    }

    // einfacher Automat
    // der erkenne soll, ob in dem Wort 007 irgendwo vorkommt!
    private char[] alphabet = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    int zustand = 0;

    // überprüft ob das zeichen im alphabet ist
    public boolean imAlphabet(Character pZeichen) {
        for (int i = 0; i < alphabet.length; i++) {
            if (pZeichen.equals(alphabet[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean automat(String pString) {
        for (int i = 0; i < pString.length(); i++) {
            if (!imAlphabet(pString.charAt(i))) {
                return false;
            }
            switch (zustand) {
                case 0:
                    if (pString.charAt(i) == '0') {
                        zustand++;
                    }

                    break;
                case 1:
                    if (pString.charAt(i) == '0') {
                        zustand++;
                    }
                case 2:
                    if (pString.charAt(i) == '7') {
                        zustand++;
                    }

                default:
                    break;
            }

        }
        if (zustand == 3) {
            return true;
        } else
            return false;
    }
}
