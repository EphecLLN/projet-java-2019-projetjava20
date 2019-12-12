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

carte.Action(partie);

System.out.println(partie.getSens());
	}
	
	

}
