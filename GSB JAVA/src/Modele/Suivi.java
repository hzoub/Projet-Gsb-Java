package Modele;

import java.util.Date;
//class suivi
public class Suivi {
	
	Date date ;
	String id, nom, prenom, etat;
	int montant ;
	
public Suivi (Date date , String id , String nom , String prenom , int montant , String etat ) {
	this.date = date ;
	this.id = id ;
	this.nom = nom ;
	this.prenom = prenom ;
	this.montant = montant ;
	this.etat = etat ;
}
 public Date getDate() {
	 return date ;
 }
 
 public String getId(){
	 return id ;
 }
 
public String getNom(){
	return nom ;
}

public String getPrenom(){
	return prenom ;
}

public int getMontantValide(){
	return montant ;
}

public String getEtat(){
	return etat ;
}

}
