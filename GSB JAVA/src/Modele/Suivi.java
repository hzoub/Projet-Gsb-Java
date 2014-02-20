package Modele;
//class suivi
public class Suivi extends Visiteur {
	
	String date ;
	String etat;
	float montant ;
	
	public Suivi (String id , String nom , String prenom ,String date ,  float montant , String etat ) {
		super(id,nom,prenom);
		this.date = date ;
		this.montant = montant ;
		this.etat = etat ;
	}
	 public String getDate() {
		 return date ;
	 }
	 
	public float getMontantValide(){
		return montant ;
	}
	
	public String getEtat(){
		return etat ;
	}

}