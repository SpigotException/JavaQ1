package _test;
import linear.List;
import linear.ListWithViewer;
import gui.GUI;
import Hotel.Hotelbewertungssystem;
import baeume.BinaryTree;
import baeume.TreeViewer;


public class BinaryTreeTest {
	public BinaryTree<Integer> suchbaum;
	
	public BinaryTreeTest(){
        suchbaum = new BinaryTree<Integer>(59);
        BinaryTree<Integer> b4= new BinaryTree<Integer>(4);
        BinaryTree<Integer> b34 = new BinaryTree<Integer>(34);
        BinaryTree<Integer> b16 = new BinaryTree<Integer>(16);
        BinaryTree<Integer> b7= new BinaryTree<Integer>(7);
        BinaryTree<Integer> b6 = new BinaryTree<Integer>(6);
        BinaryTree<Integer> b12 = new BinaryTree<Integer>(12);
        BinaryTree<Integer> b18= new BinaryTree<Integer>(18);
        BinaryTree<Integer> b17= new BinaryTree<Integer>(17);
        BinaryTree<Integer> b53 = new BinaryTree<Integer>(53);
        BinaryTree<Integer> b45 = new BinaryTree<Integer>(45);
        BinaryTree<Integer> b78 = new BinaryTree<Integer>(78);
        BinaryTree<Integer> b62 = new BinaryTree<Integer>(62);
        BinaryTree<Integer> b61= new BinaryTree<Integer>(61);
        BinaryTree<Integer> b71 = new BinaryTree<Integer>(71);
        BinaryTree<Integer> b73 = new BinaryTree<Integer>(73);
        
        suchbaum.setLeftTree(b4);
        b4.setRightTree(b34);
        b7.setLeftTree(b6);
        b7.setRightTree(b12);
        b16.setRightTree(b18);
        b18.setLeftTree(b17);
        b16.setLeftTree(b7);
        b34.setLeftTree(b16);
        b34.setRightTree(b53);
        b53.setLeftTree(b45);
        suchbaum.setRightTree(b78);
        b78.setLeftTree(b62);
        b62.setLeftTree(b61);
        b62.setRightTree(b71);
        b71.setRightTree(b73);
        TreeViewer.showTree(suchbaum, 600, 400);
	}
	
	// Rahmenmethode

	// Rahmenmethode
	public int summe () {
	return summe (suchbaum);
	}
	private int summe (BinaryTree<Integer> pTree) {	
	int ergebnis = 0;

	if( pTree.isEmpty()) {
	return 0;
	}

	int wurzelzahl = pTree.getContent ();

	int summeLinks = summe (pTree.getLeftTree());
	int summeRechts = summe (pTree.getRightTree());
	ergebnis = summeLinks + summeRechts + wurzelzahl;
	
	return ergebnis;
	
	}
	
	
	public int gibTiefe() {
		return gibTiefe (suchbaum);
		}
		private int gibTiefe (BinaryTree<Integer> pBaum) {
		int ergebnis = 0;

		if( pBaum.isEmpty()) {
		return -1;
		}
		
		int tiefel = gibTiefe (pBaum.getLeftTree());
		int tiefeR = gibTiefe (pBaum.getRightTree());


		if(tiefel > tiefeR) {
			ergebnis = tiefel + 1 ;
		}
	
		else {
		ergebnis = tiefeR + 1;
		
		}
		
		
		return ergebnis;
		}

		
		
		public List<Integer> postorder() {
			return postorder (suchbaum);
			}
			private List<Integer> postorder (BinaryTree<Integer> pBaum) {
			ListWithViewer<Integer> ergList = new ListWithViewer<>();
			// Abbruchbedingung
			if( pBaum.isEmpty()) {
			return ergList;

			}
			List<Integer> linkeListe = postorder(pBaum.getLeftTree());
			List<Integer> rechteListe = postorder(pBaum.getRightTree());
			
			int wurzelzahl = pBaum.getContent ();
			ergList.concat(linkeListe);
			ergList.concat(rechteListe);
			ergList.append (wurzelzahl);
			
			return ergList;
			}
			
			
		

			public static void main(String[] args) {
				new GUI(new Hotelbewertungssystem());
			}
}
