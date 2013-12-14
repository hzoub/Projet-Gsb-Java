package Modele;

import java.util.Date;

/**
 * 
 * @author Zoubert hanem
 *
 */
public class FraisHorsForfait {

	
	private String libelle;
	private Date date;
	private float montant;
	
	public FraisHorsForfait(String libelle, Date date, float montant) {
		this.libelle = libelle;
		this.date = date;
		this.montant = montant;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the montant
	 */
	public float getMontant() {
		return montant;
	}

}
