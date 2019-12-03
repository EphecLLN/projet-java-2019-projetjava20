/**
 * 
 */
package controller;

import model.Partie;
import view.UnoVue;

/**
 * @author Florence
 *
 */
public class UnoController {
	
	Partie model;
	UnoVue view;
	//Console vue;
	
	public UnoController(Partie model){
		this.model = model;
	}

	public void addVue(UnoVue view){
		this.view = view;
	}

}
