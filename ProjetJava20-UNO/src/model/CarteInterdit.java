/**
 * 
 */
package model;

/**
 * @author Florence Salpietro & Amélie Courtin
 *
 */
public class CarteInterdit extends CarteAction{

	public CarteInterdit(String categorie, String couleur, int valeur, String codeString) {
		super(categorie, couleur, valeur, codeString);
		// TODO Auto-generated constructor stub
	}
	
	public void Action(Partie partie, String couleur){
		partie.setJoueurEnCours(partie.getJoueurSuivant());
		
	}

}
