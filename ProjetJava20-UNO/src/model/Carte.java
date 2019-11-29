/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Florence Salpietro & Am�lie Courtin
 *
 */
public class Carte {
	
	private String categorie;
	private String couleur;
	private int valeur;

	protected ArrayList<Carte> listCartes = new ArrayList<Carte>();
	/**
	 * Constructeur de Carte
	 * @param categorie
	 * @param couleur
	 * @param valeur
	 */
	public  Carte( String categorie, String couleur, int valeur){
		this.categorie = categorie;
		this.couleur = couleur;
		this.valeur = valeur;
		//listCartes.add(this);
		
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
	
	
}
