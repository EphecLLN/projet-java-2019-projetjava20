/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Florence Salpietro & Amélie Courtin
 *
 */
public class Talon {

	public ArrayList<Carte> listCartesT;
	
	public Talon(ArrayList<Carte> listCartesT){
		this.listCartesT = listCartesT;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean estOk(){
		return true;
	}

	/**
	 * 
	 */
	public void getDerniere(){
		
	}
}
