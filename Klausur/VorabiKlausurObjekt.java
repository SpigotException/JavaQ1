package Klausur;

public class VorabiKlausurObjekt {
    int gewicht;
    String name;
    public VorabiKlausurObjekt(int gewicht, String name) {
        this.gewicht = gewicht;
        this.name = name;
    }
    public int getGewicht() {
        return gewicht;
    }
    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "VorabiKlausurObjekt [gewicht=" + gewicht + ", name=" + name + "]";
    }


}
