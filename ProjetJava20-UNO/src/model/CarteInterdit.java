/**
 * 
 */
package model;

/**
 * @author Florence Salpietro & Amélie Courtin
 *
 */
public class CarteInterdit extends CarteAction{

	/**
	 * Constructeur de CarteInterdit
	 * @param categorie
	 * @param couleur
	 * @param valeur
	 * @param codeString
	 */
	public CarteInterdit(String categorie, String couleur, int valeur, String codeString) {
		super(categorie, couleur, valeur, codeString);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * Methode permettant d'executer l'action d'une carte Interdit, c'est à dire interdire au joueur suivant de jouer
	 */
	public void Action(Partie partie, String couleur){
		System.out.println(partie.getJoueurSuivant());
		partie.setJoueurEnCours(partie.getJoueurSuivant());
		System.out.println("ACTION interdit");
		
	}

}
