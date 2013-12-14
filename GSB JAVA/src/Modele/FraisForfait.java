package Modele;

public class FraisForfait {

	private int forfaitEtape;
	private int fraisKlm;
	private int NHotel;
	private int RepResto;
	
	public FraisForfait(int forfaitEtape, int fraisKlm, int nHotel, int repResto) {
		
		this.forfaitEtape = forfaitEtape;
		this.fraisKlm = fraisKlm;
		this.NHotel = nHotel;
		this.RepResto = repResto;
	}
	
	
	/**
	 * @return the forfaitEtape
	 */
	public int getForfaitEtape() {
		return forfaitEtape;
	}
	/**
	 * @return the fraisKlm
	 */
	public int getFraisKlm() {
		return fraisKlm;
	}
	/**
	 * @return the nHotel
	 */
	public int getNHotel() {
		return NHotel;
	}
	/**
	 * @return the repResto
	 */
	public int getRepResto() {
		return RepResto;
	}
	
	
	
}
