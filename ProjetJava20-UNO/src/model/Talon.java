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
	
	public void addCarte(Carte carte){
		listCartesT.add(carte);
	}


	public String toString(){
		return this.getDerniere().toString();
	}

	/**
	 * Methode permettant de retourner la ldernière carte du talon
	 */
	public Carte getDerniere(){
		
		int i = listCartesT.size() -1;
		return listCartesT.get(i);
	}

	/**
	 * @return the listCartesT
	 */
	public ArrayList<Carte> getListCartesT() {
		return listCartesT;
	}

	/**
	 * @param listCartesT the listCartesT to set
	 */
	public void setListCartesT(ArrayList<Carte> listCartesT) {
		this.listCartesT = listCartesT;
	}
	
	
	
}
