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
	 * Methode permettant de verifier si la carte peut etre jouer sur la derniere carte
	 * @return true or false
	 */
	public boolean estOk(Carte carteAJouer){
		Carte derniereCarte = getDerniere();
		if( carteAJouer.getValeur()<10 && derniereCarte.getValeur()<10){
			if (carteAJouer.getCouleur() == derniereCarte.getCouleur() ){
				return true;
			}
			if (carteAJouer.getValeur() == derniereCarte.getValeur()){
				return true;
			}	
			
		}
		
		// Carte action à ajouter
		
		return false;
	}

	/**
	 * Methode permettant de retourner la ldernière carte du talon
	 */
	public Carte getDerniere(){
		
		int i = listCartesT.size() -1;
		return listCartesT.get(i);
	}
}
