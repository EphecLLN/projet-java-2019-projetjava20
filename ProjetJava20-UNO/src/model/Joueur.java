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
	private ArrayList <Carte> listCartesJ;
	protected int score;
	
	/**
	 * Constructeur de la classe Joueur
	 * @param nom
	 * @param listCartesJ
	 */
	public Joueur(String nom, ArrayList<Carte> listCartesJ, int score){
		this.nom  = nom;
		this.listCartesJ = listCartesJ;
		this.score = score;
	}
	
	/**
	 * Methode permettant d'insérer une carte passée en paramètre dans la main du joueur (listCartes)
	 * @param carte
	 */
	public void insererCarte(Carte carte){
		listCartesJ.add(carte);
	}
	
	/**
	 * Methode permettant de retirer une carte de la main du joueur (retirer de listCartes)
	 * @param carte
	 */
	public void tirerCarte(Carte carte){
		if (listCartesJ.contains(carte)){
			listCartesJ.remove(carte);
		}
		
	}

	/**
	 * Methode permettant au joueur d'indiquer qu'il lui reste une seule carte
	 */
	public void uno(){
		
	}
	
	/**
	 * Methode equals 
	 */
	public boolean equals(Object obj){
		if (this==obj){
			return true;
		}
		if (obj==null){
			return false;
		}
		return false;
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
	public ArrayList<Carte> getListCartesJ() {
		return listCartesJ;
	}

	/**
	 * @param listCartes the listCartes to set
	 */
	public void setListCartesJ(ArrayList<Carte> listCartesJ) {
		this.listCartesJ = listCartesJ;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
