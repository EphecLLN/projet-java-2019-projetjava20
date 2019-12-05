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
 * @author Florence Salpietro & Amélie Courtin
 *
 */
public class UnoVueConsole extends UnoVue implements Observer{
	
	
	protected Scanner sc;

	
	public UnoVueConsole(Partie model, UnoController controller) {
		super(model, controller);
		update(null, null);
	}

	/**
	 * 
	 */
	public void menu(){
		sc = new Scanner(System.in);
		
		affiche("Bienvenue dans UNO 2.0");
		affiche("[1] Démarrer une partie");
		affiche("[2] Quitter ");
		
		//Scanner scanner = new Scanner (System.in);
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
		

	}


	

	@Override
	public void update(Observable o, Object arg) {
		//System.out.println(model);
		menu();
	}

	@Override
	public void affiche(String string) {
		System.out.println(string);		
	}
	

}
