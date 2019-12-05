/**
 * 
 */
package controller;

import java.util.ArrayList;

import model.Carte;
import model.Joueur;
import model.Partie;
import model.Pioche;
import model.Talon;
import view.UnoVue;

/**
 * @author Florence
 *
 */
public class UnoController {
	
	Partie model;
	UnoVue view;
	//Console vue;
	private  ArrayList<Carte> lisCart = new ArrayList<Carte>();

	
	public UnoController(Partie model){
		this.model = model;
	}

	public void addVue(UnoVue view){
		this.view = view;
	}
	
	/**
	 * Creer toutes les cartes du UNO
	 */
	public void creaCartes(){
		
		String tab [] = {"jaune", "rouge", "bleu","vert"};
		int num []  = {0,1,2,3,4,5,6,7,8,9};
		
		for(int i=0; i<tab.length; i++){
			for(int j=0; j<num.length; j++){
				lisCart.add(new Carte( "chiffre",tab[i], num[j]));
				
			}
		}
	}
	
	/**
	 * Creer le jeu avec une liste de joueurs en param
	 * @param lj
	 */
	public void initJeu(ArrayList<Joueur> lj){
		System.out.println(model.getListeJoueurs());

		//Partie partie = new Partie(lj, null, 0, null); // new dans new ???
		

		model.setListeJoueurs(lj);
		
		
		System.out.println("test3");
		
		creaCartes();
				
		Pioche pioche = new Pioche(getLisCart());
				
		pioche.distribuer();
		
		Talon talon = new Talon(new ArrayList<Carte>());//creer avec la derniere carte de la pioche
		
		talon.getListCartesT().add(pioche.retirer()); // ajoute la derniere carte de la pioche au talon
		
		model.setJoueurEnCours(lj.get(0));
		
		model.determinerJoueur();
		
		System.out.println("list lj"+lj);
		System.out.println("model getlist/partie"+model.getListeJoueurs());//prob null

		
	}
	
	
	

	/**
	 * @return the lisCart
	 */
	public ArrayList<Carte> getLisCart() {
		return lisCart;
	}

	/**
	 * @param lisCart the lisCart to set
	 */
	public void setLisCart(ArrayList<Carte> lisCart) {
		this.lisCart = lisCart;
	}

	/**
	 * @return the joueurEnCours
	 */
	public Joueur getJoueurEnCours() {
		return model.getJoueurEnCours();
	}
	

}
