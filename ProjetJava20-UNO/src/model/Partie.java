package model;

import java.util.ArrayList;

/**
 * @author Courtin
 *
 */
public class Partie {
	
	public Joueur joueur;
	public  Joueur joueurEnCours ;
	public int sens;
	public int nbJoueur;
	public Joueur gagnant;
	protected int score;
	public ArrayList <Joueur> listeJoueur;

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
	 
	 public int calculerScore (Joueur gagnant) {
		 for(int i=0; i<listeJoueur.size(); i++) {
			 
			 Joueur j = listeJoueur.get(i);
			 ArrayList<Carte> cartes = j.getListCartesJ();
			 for( int x=0;x<cartes.size();x++){
				 
			 
			 }
			 
		 }
		return score;
		 
	 }


	 public void determinerGagnant() {
		//parcourir la liste de carte de chaque joueur, verifier si elle est vide ou non, retourner le joueur dont la liste est vie et alors il est gagnant
		//boucle for 
		 for (int i=0; i<listeJoueur.size(); i++) {
			 	
			 Joueur j = listeJoueur.get(i);
			 ArrayList<Carte> cartes = j.getListCartesJ();
			 
			 if (cartes.isEmpty()) {
				 gagnant =j;
			 };
			 }
			 
			 
			 
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
