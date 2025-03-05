package Klausur.test;

import gui.GUI;
import linear.List;

public class Main {
List<objekt> Veranstaltungen = new List<objekt>();

public List<objekt> ermittleSortierte(){
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
       } 
       return e;
       }

    
	public static void main(String[] args) {
		new GUI(new Main());
	}
}
    