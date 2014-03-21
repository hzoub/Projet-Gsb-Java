package TestUnitaire;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Modele.Modele;
import Modele.Visiteur;

public class TestGsbApp {
	Modele modele;
	String id;
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testConnexion() {
		
		String login = "hzoubert";
		String mdp ="1234";		
		boolean result = true;
		
		assertEquals("Erreur de connexion",result,Modele.connexion(login, mdp));
	}

	@Test
	public void testGetIdVisiteur() {
		
		for(int i=0; i<Modele.getIdVisiteur("Zoubert").size(); i++){
			
			Visiteur visiteur = Modele.getIdVisiteur("Zoubert").get(i);
			id = visiteur.getId();
		}
		//On verifie si l'id a21 est correct
		assertEquals("L'Id du visiteur est invalide","a21",id);
	}

	@Test
	public void testValiderFicheFrais() {
		//fail("Not yet implemented");
	}

}
