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
	public ArrayList <Joueur> listeJoueurs;
	public Joueur vainqueur;

	public Partie(ArrayList<Joueur> listeJoueurs, Joueur joueurEnCours, int sens, Joueur gagnant) {
		this.listeJoueurs = listeJoueurs;
		this.joueurEnCours = joueurEnCours;
		this.sens = sens;
		this.gagnant = gagnant;
	}

	
	 //public void determinerSens() { 
		 
	 //}
	 
	 public Joueur determinerJoueur () {
		 if (sens==0){
		 for (int i=0; i<listeJoueurs.size(); i++) {
			if (listeJoueurs.get(i).equals(joueurEnCours)) {
				if(i==listeJoueurs.size()-1){
					joueurEnCours=listeJoueurs.get(0);
					
				}
				else {
					joueurEnCours=listeJoueurs.get(i+1);
				};
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
						};
					}
				 } 
				 
			 
		 }
		 }
		return joueurEnCours ;
		 
	 }
	 
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
		return score;
		 
	 }


	 public void determinerGagnant() {
		//parcourir la liste de carte de chaque joueur, verifier si elle est vide ou non, retourner le joueur dont la liste est vie et alors il est gagnant
		//boucle for 
		 for (int i=0; i<listeJoueurs.size(); i++) {
			 	
			 Joueur j = listeJoueurs.get(i);
			 ArrayList<Carte> cartes = j.getListCartesJ();
			 
			 if (cartes.isEmpty()) {
				 gagnant =j;
			 };
			 }
			 
			 
			 
		 }
	 
	 public void determinerVainqueur() {
		 for (int i=0; i<listeJoueurs.size(); i++) { 
			 if(listeJoueurs.get(i).getScore()>500){
				 vainqueur = listeJoueurs.get(i);
			 }
		 }
	 }
	 
	 //accesseurs mutateurs

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



	public Joueur getGagnant() {
		return gagnant;
	}


	public void setGagnant(Joueur gagnant) {
		this.gagnant = gagnant;
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
	}
	
	

}
