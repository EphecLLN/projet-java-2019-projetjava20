/**
 * 
 */
package model;

/**
 * @author Florence Salpietro & Amélie Courtin
 *
 */
public class CarteCouleur extends CarteAction {

	public CarteCouleur(String categorie, String couleur, int valeur, String codeString) {
		super(categorie, couleur, valeur, codeString);
		// TODO Auto-generated constructor stub
	}
	
	
	public void Action(Partie partie, String couleur){
		
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
