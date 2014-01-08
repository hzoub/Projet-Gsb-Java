package Modele;
/**
 * 
 * @author Zoubert hanem
 *
 */
public class Etat {
	String id;
	String libelle;
	
	public Etat(String id,String unLibelle) {
		
		this.id = id;
		this.libelle = unLibelle;
		
	}

	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	public String getlibelle() {
		return libelle;
	}	
	
}
