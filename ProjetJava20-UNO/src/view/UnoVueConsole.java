package view;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.UnoController;
import model.Carte;
import model.CarteAction;
import model.CarteChiffre;
import model.CartePlus;
import model.Joueur;
import model.Partie;
import model.Pioche;
import model.Talon;

/**
 * @author Florence Salpietro & Amélie Courtin
 *
 */
public class UnoVueConsole extends UnoVue implements Observer{
	
	
	protected Scanner sc;
	protected Carte carte = null;


	/**
	 * Constrcuteur de UnoVue Console
	 * @param model
	 * @param controller
	 */
	public UnoVueConsole(Partie model, UnoController controller) {
		super(model, controller);
		update(null, null);
		menu();
	}

	/**
	 * Methode permettant la creation du menu principal
	 */
	public void menu(){
		sc = new Scanner(System.in);
		
		affiche("Bienvenue dans UNO 2.0");
		affiche("[1] Démarrer une partie");
		affiche("[2] Quitter ");
		
		int  selection = Integer.parseInt(sc.nextLine());
		
		switch (selection){
			case 1:
				jeu();
				
			case 2:
				affiche("Exit");
				System.exit(0);
				
			 default:
		    	 affiche("La selection n'est pas valide");
		    	 menu();
			
		}
	}
	
	/**
	 * Methode permettant la creation du jeu, une partie 
	 */
	public void jeu(){
		
		affiche("Combien de joueurs participeront à cette partie ? ");
		int nb = Integer.parseInt(sc.nextLine());
		Object[] tab = new Object[nb];
		String nom = null;
		
		for (int i=1; i<=nb; i++){
				affiche("Indiquer le nom du joueur"+ i);
				nom = sc.nextLine();
				tab[i-1] = nom;
		}
		
		for(int j =0; j<tab.length; j++){
			String name = (String) tab[j];
			tab[j] = new Joueur(name,new ArrayList<Carte>(),0);
		}
		
		ArrayList<Joueur> lj = new ArrayList<Joueur>(Joueur.getListJoueurs()); 

		controller.initJeu(lj);	
		
		manche();
		
		affiche("Exit");
		System.exit(0);

	}
	
	/**
	 * Methode permettant de creer une manche()
	 */
	public void manche(){

		//affiche("Talon : "+model.getTalon());
		affiche(model.getJoueurEnCours().toString()+" C'est à toi de jouer, voici tes cartes : ");
		for(int i=0; i<model.getJoueurEnCours().getListCartesJ().size() ; i++){
			
			affiche(model.getJoueurEnCours().getListCartesJ().get(i).toString());
		}
		
		affiche("Talon : "+model.getTalon().toString());
		
		affiche("Joue une carte pu écrit pioche pour une nouvelle carte (chiffre+Première lettre de la couleur Ex: 5V)");
		
		String reponse = sc.nextLine();
				
		if (reponse.equals("pioche")){
			model.getPioche().retirer(model.getJoueurEnCours());
			manche();
		}
		else if (reponse.equals("passe")){
			model.determinerJoueur();
			manche();

		}
		else {
			for( int i =0; i<model.getJoueurEnCours().getListCartesJ().size();i++){
				if(reponse.equals(model.getJoueurEnCours().getListCartesJ().get(i).getCodeString())){
					if(model.getJoueurEnCours().getListCartesJ().get(i).getCategorie().equals("action")){
						carte = new CarteAction("action", null, i, reponse);
						carte.setCategorie(model.getJoueurEnCours().getListCartesJ().get(i).getCategorie());
						carte.setCodeString(model.getJoueurEnCours().getListCartesJ().get(i).getCodeString());
						carte.setValeur(model.getJoueurEnCours().getListCartesJ().get(i).getValeur());
						carte.setCouleur(model.getJoueurEnCours().getListCartesJ().get(i).getCouleur());
					}
					else{
						carte = new CarteChiffre("chiffre",null, i , reponse);
						carte.setCategorie(model.getJoueurEnCours().getListCartesJ().get(i).getCategorie());
						carte.setCodeString(model.getJoueurEnCours().getListCartesJ().get(i).getCodeString());
						carte.setValeur(model.getJoueurEnCours().getListCartesJ().get(i).getValeur());
						carte.setCouleur(model.getJoueurEnCours().getListCartesJ().get(i).getCouleur());
					}
					
				}			
			}

			if (model.estOk(carte)){
				model.getJoueurEnCours().tirerCarte(carte);
				model.getTalon().addCarte(carte);
				affiche("Bien joué");

				if(model.determinerGagnant()){
					model.calculerScore(model.getGagnant());
					if(model.determinerVainqueur()){
						affiche("BRAVO!!!");
						System.exit(0);
					}
					else{
						affiche("Gagnant de la manche : "+model.getGagnant()+ "avec : "+model.getScore());
						for(int i=0; i<model.getListJoueurs().size();i++){
							model.getListJoueurs().get(i).setListCartesJ(null);
						}
						model.getPioche().distribuer();
						model.getPioche().melanger();
						model.getTalon().getListCartesT().add(model.getPioche().getDerniereCarte()); // ajoute la derniere carte de la pioche au talon
						model.getPioche().getListCartesP().remove(model.getPioche().getDerniereCarte());
						
						while(model.getTalon().getDerniere().getCategorie().equals("action")){
							model.getTalon().getListCartesT().add(model.getPioche().getDerniereCarte()); // ajoute la derniere carte de la pioche au talon
							model.getPioche().getListCartesP().remove(model.getPioche().getDerniereCarte());

						}
						model.determinerJoueur();
						manche();
					}
				}
				model.determinerJoueur();
				manche();
				
			}
			else{
				affiche("Tu ne peux pas jouer cette carte");
				manche();
			}
		
		}
		
	}
	
	

	@Override
	public void update(Observable o, Object arg) {
		model.getJoueurEnCours();
		model.getListJoueurs();
		model.getPioche();
		model.getTalon();
		
	}

	@Override
	public void affiche(String string) {
		System.out.println(string);		
	}
	

}
