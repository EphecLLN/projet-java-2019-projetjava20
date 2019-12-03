package view;

import java.util.Observer;

import controller.UnoController;
import model.Partie;

public abstract class UnoVue implements Observer {

	protected Partie model;
	protected UnoController controller;
	
	UnoVue(Partie model, UnoController controller){
		this.model = model;
		this.controller= controller;
		model.addObserver(this);
	}
}
