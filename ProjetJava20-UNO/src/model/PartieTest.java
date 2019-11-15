import static org.junit.Assert.*;

import org.junit.Test;

public class PartieTest {
	
	Joueur j1 = new Joueur ("Amelie");
	Joueur j2 = new Joueur ("Danielle");
	

	@Test
	public void testDeterminerSens() {
		;
	}

	@Test
	public void testDeterminerJoueur() {
		assertEqual(j1,j2);
		fail("");
		
	}

	@Test
	public void testCalculerScore() {
		fail("");
	}

}
