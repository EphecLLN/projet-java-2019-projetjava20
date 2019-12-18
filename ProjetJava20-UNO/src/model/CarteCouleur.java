/**
 * 
 */
package model;

/**
 * @author Florence Salpietro & Amélie Courtin
 *
 */
public class CarteCouleur extends CarteAction {

	/**
	 * Constructeur de CarteCouleur
	 * @param categorie
	 * @param couleur
	 * @param valeur
	 * @param codeString
	 */
	public CarteCouleur(String categorie, String couleur, int valeur, String codeString) {
		super(categorie, couleur, valeur, codeString);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Methode permettant d'executer l'action d'une carte Couleur, c'est à dire choisir la couleur de la carte du Talon
	 */
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
