/**
 * 
 */
package model;

/**
 * @author Florence Salpietro & Amélie Courtin
 *
 */
public class CarteInversion extends CarteAction {

	
	public CarteInversion(String categorie, String couleur, int valeur, String codeString) {
		super(categorie, couleur, valeur, codeString);
		// TODO Auto-generated constructor stub
	}

	
	public void Action(Partie partie){
		if (partie.getSens() == 1){
			partie.setSens(0);
		}
		else {
			partie.setSens(1);
		}
	}

}
