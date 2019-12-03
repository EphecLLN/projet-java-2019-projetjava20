/**
 * 
 */
package test;

import controller.UnoController;
import model.Partie;
import view.UnoVueConsole;
import view.UnoVueGUI;

/**
 * @author Florence
 *
 */
public class UnoMVC {
	
	public UnoMVC(){
		Partie model = new Partie(null, null, 0, null);
		
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
