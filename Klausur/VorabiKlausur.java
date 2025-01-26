package Klausur;

import linear.Stack;
import linear.StackWithViewer;
import netz.cserver;

public class VorabiKlausur {

  public static  StackWithViewer<VorabiKlausurObjekt> verlauf = new StackWithViewer<VorabiKlausurObjekt>();
  
          public static void main(String[] args) {
  
              verlauf.push(new VorabiKlausurObjekt(1, "Jonass"));
              verlauf.push(new VorabiKlausurObjekt(3431, "hallo"));
              verlauf.push(new VorabiKlausurObjekt(4, "nicoosfo"));
              verlauf.push(new VorabiKlausurObjekt(341, "fgdfg"));
              
            System.out.println(summeGewicht());
    }

     static public int summeGewicht(){
        int result = 0;
        verlauf.top();
        while(!verlauf.isEmpty()){
            int i = verlauf.top().getGewicht();
            result += i;
            StackWithViewer<VorabiKlausurObjekt> temp = new StackWithViewer<VorabiKlausurObjekt>();
            temp.push(verlauf.top());
            
    
        
    }
            return result;
}
}