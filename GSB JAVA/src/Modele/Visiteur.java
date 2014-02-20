package Modele;
/**
 * Modele <b>visiteur</b> qui renvoie <b>l'id , le nom et le prenom du visiteur.</b>
 * @author Brandon Fraizy
 */
public class Visiteur {

	
	String id, nom, prenom;
	
	/**
	 * Constructeur 
	 * @param id
	 * @param nom
	 * @param prenom
	 */
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
