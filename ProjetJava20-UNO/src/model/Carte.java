/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Florence Salpietro & Amélie Courtin
 *
 */
public abstract class Carte{
	
	protected String categorie;
	protected String couleur;
	protected int valeur;
	protected String codeString;
	protected ArrayList<Carte> listCartes = new ArrayList<Carte>();
	
	
	/**
	 * Constructeur de Carte
	 * @param categorie
	 * @param couleur
	 * @param valeur
	 */
	public  Carte(String categorie, String couleur, int valeur, String codeString){
		this.categorie = categorie;
		this.couleur = couleur;
		this.valeur = valeur;
		this.codeString = codeString;
		//listCartes.add(this);
		
	}
	
	
	/**
	 * Methode toString permettant l'affichage d'une carte proprement
	 */
	public String toString(){
		return this.codeString ;
	}
	
	
	public abstract void Action(Partie partie, String couleur);

	
	
	
	/**
	 * @return the codeString
	 */
	public String getCodeString() {
		return codeString;
	}


	/**
	 * @param codeString the codeString to set
	 */
	public void setCodeString(String codeString) {
		this.codeString = codeString;
	}


	/**
	 * @return the categorie
	 */
	public String getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the couleur
	 */
	public String getCouleur() {
		return couleur;
	}

	/**
	 * @param couleur the couleur to set
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	/**
	 * @return the valeur
	 */
	public int getValeur() {
		return valeur;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * @return the listCartes
	 */
	public ArrayList<Carte> getListCartes() {
		return listCartes;
	}

	/**
	 * @param listCartes the listCartes to set
	 */
	public void setListCartes(ArrayList<Carte> listCartes) {
		this.listCartes = listCartes;
	}


	public void Action() {
		// TODO Auto-generated method stub
		
	}
	
	
}
