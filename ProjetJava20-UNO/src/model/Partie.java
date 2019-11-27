package model;

/**
 * @author Courtin
 *
 **/

public class Partie {
	
	public Joueur joueur;
	public  Joueur joueurEnCours ;
	public int sens;
	public int nbJoueur;
	public Joueur gagnant;
	private int score;

	public Partie(Joueur joueur, Joueur joueurEnCours, int sens, int nbJoueur, Joueur gagnant) {
		this.joueur = joueur;
		this.joueurEnCours = joueurEnCours;
		this.sens = sens;
		this.nbJoueur = nbJoueur;
		this.gagnant = gagnant;
	}


	
	
	
	 public void determinerSens() { 
		 
	 }
	 
	 public Joueur determinerJoueur () {
		return joueur ;
		 
	 }
	 
	 public int calculerScore (Joueur joueur) {
		return score;
		 
	 }



	 
	 //accesseurs mutateurs


	public Joueur getJoueur() {
		return joueur;
	}





	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}





	public Joueur getJoueurEnCours() {
		return joueurEnCours;
	}





	public void setJoueurEnCours(Joueur joueurEnCours) {
		this.joueurEnCours = joueurEnCours;
	}





	public int getSens() {
		return sens;
	}





	public void setSens(int sens) {
		this.sens = sens;
	}





	public int getNbJoueur() {
		return nbJoueur;
	}





	public void setNbJoueur(int nbJoueur) {
		this.nbJoueur = nbJoueur;
	}





	public Joueur getGagnant() {
		return gagnant;
	}





	public void setGagnant(Joueur gagnant) {
		this.gagnant = gagnant;
	}
	

}
