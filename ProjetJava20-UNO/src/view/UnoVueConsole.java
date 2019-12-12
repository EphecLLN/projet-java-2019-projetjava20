package view;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.UnoController;
import model.Carte;
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
		
		affiche("Joue une carte ( chiffre+Premi�re lettre   ex: 5V)");
		
		String reponse = sc.nextLine();
		
		model.estOk(reponse);
		

		
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
