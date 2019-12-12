/**
 * 
 */
package model;

/**
 * @author Florence Salpietro & Amélie Courtin
 *
 */
public class CartePlus extends CarteAction {
	
	private int nbPlus; // nombre de carte à piocher 

	public CartePlus(String categorie, String couleur, int valeur, String codeString) {
		super(categorie, couleur, valeur, codeString);
		// TODO Auto-generated constructor stub
	}
	
	public CartePlus(String categorie, String couleur, int valeur, String codeString, int nbPlus){
		super(categorie, couleur, valeur, codeString);
		this.nbPlus = nbPlus;
	}

	
	public void Action(Partie partie, String couleur){
		if(nbPlus==2) ActionPlus2(partie);
		else ActionPlus4(partie,couleur);
		
	}
	
	
	public void ActionPlus2(Partie partie){
		int i=0;
		while(i<3){
			partie.getPioche().retirer(partie.getJoueurSuivant());
			i++;
		}
	}
	
	public void ActionPlus4(Partie partie, String couleur){
		int i=0;
		while(i<5){
			partie.getPioche().retirer(partie.getJoueurSuivant());
			i++;
		}
		switch (couleur){
		case "V": 
			setCouleur("vert");
			break;
		case "B":
			setCouleur("bleu");
			break;
		case "R":
			setCouleur("rouge");
			break;
		case "J":
			setCouleur("jaune");
			break;
		default : 
			System.out.println("La couleur n'est pas au bon format");
	}
	}
		
}
