/**
 * 
 */
package test;

import java.util.ArrayList;

import controller.UnoController;
import model.Joueur;
import model.Partie;
import view.UnoVueConsole;
import view.UnoVueGUI;

/**
 * @author Florence
 *
 */
public class UnoMVC {
	
	private ArrayList<Joueur> listj = new ArrayList<Joueur>();
	
	public UnoMVC(){
		Partie model = new Partie(listj, null, 0, null);
				
		UnoController controlleur = new UnoController(model);
		
		UnoVueConsole vueConsole = new UnoVueConsole(model, controlleur);
		
		UnoVueGUI vueGUI = new UnoVueGUI(model, controlleur);

		controlleur.addVue(vueGUI);
		controlleur.addVue(vueConsole);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

			new UnoMVC();
		
	}

}
