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
	private static ArrayList<Carte> lisCart = new ArrayList<Carte>();

	
	UnoVueConsole(Partie model, UnoController controller) {
		super(model, controller);
		sc = new Scanner(System.in);
		// TODO Auto-generated constructor stub
	}

	//protected static Pioche pioche;


	/**
	 * 
	 */
	public void menu(){
		System.out.println("Bienvenue dans UNO 2.0");
		System.out.println("[1] Démarrer une partie");
		System.out.println("[2] Quitter ");
		
		//Scanner scanner = new Scanner (System.in);
		int  selection = Integer.parseInt(sc.nextLine());
		
		switch (selection){
			case 1:
				jeu();
				
			case 2:
				System.out.println("Exit");
				System.exit(0);
				
			 default:
		    	 System.out.println("La selection n'est pas valide");
		    	 menu();
			
		}
	}
	
	/**
	 * 
	 */
	public void jeu(){
		
		System.out.println("Combien de joueurs participeront à cette partie ? ");
		int nb = Integer.parseInt(sc.nextLine());
		Object[] tab = new Object[nb];
		String nom = null;
		
		for (int i=1; i<=nb; i++){
				System.out.println("Indiquer le nom du joueur"+ i);
				nom = sc.nextLine();
			tab[i-1] = nom;
		}
		
		for(int j =0; j<tab.length; j++){
			String name = (String) tab[j];
			tab[j] = new Joueur(name,new ArrayList<Carte>(),0);

		}
		
		ArrayList<Joueur> lj = new ArrayList<Joueur>();
		lj = Joueur.getListJoueurs();
		
		Partie partie = new Partie(lj, null, 0, null);
			
		creaCartes();
				
		Pioche pioche = new Pioche(lisCart);
				
		pioche.distribuer();
		
		Talon talon = new Talon(new ArrayList<Carte>());//creer avec la derniere carte de la pioche
		
		talon.getListCartesT().add(pioche.retirer()); // ajoute la derniere carte de la pioche au talon
		
		System.out.println(partie.determinerJoueur());
		

	}

	public static void creaCartes(){
		
		String tab [] = {"jaune", "rouge", "bleu","vert"};
		int num []  = {0,1,2,3,4,5,6,7,8,9};
		
		for(int i=0; i<tab.length; i++){
			for(int j=0; j<num.length; j++){
				lisCart.add(new Carte( "chiffre",tab[i], num[j]));
				
			}
		}
	}
	
	/**
	 * @param args
	 */
	public void main(String[] args) {
		


	
	menu();
	
	
			// pioche vide
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	

}
