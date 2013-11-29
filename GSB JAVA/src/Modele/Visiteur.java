package Modele;

public class Visiteur {

	
	String id, nom, prenom;
	
	
	public Visiteur(String id, String nom, String prenom) {
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		
	}


	public String getId() {
		return id;
	}


	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}
	
	
}
