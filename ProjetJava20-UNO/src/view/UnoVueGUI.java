package view;

import java.util.Observable;
import java.util.Observer;

import controller.UnoController;
import model.Partie;

public class UnoVueGUI extends UnoVue implements Observer{

	UnoVueGUI(Partie model, UnoController controller) {
		super(model, controller);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
