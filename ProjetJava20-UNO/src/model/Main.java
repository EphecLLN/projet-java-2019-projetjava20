/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Florence
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Partie partie = new Partie(null, null, 1, null);

CarteInversion carte = new CarteInversion(null, null, 0, null);

carte.Action(partie, null);

Carte carteI = new CarteInversion(null,null,0,null);

carteI.Action(partie, null);



System.out.println(partie.getSens());
	}
	
	

}
