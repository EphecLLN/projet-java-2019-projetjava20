package model;

import java.util.ArrayList;
import java.util.Observable;

/**
 * @author Courtin
 *
 */
public class Partie extends Observable{
	
	public Joueur joueur;
	public  Joueur joueurEnCours ;
	public int sens;
	public int nbJoueur;
	public Joueur gagnant; //joueur qui gagne une manche
	protected int score;
	public ArrayList <Joueur> listeJoueurs;
	public Joueur vainqueur; //joueur qui gagne la partie partie

	/**
	 * Constructeur
	 * @param listeJoueurs
	 * @param joueurEnCours
	 * @param sens
	 * @param gagnant
	 */
	public Partie(ArrayList<Joueur> listeJoueurs, Joueur joueurEnCours, int sens, Joueur gagnant) {
		this.listeJoueurs = listeJoueurs;
		this.joueurEnCours = joueurEnCours;
		this.sens = sens;
		this.gagnant = gagnant;
	}

	
	 //public void determinerSens() { 
		 
	 //}
	 
	/**
	 * Determiner le joueur qui doit jouer 
	 * @return
	 */
	public Joueur determinerJoueur () {
		 if (sens==0){
   		   for (int i=0; i<listeJoueurs.size(); i++) {
			  if (listeJoueurs.get(i).equals(joueurEnCours)) {
				if(i==listeJoueurs.size()-1){
					joueurEnCours=listeJoueurs.get(0);					
				}
				else{
					joueurEnCours=listeJoueurs.get(i+1);
				}
			  }
		 	} 
		 }
		 
		 if(sens==1) {
			 for (int i=0; i<listeJoueurs.size(); i++) {
					if (listeJoueurs.get(i).equals(joueurEnCours)) {
						if(i==0){							
							joueurEnCours=listeJoueurs.get(listeJoueurs.size()-1);							
						}
						else {
							joueurEnCours=listeJoueurs.get(i-1);
						}
					}
			  } 
		 }
		 
		return joueurEnCours;
		 
	 }
	 
	/**
	 *  
	 * @param gagnant
	 * @return
	 */
	public int calculerScore (Joueur gagnant) {
		 
		 score = 0;
		
		 for(int i=0; i<listeJoueurs.size(); i++) {
			 
			 int scoreI = 0;
			 Joueur j = listeJoueurs.get(i);
			 ArrayList<Carte> cartes = j.getListCartesJ();
			 
			 for( int x=0;x<cartes.size();x++){
				scoreI += cartes.get(x).getValeur();			 
			 }
			 
			 score += scoreI;
		 }
		 
		 this.setChanged();
		 this.notifyObservers();
		
		 return score;
		
		
		 
	 }

	 /**
	 * @return 
	  * 
	  */
	 public Joueur determinerGagnant() {
		//parcourir la liste de carte de chaque joueur, verifier si elle est vide ou non, retourner le joueur dont la liste est vide et alors il est gagnant
		//boucle for 
		 for (int i=0; i<listeJoueurs.size(); i++) {
			 	
			 Joueur j = listeJoueurs.get(i);
			 ArrayList<Carte> cartes = j.getListCartesJ();
			 
			 if (cartes.isEmpty()) {
				 gagnant =j;
			 };
		  }	
		 this.setChanged();
		 this.notifyObservers();
		 return gagnant;
	}
	 
	 /**
	  * 
	  */
	 public void determinerVainqueur() {
		 for (int i=0; i<listeJoueurs.size(); i++) { 
			 if(listeJoueurs.get(i).getScore()>500){
				 vainqueur = listeJoueurs.get(i);
			 }
			 
			 this.setChanged();
			 this.notifyObservers();
		 }
	 }


/*---------------------------GETTERS & SETTERS---------------------------*/

	 
	/**
	 * @return the joueur
	 */
	public Joueur getJoueur() {
		return joueur;
	}


	/**
	 * @param joueur the joueur to set
	 */
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
		 this.setChanged();
		 this.notifyObservers();
	}


	/**
	 * @return the joueurEnCours
	 */
	public Joueur getJoueurEnCours() {
		return joueurEnCours;
	}


	/**
	 * @param joueurEnCours the joueurEnCours to set
	 */
	public void setJoueurEnCours(Joueur joueurEnCours) {
		this.joueurEnCours = joueurEnCours;
		 this.setChanged();
		 this.notifyObservers();
	}


	/**
	 * @return the sens
	 */
	public int getSens() {
		return sens;
	}


	/**
	 * @param sens the sens to set
	 */
	public void setSens(int sens) {
		this.sens = sens;
		 this.setChanged();
		 this.notifyObservers();
	}


	/**
	 * @return the nbJoueur
	 */
	public int getNbJoueur() {
		return nbJoueur;
	}


	/**
	 * @param nbJoueur the nbJoueur to set
	 */
	public void setNbJoueur(int nbJoueur) {
		this.nbJoueur = nbJoueur;
		 this.setChanged();
		 this.notifyObservers();
	}


	/**
	 * @return the gagnant
	 */
	public Joueur getGagnant() {
		return gagnant;
	}


	/**
	 * @param gagnant the gagnant to set
	 */
	public void setGagnant(Joueur gagnant) {
		this.gagnant = gagnant;
		 this.setChanged();
		 this.notifyObservers();
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
		 this.setChanged();
		 this.notifyObservers();
	}


	/**
	 * @return the listeJoueurs
	 */
	public ArrayList<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}


	/**
	 * @param listeJoueurs the listeJoueurs to set
	 */
	public void setListeJoueurs(ArrayList<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
		 this.setChanged();
		 this.notifyObservers();
	}


	/**
	 * @return the vainqueur
	 */
	public Joueur getVainqueur() {
		return vainqueur;
	}


	/**
	 * @param vainqueur the vainqueur to set
	 */
	public void setVainqueur(Joueur vainqueur) {
		this.vainqueur = vainqueur;
		 this.setChanged();
		 this.notifyObservers();
	}

}
