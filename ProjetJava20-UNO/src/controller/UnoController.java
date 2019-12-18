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
	 * Creer le jeu avec une liste de joueurs en param
	 * @param lj
	 */
	public void initJeu(ArrayList<Joueur> lj){
		model.initJeu(lj);	
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


}
