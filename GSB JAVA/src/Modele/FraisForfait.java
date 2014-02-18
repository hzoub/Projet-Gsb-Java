package Modele;

public class FraisForfait {

	
	private String libelle;
	private int qte;
	/**
	 * 
	 * @param libelle
	 * @param qte
	 */
	public FraisForfait(String libelle, int qte) {
		this.libelle = libelle;
		this.qte = qte;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @return the qte
	 */
	public int getQte() {
		return qte;
	}
	
}
