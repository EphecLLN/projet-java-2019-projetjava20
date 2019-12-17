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
	private ArrayList <Carte> listCartesJ = new ArrayList<Carte>();
	protected int score;
	protected static ArrayList<Joueur> listJoueurs = new ArrayList<Joueur>();
	
	/**
	 * Constructeur de la classe Joueur
	 * @param nom
	 * @param listCartesJ
	 */
	public Joueur(String nom, ArrayList<Carte> listCartesJ, int score){
		this.nom  = nom;
		this.listCartesJ = listCartesJ;
		this.score = score;
		listJoueurs.add(this);
	}
	
	/**
	 * Methode permettant d'insérer une carte passée en paramètre dans la main du joueur (listCartes)
	 * @param carte
	 */
	public void insererCarte(Carte carte){
		listCartesJ.add(carte);
	}
	
	/**
	 * 
	 * Methode permettant de retirer une carte de la main du joueur (retirer de listCartes)
	 * @param carte
	 */
	public void tirerCarte(Carte carte){
		for(int i=0;i<getListCartesJ().size();i++){
			if(getListCartesJ().get(i).getCodeString().equals(carte.getCodeString())){
				listCartesJ.remove(i);
			}
		}
		/*if (listCartesJ.contains(carte)){
			listCartesJ.remove(carte);
		}
		System.out.println("tirer carte");
		listCartesJ.remove(carte);*/
		
	}

	/**
	 * Methode permettant au joueur d'indiquer qu'il lui reste une seule carte
	 */
	public void uno(){
		
	}
	
	/**
	 * Methode permettant de piocher une nouvelle carte dans la pioche
	 */
	public void piocher(){
		
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
	
	public String toString(){

		return getNom();
		
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

	/**
	 * @return the listJoueurs
	 */
	public static ArrayList<Joueur> getListJoueurs() {
		return listJoueurs;
	}

	/**
	 * @param listJoueurs the listJoueurs to set
	 */
	public void setListJoueurs(ArrayList<Joueur> listJoueurs) {
		Joueur.listJoueurs = listJoueurs;
	}
	
	
	
	
}
