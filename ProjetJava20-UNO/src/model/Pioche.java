package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Florence Salpietro & Amélie Courtin
 *
 */
public class Pioche {
	
	public ArrayList<Carte> listCartesP=  new ArrayList<Carte>();
	public int nbCarte = listCartesP.size();
	
	
	public Pioche(ArrayList<Carte> listCartesP){
		this.listCartesP = listCartesP;
	}

	public void melanger(){
	
		Collections.shuffle(listCartesP);
	}
	
	/**
	 * Methode permettant de retirer la derniere carte de la pioche 
	 */
	public void retirer(){
		
	}
	
	public void distribuer(){
		
		melanger();
		
		for(int i=0; i<Joueur.getListJoueurs().size() ; i++){
			for(int j=0; j<8;j++){
			Joueur.getListJoueurs().get(i).getListCartesJ().add(listCartesP.get(j));
			listCartesP.remove(j);
			}
		}
		
	}
}
