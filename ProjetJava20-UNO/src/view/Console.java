/**
 * 
 */
package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Carte;
import model.Joueur;
import model.Partie;
import model.Pioche;
import model.Talon;

/**
 * @author Florence Salpietro & Amélie Courtin
 *
 */
public class Console {
	
	
	protected static Pioche pioche;

	/**
	 * 
	 */
	public static void menu(){
		System.out.println("Bienvenue dans UNO 2.0");
		System.out.println("[1] Démarrer une partie");
		System.out.println("[2] Quitter ");
		
		Scanner scanner = new Scanner (System.in);
		int  selection = scanner.nextInt();
		
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
	public static void jeu(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Combien de joueurs participeront à cette partie ? ");
		int nb = sc.nextInt();
		Object[] tab = new Object[nb];
		
		for (int i=1; i<=nb; i++){
			System.out.println("Indiquer le nom du joueur"+ i);
			String name = sc.nextLine();
			tab[i-1] = name;
		}
		
		for(int j =0; j<tab.length; j++){
			String name = (String) tab[j];
			tab[j] = new Joueur(name,null,0);

		}
		
		ArrayList<Joueur> lj = new ArrayList();
		lj = Joueur.getListJoueurs();
		Partie partie = new Partie(lj, null, 0, null);
		
		creaCartes();

		pioche.distribuer();
		
		Talon talon = new Talon(null);//creer avec la derniere carte de la pioche

	}

	public static void creaCartes(){
		Carte b0 = new Carte ("chiffre", "bleu", 0);
		Carte b11 = new Carte ("chiffre", "bleu", 1);
		Carte b12 = new Carte ("chiffre", "bleu", 1);
		Carte b21 = new Carte ("chiffre", "bleu", 2);
		Carte b22 = new Carte ("chiffre", "bleu", 2);
		Carte b31 = new Carte ("chiffre", "bleu", 3);
		Carte b32 = new Carte ("chiffre", "bleu", 3);
		Carte b41 = new Carte ("chiffre", "bleu", 4);
		Carte b42 = new Carte ("chiffre", "bleu", 4);
		Carte b51 = new Carte ("chiffre", "bleu", 5);
		Carte b52 = new Carte ("chiffre", "bleu", 5);
		Carte b61 = new Carte ("chiffre", "bleu", 6);
		Carte b62 = new Carte ("chiffre", "bleu", 6);
		Carte b71 = new Carte ("chiffre", "bleu", 7);
		Carte b72 = new Carte ("chiffre", "bleu", 7);
		Carte b81 = new Carte ("chiffre", "bleu", 8);
		Carte b82 = new Carte ("chiffre", "bleu", 8);
		Carte b91 = new Carte ("chiffre", "bleu", 9);
		Carte b92 = new Carte ("chiffre", "bleu", 9);

		Carte r0 = new Carte ("chiffre", "rouge",0);
		Carte r11 = new Carte ("chiffre", "rouge",1);
		Carte r12 = new Carte ("chiffre", "rouge",1);
		Carte r21 = new Carte ("chiffre", "rouge",2);
		Carte r22 = new Carte ("chiffre", "rouge",2);
		Carte r31 = new Carte ("chiffre", "rouge",3);
		Carte r32 = new Carte ("chiffre", "rouge",3);
		Carte r41 = new Carte ("chiffre", "rouge",4);
		Carte r42 = new Carte ("chiffre", "rouge",4);
		Carte r51 = new Carte ("chiffre", "rouge",5);
		Carte r52 = new Carte ("chiffre", "rouge",5);
		Carte r61 = new Carte ("chiffre", "rouge",6);
		Carte r62 = new Carte ("chiffre", "rouge",6);
		Carte r71 = new Carte ("chiffre", "rouge",7);
		Carte r72 = new Carte ("chiffre", "rouge",7);
		Carte r81 = new Carte ("chiffre", "rouge",8);
		Carte r82 = new Carte ("chiffre", "rouge",8);
		Carte r91 = new Carte ("chiffre", "rouge",9);
		Carte r92 = new Carte ("chiffre", "rouge",9);
		
		Carte v0 = new Carte ("chiffre", "vert", 0);
		Carte v11 = new Carte ("chiffre", "vert", 1);
		Carte v12 = new Carte ("chiffre", "vert", 1);
		Carte v21 = new Carte ("chiffre", "vert", 2);
		Carte v22 = new Carte ("chiffre", "vert", 2);
		Carte v31 = new Carte ("chiffre", "vert", 3);
		Carte v32 = new Carte ("chiffre", "vert", 3);
		Carte v41 = new Carte ("chiffre", "vert", 4);
		Carte v42 = new Carte ("chiffre", "vert", 4);
		Carte v51 = new Carte ("chiffre", "vert", 5);
		Carte v52 = new Carte ("chiffre", "vert", 5);
		Carte v61 = new Carte ("chiffre", "vert", 6);
		Carte v62 = new Carte ("chiffre", "vert", 6);
		Carte v71 = new Carte ("chiffre", "vert", 7);
		Carte v72 = new Carte ("chiffre", "vert", 7);
		Carte v81 = new Carte ("chiffre", "vert", 8);
		Carte v82 = new Carte ("chiffre", "vert", 8);
		Carte v91 = new Carte ("chiffre", "vert", 9);
		Carte v92 = new Carte ("chiffre", "vert", 9);
		
		Carte j0 = new Carte ("chiffre", "jaune", 0);
		Carte j11 = new Carte ("chiffre", "jaune", 1);
		Carte j12 = new Carte ("chiffre", "jaune", 1);
		Carte j21 = new Carte ("chiffre", "jaune", 2);
		Carte j22 = new Carte ("chiffre", "jaune", 2);
		Carte j31 = new Carte ("chiffre", "jaune", 3);
		Carte j32 = new Carte ("chiffre", "jaune", 3);
		Carte j41 = new Carte ("chiffre", "jaune", 4);
		Carte j42 = new Carte ("chiffre", "jaune", 4);
		Carte j51 = new Carte ("chiffre", "jaune", 5);
		Carte j52 = new Carte ("chiffre", "jaune", 5);
		Carte j61 = new Carte ("chiffre", "jaune", 6);
		Carte j62 = new Carte ("chiffre", "jaune", 6);
		Carte j71 = new Carte ("chiffre", "jaune", 7);
		Carte j72 = new Carte ("chiffre", "jaune", 7);
		Carte j81 = new Carte ("chiffre", "jaune", 8);
		Carte j82 = new Carte ("chiffre", "jaune", 8);
		Carte j91 = new Carte ("chiffre", "jaune", 9);
		Carte j92 = new Carte ("chiffre", "jaune", 9);
		
		Pioche pioche = new Pioche(v0.getListCartes());	

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		


	
	menu();
	
	
			// pioche vide
	}
	

}
