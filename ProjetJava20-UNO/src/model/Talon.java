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
	
	/**
	 * Constructeur de Talon
	 * @param listCartesT
	 */
	public Talon(ArrayList<Carte> listCartesT){
		this.listCartesT = listCartesT;
	}
	
	/**
	 * Methode permettant d'ajouter une carte au talon
	 * @param carte
	 */
	public void addCarte(Carte carte){
		listCartesT.add(carte);
	}


	/**
	 * Methode toString permettant d'afficher proprement le talon
	 */
	public String toString(){
		return this.getDerniere().toString() + " Couleur : "+ this.getDerniere().getCouleur();
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
