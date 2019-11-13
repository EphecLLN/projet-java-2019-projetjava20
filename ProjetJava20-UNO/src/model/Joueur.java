/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Florence Salpietro & Amélie Courtin
 *
 */
public class Joueur {
	
	private String nom;
	private int nbCartes;
	private ArrayList <Carte> listCartes;
	
	/**
	 * Constructeur de la classe Joueur
	 * @param nom
	 * @param listCartes
	 */
	public Joueur(String nom, ArrayList<Carte> listCartes){
		this.nom  = nom;
		this.listCartes = listCartes;
	}
	
	/**
	 * Methode permettant d'insérer une carte passée en paramètre dans la main du joueur (listCartes)
	 * @param carte
	 */
	public void insererCarte(Carte carte){
		listCartes.add(carte);
	}
	
	/**
	 * Methode permettant de retirer une carte de la main du joueur (retirer de listCartes)
	 * @param carte
	 */
	public void tirerCarte(Carte carte){
		if (listCartes.contains(carte)){
			listCartes.remove(carte);
		}
		
	}

	/**
	 * Methode permettant au joueur d'indiquer qu'il lui reste une seule carte
	 */
	public void uno(){
		
	}
	
/*---------------------------GETTERS & SETTERS---------------------------*/
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the nbCartes
	 */
	public int getNbCartes() {
		return nbCartes;
	}

	/**
	 * @param nbCartes the nbCartes to set
	 */
	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
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
