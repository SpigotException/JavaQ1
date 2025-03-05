package LineareDatenstrukturen.einfacheMethoden;

public class objekt {

    int zahl;

    public objekt(int zahl) {
        this.zahl = zahl;
    }

    public int getZahl() {
        return zahl;
    }

    public void setZahl(int zahl) {
        this.zahl = zahl;
    }

    @Override
    public String toString() {
        return "objekt [zahl=" + zahl + "]";
    }




}
