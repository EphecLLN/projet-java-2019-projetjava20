package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PartieTest {
	
	Joueur j1 = new Joueur ("Amelie", null, 0);
	Joueur j2 = new Joueur ("Danielle", null, 0);
	

	@Test
	public void testDeterminerSens() {
		;
	}

	@Test
	public void testDeterminerJoueur() {
		assertEqual(j1,j2);
		fail("");
		
	}

	private void assertEqual(Joueur j12, Joueur j22) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testCalculerScore() {
		fail("");
	}

}
