package Modele;
/**
 * Modele <b>visiteur</b> qui renvoie <b>l'id , le nom et le prenom du visiteur.</b>
 * @author Brandon Fraizy
 */
public class Visiteur {

	
	String id, nom, prenom,mois;
	
	/**
	 * Constructeur 
	 * @param id
	 * @param nom
	 * @param prenom
	 */
	public Visiteur(String id, String nom, String prenom,String mois) {
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mois = mois;
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


	/**
	 * @return the mois
	 */
	public String getMois() {
		return mois;
	}
	
	
}
