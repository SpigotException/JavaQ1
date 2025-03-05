package Klausur.test;


import gui.GUI;
import linear.List;

public class Main {





public List<objekt> ermittleSortierte(){

    List<objekt> Veranstaltungen = new List<objekt>();

    Veranstaltungen.append(New objekt(1));
    Veranstaltungen.append(New objekt(2));
    Veranstaltungen.append(New objekt(10));
    Veranstaltungen.append(New objekt(9));
    List<objekt> e = new List<objekt>();
   List<objekt> h = Veranstaltungen;
   while(!h.isEmpty()){
    Veranstaltungen.toFirst();
    objekt max= Veranstaltungen.getContent();
    while(h.hasAccess()){
       objekt c = h.getContent();
       if(c.zahl > max.zahl){
           max = c;
         
           } h.next();
        }
        e.append(max);
        h.remove();
       } 
       return e;
       }

    
	public static void main(String[] args) {
		new GUI(new Main());
	}
}
    