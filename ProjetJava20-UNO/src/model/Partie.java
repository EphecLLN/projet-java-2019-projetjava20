package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

/**
 * @author Courtin
 *
 */
public class Partie extends Observable{
	
	private Joueur joueur;
	private  Joueur joueurEnCours;
	private Joueur joueurSuivant;
	private int sens;
	private int nbJoueur;
	protected Joueur gagnant; //joueur qui gagne une manche
	protected int score;
	private ArrayList <Joueur> listJoueurs;
	protected Joueur vainqueur; //joueur qui gagne la partie partie
	private ArrayList<Carte> listCartes = new ArrayList<Carte>();
	private Pioche pioche;
	private Talon talon;
	private Carte carteAJouer;


	
	/**
	 * Constructeur
	 * @param listeJoueurs
	 * @param joueurEnCours
	 * @param sens
	 * @param gagnant
	 */
	public Partie(ArrayList<Joueur> listJoueurs, Joueur joueurEnCours, int sens, Joueur gagnant) {
		this.listJoueurs = listJoueurs;
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
		boolean bool = true;
		 if (sens==0){
   		   for (int i=0; bool & i<listJoueurs.size(); i++) {
			  if (listJoueurs.get(i).equals(joueurEnCours)) {
				if(i==listJoueurs.size()-1){
					setJoueurEnCours(listJoueurs.get(0));
					setJoueurSuivant(listJoueurs.get(1));
					bool = false;
				}
				else if(i==listJoueurs.size()-2){
					setJoueurEnCours(listJoueurs.get(i+1));					
					setJoueurSuivant(listJoueurs.get(0));
					bool=false;

				}
				else{
					setJoueurEnCours(listJoueurs.get(i+1));
					bool=false;
				}
			  }

		 	} 
		 }
		 
		 if(sens==1) {
			 for (int i=0; i<listJoueurs.size(); i++) {
					if (listJoueurs.get(i).equals(joueurEnCours)) {
						if(i==0){							
							joueurEnCours=listJoueurs.get(listJoueurs.size()-1);
							joueurSuivant = listJoueurs.get(listJoueurs.size()-2);
						}
						else if(i==1){
							joueurEnCours = listJoueurs.get(i-1);
							joueurSuivant = listJoueurs.get(listJoueurs.size()-1);
						}
						else {
							joueurEnCours=listJoueurs.get(i-1);
							joueurSuivant = listJoueurs.get(i-2);
						}
					}
			  } 
		 }
		 
		return getJoueurEnCours();
			 
	 }
	 


	 /**
	 * @return 
	  * 
	  */
	 public boolean determinerGagnant() {
		//parcourir la liste de carte de chaque joueur, verifier si elle est vide ou non, retourner le joueur dont la liste est vide et alors il est gagnant
		//boucle for 
		 for (int i=0; i<listJoueurs.size(); i++) {
			 	
			 Joueur j = listJoueurs.get(i);
			 ArrayList<Carte> cartes = j.getListCartesJ();
			 
			 if (cartes.isEmpty()) {
				 setGagnant(j);
				 return true;
			 };
			 
		  }	
		 this.setChanged();
		 this.notifyObservers();
		 return false;
		
	}
	 
	 /**
	 * @return 
	  * 
	  */
	 public boolean determinerVainqueur() {
		 for (int i=0; i<listJoueurs.size(); i++) { 
			 if(listJoueurs.get(i).getScore()>100){
				 //vainqueur = listeJoueurs.get(i);
				 setVainqueur(listJoueurs.get(i));
				 this.setChanged();
				 this.notifyObservers();
				 return true;
			 }			
			 
		 }
		return false;
	 }

		/**
		 *  
		 * @param gagnant
		 * @return
		 */
		public void calculerScore (Joueur gagnant) {
			 			
			 for(int i=0; i<getListJoueurs().size(); i++) {
				 
				 int scoreI = 0;
				 Joueur j = getListJoueurs().get(i);
				 ArrayList<Carte> cartes = j.getListCartesJ();
				 
				 for( int x=0;x<cartes.size();x++){
					scoreI += cartes.get(x).getValeur();			 
				 }
				 
				 score += scoreI;
			 }
			
			 setChanged();
			 notifyObservers();			 
		 }
		
		/**
		 * Creer toutes les cartes du UNO
		 * @return une liste de toutes les cartes du jeu
		 */
		public ArrayList<Carte> creaCartes(){			
			String tab [] = {"jaune", "rouge", "bleu","vert"};
			int num []  = {0,1,2,3,4,5,6,7,8,9};
			String tabString []={"J", "R", "B", "V"};

			
			//cartes chiffrees
			for(int i=0; i<tab.length; i++){
				for(int j=0; j<num.length; j++){
					String chaine = num[j]+tabString[i];
					listCartes.add(new CarteChiffre( "chiffre",tab[i], num[j], chaine));
					
				}
			}
			
			//cartes actions
			//4 cartes changement de couleurs + Plus 4
			for(int i=0; i<4;i++){
				String chaine = "C"+tabString[i];
				String chaineP = "P4"+tabString[i];
				listCartes.add(new CarteCouleur("action", "noir", 50, chaine));
				listCartes.add(new CartePlus("action", "noir", 50, chaineP,4));
			}
			
			
			
			for(int i=0; i<tab.length;i++){
				String chaineP2 = "P2"+tabString[i];
				String chaineI = "I"+tabString[i];
				String chaineS = "S"+tabString[i];
				
				listCartes.add(new CartePlus("action", tab[i], 20, chaineP2, 2));
				listCartes.add(new CartePlus("action", tab[i], 20, chaineP2, 2));
				
				listCartes.add(new CarteInversion("action", tab[i], 20, chaineS));
				listCartes.add(new CarteInversion("action", tab[i], 20, chaineS));

				listCartes.add(new CarteInterdit("action",tab[i], 20, chaineI));
				listCartes.add(new CarteInterdit("action",tab[i], 20, chaineI));
				
			}

			return listCartes;
		}

		/**
		 * Methode permettant de verifier si la carte peut etre jouer sur la derniere carte
		 * @return true or false
		 */
		public boolean estOk(Carte carteAJouer){
			String codeCarte = null;
			Carte derniereCarte = talon.getDerniere();
			//for(int i=0; i<getJoueurEnCours().getListCartesJ().size();i++){
				//if(codeCarte.equals(getJoueurEnCours().getListCartesJ().get(i).getCodeString())){
					//carteAJouer = getJoueurEnCours().getListCartesJ().get(i); 
					if(carteAJouer.getValeur()<10 && derniereCarte.getValeur()<10){
						if (carteAJouer.getCouleur() == derniereCarte.getCouleur() ){
							return true;
						}
						if (carteAJouer.getValeur() == derniereCarte.getValeur()){
							return true;
						}	
						
						System.out.println("Vous ne pouvez pas jouer cette carte !");
						return false;//message ex
					}
					else{				
						if(carteAJouer.getCategorie().equals("action")){	
							switch (carteAJouer.getCodeString()){
							case "P2V":
							case "P2R":
							case "P2J":
							case "P2B":
								if(carteAJouer.getCouleur().equals(derniereCarte.getCouleur()) || derniereCarte.getCodeString().equals("P2R") || derniereCarte.getCodeString().equals("P2J")
										|| derniereCarte.getCodeString().equals("P2V") || derniereCarte.getCodeString().equals("P2B")){
									CartePlus carteP = new CartePlus(carteAJouer.getCategorie(), carteAJouer.getCouleur(), carteAJouer.getValeur(), carteAJouer.getCodeString(), 2);
									carteP.Action(this, null);
									return true;
								}
								else{
									affiche("Pas de Plus 2!");
									return false;
								}
						
							case "P4V":
							case "P4R":
							case "P4J":
							case "P4B":
								System.out.println("switch P4");
								CartePlus carteP4 = new CartePlus(carteAJouer.getCategorie(), carteAJouer.getCouleur(), carteAJouer.getValeur(), carteAJouer.getCodeString(), 4);
								String couleur = null;
								Scanner sc = new Scanner(System.in);
								System.out.println("Entrez la nouvelle couleur, V-B-R-J : ");
								couleur = sc.nextLine();
								carteP4.Action(this,couleur);
								carteAJouer.setCouleur(carteP4.getCouleur());
								return true;
								
							case "IJ":
							case "IV":
							case "IB":
							case "IR":
								if(carteAJouer.getCouleur().equals(derniereCarte.getCouleur())||derniereCarte.getCodeString().equals("IJ") || derniereCarte.getCodeString().equals("IV")
										||derniereCarte.getCodeString().equals("IB") ||derniereCarte.getCodeString().equals("IR")){
									CarteInterdit carteI = new CarteInterdit(carteAJouer.getCategorie(), carteAJouer.getCouleur(), carteAJouer.getValeur(), carteAJouer.getCodeString());
									carteI.Action(this,null);
									return true;
								}
								else{
									affiche("Pas d' Interdit !");
									return false;
								}							
							case "CJ":
							case "CV":
							case "CB":
							case "CR":
								CarteCouleur carteC = new CarteCouleur(carteAJouer.getCategorie(), carteAJouer.getCouleur(), carteAJouer.getValeur(), carteAJouer.getCodeString());
								String couleurC = null;
								System.out.println("Entrez la nouvelle couleur, V-B-R-J : ");
								Scanner sc1 = new Scanner(System.in);
								couleurC = sc1.nextLine();
								carteC.Action(this,couleurC);
								carteAJouer.setCouleur(carteC.getCouleur());
								return true;
								
							case "SJ":
							case "SV":
							case "SB":
							case "SR":
								if(carteAJouer.getCouleur().equals(derniereCarte.getCouleur())){
									CarteInversion carteS = new CarteInversion(carteAJouer.getCategorie(), carteAJouer.getCouleur(), carteAJouer.getValeur(), carteAJouer.getCodeString());
									carteS.Action();
									return true;
								}
								else{
									affiche("Pas de changement de Sens !");
									return false;
								}
							default : 
								affiche(" FALSE ");
								return false;
							}
						}
					}
					
					if(carteAJouer.getCategorie().equals("chiffre")){
						switch (derniereCarte.getCodeString()){
						case "P2V":
						case "P2R":
						case "P2J":
						case "P2B":
							if(carteAJouer.getCouleur().equals(derniereCarte.getCouleur())){
								return true;
							}
							else{
								affiche("Pas la même couleur !");
								return false;
							}
					
						case "P4V":
						case "P4R":
						case "P4J":
						case "P4B":
						case "CJ":
						case "CV":
						case "CB":
						case "CR":
							if(carteAJouer.getCouleur().equals(derniereCarte.getCouleur())){
								return true;
							}
							System.out.println("pas la bonne couleur ");
							return false;							
						case "IJ":
						case "IV":
						case "IB":
						case "IR":
							if(carteAJouer.getCouleur().equals(derniereCarte.getCouleur())){
								return true;
							}
							else{
								affiche("Pas la bonne couleur !");
								return false;
							}							
							
						case "SJ":
						case "SV":
						case "SB":
						case "SR":
							if(carteAJouer.getCouleur().equals(derniereCarte.getCouleur())){
								return true;
							}
							else{
								affiche("Pas la bonne couleur !");
								return false;
							}
						default : 
							affiche(" FALSE ");
							return false;
						}
				}
					return false;
		}

		
					
			// Carte action à ajouter
			//System.out.println("estOk FALSE");
		
		
		private void affiche(String string) {
			// TODO Auto-generated method stub
			System.out.println(string);
		}


		/**
		 * Creer le jeu avec une liste de joueurs en param
		 * @param lj
		 */
		public void initJeu(ArrayList<Joueur> lj){			

			setListJoueurs(lj);
			
			System.out.println(getListJoueurs());

			pioche = new Pioche(creaCartes());
			pioche.distribuer();
			pioche.melanger();

			talon = new Talon(new ArrayList<Carte>());//creer avec la derniere carte de la pioche
			talon.getListCartesT().add(pioche.getDerniereCarte()); // ajoute la derniere carte de la pioche au talon
			pioche.getListCartesP().remove(pioche.getDerniereCarte());
			
			while(talon.getDerniere().getCategorie().equals("action")){
				talon.getListCartesT().add(pioche.getDerniereCarte()); // ajoute la derniere carte de la pioche au talon
				pioche.getListCartesP().remove(pioche.getDerniereCarte());

			}
			
			
			setJoueurEnCours(lj.get(0));
			setJoueurSuivant(lj.get(1));

			//determinerJoueur();
			
					
		}
/*---------------------------GETTERS & SETTERS---------------------------*/

	 
		
	/**
	 * @return the joueur
	 */
	public Joueur getJoueur() {
		return joueur;
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


	/**
	 * @return the pioche
	 */
	public Pioche getPioche() {
		return pioche;
	}


	/**
	 * @param pioche the pioche to set
	 */
	public void setPioche(Pioche pioche) {
		this.pioche = pioche;
	}


	/**
	 * @return the talon
	 */
	public Talon getTalon() {
		return talon;
	}


	/**
	 * @param talon the talon to set
	 */
	public void setTalon(Talon talon) {
		this.talon = talon;
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
	public ArrayList<Joueur> getListJoueurs() {
		return listJoueurs;
	}


	/**
	 * @param listeJoueurs the listeJoueurs to set
	 */
	public void setListJoueurs(ArrayList<Joueur> listJoueurs) {
		
		this.listJoueurs = listJoueurs;
				
		// this.setChanged();
		//this.notifyObservers();
		
		// ne change jamais au cours d'une partie...
		
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


	/**
	 * @return the joueurSuivant
	 */
	public Joueur getJoueurSuivant() {
		return joueurSuivant;
	}


	/**
	 * @param joueurSuivant the joueurSuivant to set
	 */
	public void setJoueurSuivant(Joueur joueurSuivant) {
		this.joueurSuivant = joueurSuivant;
	}


	/**
	 * @return the carteAJouer
	 */
	public Carte getCarteAJouer() {
		return carteAJouer;
	}


	/**
	 * @param carteAJouer the carteAJouer to set
	 */
	public void setCarteAJouer(Carte carteAJouer) {
		this.carteAJouer = carteAJouer;
	}

	
	
	
	
}
