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

	
	public CartePlus(String categorie, String couleur, int valeur, String codeString, int nbPlus){
		super(categorie, couleur, valeur, codeString);
		this.nbPlus = nbPlus;
	}

	
	public void Action(Partie partie, String couleur){
		if(nbPlus==2) ActionPlus2(partie, couleur);
		else ActionPlus4(partie,couleur);
		
	}
	
	
	public void ActionPlus2(Partie partie, String couleur){
		int i=1;
		while(i<3){
			partie.getPioche().retirer(partie.getJoueurSuivant());
			i++;
		}
		System.out.println("Pioche p2");
	}
	
	public void ActionPlus4(Partie partie, String couleur){
		int i=1;
		while(i<5){
			partie.getPioche().retirer(partie.getJoueurSuivant());
			i++;
		}
		switch (couleur){
		case "V": 
			this.setCouleur("vert");
			System.out.println(this.getCouleur());
			break;
		case "B":
			this.setCouleur("bleu");
			break;
		case "R":
			this.setCouleur("rouge");
			break;
		case "J":
			this.setCouleur("jaune");
			break;
		default : 
			System.out.println("La couleur n'est pas au bon format");
		}
	}


	/**
	 * @return the nbPlus
	 */
	public int getNbPlus() {
		return nbPlus;
	}


	/**
	 * @param nbPlus the nbPlus to set
	 */
	public void setNbPlus(int nbPlus) {
		this.nbPlus = nbPlus;
	}
	
	
		
}
