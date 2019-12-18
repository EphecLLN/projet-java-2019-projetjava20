package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import controller.UnoController;
import model.Partie;

public class UnoVueGUI extends UnoVue implements Observer{
	
	private JLabel message = new JLabel(" ");

	public UnoVueGUI(Partie model, UnoController controller) {
		super(model, controller);
	}

	@Override
	public void update(Observable o, Object arg) {
			//System.out.println("GUI");		
	}

	@Override
	public void affiche(String msg) {
		// TODO Auto-generated method stub
		message.setText(msg);
	}

}
