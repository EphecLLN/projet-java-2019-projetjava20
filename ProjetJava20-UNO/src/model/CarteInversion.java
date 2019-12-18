/**
 * 
 */
package model;

/**
 * @author Florence Salpietro & Amélie Courtin
 *
 */
public class CarteInversion extends CarteAction {

	/**
	 * Constructeur de Carte Inversion
	 * @param categorie
	 * @param couleur
	 * @param valeur
	 * @param codeString
	 */
	public CarteInversion(String categorie, String couleur, int valeur, String codeString) {
		super(categorie, couleur, valeur, codeString);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * 
	 * Methode permettant d'executer l'action d'une carte Inversion, c'est à dire changer le sens de la partie
	 */
	public void Action(Partie partie, String couleur){
		if (partie.getSens() == 1){
			partie.setSens(0);
		}
		else {
			partie.setSens(1);
		}
	}

}
