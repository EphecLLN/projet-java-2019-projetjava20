package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Florence Salpietro & Amélie Courtin
 *
 */
public class Pioche {
	
	private ArrayList<Carte> listCartesP;
	//private int nbCarte = listCartesP.size();
	
	/**
	 * Constructeur
	 * @param listCartesP
	 */
	public Pioche(ArrayList<Carte> listCartesP){
		this.listCartesP = listCartesP;
	}

	/**
	 * Melange le tas de cartes
	 */
	public void melanger(){
	
		Collections.shuffle(listCartesP);
	}
	
	/**
	 * Methode permettant de retirer la derniere carte de la pioche 
	 */
	public void retirer(){
		
	}
	
	/**
	 * Methode permettant de distribuer 7 cartes à chaque joueur
	 */
	public void distribuer(){
		
		melanger();
		
		for(int i=0; i<Joueur.getListJoueurs().size() ; i++){
			for(int j=0; j<7;j++){
				Joueur.getListJoueurs().get(i).insererCarte(listCartesP.get(j));
				System.out.println("rempli");
				listCartesP.remove(j);
				}
		}
		
	}
	
	
	
	

	/**
	 * @return the listCartesP
	 */
	public ArrayList<Carte> getListCartesP() {
		return listCartesP;
	}

	/**
	 * @param listCartesP the listCartesP to set
	 */
	public void setListCartesP(ArrayList<Carte> listCartesP) {
		this.listCartesP = listCartesP;
	}


	
	
}
