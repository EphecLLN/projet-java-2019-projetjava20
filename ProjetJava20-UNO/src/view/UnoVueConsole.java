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
 * @author Florence Salpietro & Am�lie Courtin
 *
 */
public class UnoVueConsole extends UnoVue implements Observer{
	
	
	protected Scanner sc;
	private String codeCarte = "" ;


	
	public UnoVueConsole(Partie model, UnoController controller) {
		super(model, controller);
		update(null, null);
		menu();
	}

	/**
	 * 
	 */
	public void menu(){
		sc = new Scanner(System.in);
		
		affiche("Bienvenue dans UNO 2.0");
		affiche("[1] D�marrer une partie");
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
	 * 
	 */
	public void jeu(){
		
		affiche("Combien de joueurs participeront � cette partie ? ");
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
	 * Manche 
	 */
	public void manche(){

		affiche("Talon : "+model.getTalon().getDerniere().toSring());

		System.out.println(model.getJoueurEnCours());
		affiche("C'est � toi de jouer, voici tes cartes : ");
		for(int i=0; i<model.getJoueurEnCours().getListCartesJ().size() ; i++){
			
			System.out.println(model.getJoueurEnCours().getListCartesJ().get(i).toSring());
		}
		
		affiche("Talon : "+model.getTalon().getDerniere().toSring());
		
		affiche("Joue une carte pu �crit pioche pour une nouvelle carte (chiffre+Premi�re lettre   ex: 5V)");
		
		String reponse = sc.nextLine();
		
		Carte carte = null;
		
		if (reponse.equals("pioche")){
			System.out.println("test1");
			model.getPioche().retirer(model.getJoueurEnCours());
			System.out.println("test2");
			manche();
		}
		else if (reponse.equals("passe")){
			//d
			model.determinerJoueur();

		}
		else {
			for( int i =0; i<model.getJoueurEnCours().getListCartesJ().size();i++){
				System.out.println("FOR");
				if(reponse.equals(model.getJoueurEnCours().getListCartesJ().get(i).getCodeString())){
					System.out.println("1ERIF");
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
			//carte = new CarteChiffre("chiffre",null, 20 , reponse);

			if (model.estOk(carte)){
				model.getJoueurEnCours().tirerCarte(carte);
				model.getTalon().addCarte(carte);
				affiche("bien jou�");
				}
			else{
				affiche("Tu ne peux pas jouer cette carte");
			}
		
		}
		
	}
	
	
	public void tourJoueur(){
		
	}



	@Override
	public void update(Observable o, Object arg) {
		//System.out.println(model);
		//menu();
		model.getJoueurEnCours();
		//model.getJoueurEnCours().getListCartesJ();
		model.getListJoueurs();
		model.getPioche();
		model.getTalon();
		
	}

	@Override
	public void affiche(String string) {
		System.out.println(string);		
	}
	

}
