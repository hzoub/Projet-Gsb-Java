package Modele;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;

import Vue.V_login;
/**
 * Contient toute les fonctions qui vont chercher les informations dans la base de
 * données
 */
public class Modele {
		
	/**
	 * Permet la connexion à la base de données
	 * @return connexion
	 * @author Zoubert hanem
	 */
	public static Connection dbconnect(){
		Connection connexion = null;
		try {
			 Class.forName("com.mysql.jdbc.Driver") ;
			 connexion = DriverManager.getConnection("jdbc:mysql://localhost/gsb_frais", "root", "");
				
			} catch (ClassNotFoundException e) {
				System.out.println(e);
				System.out.println("class");
			} catch (SQLException e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null,
						"Impossible de se connecter au serveur\n"
						+"Veuillez verifier si easyPhp ou wampServer fonctionne correctement",
						"Erreur",JOptionPane.ERROR_MESSAGE);
			}
		return connexion;
	 }
	
	/**
	 * Connexion membre
	 * @author Fraizy Brandon
	 */
	
	public static boolean connexion(String login, String mdp) {
		//Connexion
	
		String mdp_2 = null;
		
		boolean result = false;
		
		try {
			PreparedStatement st = dbconnect().prepareStatement("SELECT login, mdp FROM visiteur WHERE comptable=1");
			ResultSet rs = st.executeQuery(); 
			
			rs.next();
				
				login = rs.getString(1);
				mdp_2 = rs.getString(2);
				
				if (mdp_2.equals(mdp)){
					
				result=true;
			}
			
		}
				catch (SQLException e) {
					System.out.println(e);
				}
				
				finally{
					
					  try{
						   //fermeture de la connexion
						   dbconnect().close();
					  }
					 
					  catch(Exception e){
						   e.printStackTrace();
					  }
				}
		return result;
		}
	
		/**
		 * Renvoie un ArrayList de type Visiteur
		 * Permet d'ajouter le résultat de la requête dans la collection <Visiteur>
		 * @author Fraizy Brandon
		 * @return lesVisiteurs
		 * 
		 */
		public static  ArrayList<Visiteur> getLesVisiteurs() {
			//Collection les visiteurs
			ArrayList<Visiteur>lesVisiteurs = new ArrayList<Visiteur>();
			
			try {
				PreparedStatement st = dbconnect().prepareStatement("SELECT id, nom, prenom FROM visiteur WHERE comptable=0 ORDER BY id");
				ResultSet rs = st.executeQuery(); 
				while(rs.next()){
					String id = rs.getString("id");
					String nom = rs.getString("nom");
					String prenom = rs.getString("prenom");
					lesVisiteurs.add(new Visiteur(id, nom, prenom));	
				}
			} 
			catch (SQLException e) {
				System.out.println(e);
			}
			finally{
				
				   try{
					   //fermeture de la connexion
					   dbconnect().close();
				   }
				   catch(Exception e){
					   e.printStackTrace();
				   }
				 }
			return lesVisiteurs ;
		}
		
		/**
		 * Renvoie l'id , le nom , le prenom des visiteurs ayant une fiche créée, saisie en cours.<br>
		 * Permet d'ajouter le résultat de la requête dans la collection <b>Visiteur.</b>
		 * @author Zoubert hanem
		 * @return lesVisiteurs
		 */
		public static  ArrayList<Visiteur> getVisiteursFiche() {
			//Collection les visiteurs
			ArrayList<Visiteur>lesVisiteurs = new ArrayList<Visiteur>();
			
			try {
				PreparedStatement st = dbconnect().prepareStatement("SELECT distinct id, nom, prenom FROM visiteur,fichefrais WHERE visiteur.id = fichefrais.idVisiteur AND comptable=0 AND idEtat='CR' ORDER BY id");
				ResultSet rs = st.executeQuery(); 
				while(rs.next()){
					String id = rs.getString("id");
					String nom = rs.getString("nom");
					String prenom = rs.getString("prenom");
					lesVisiteurs.add(new Visiteur(id, nom, prenom));	
				}
			} 
			catch (SQLException e) {
				System.out.println(e);
			}
			finally{
				
				   try{
					   //fermeture de la connexion
					   dbconnect().close();
				   }
				   catch(Exception e){
					   e.printStackTrace();
				   }
				 }
			return lesVisiteurs ;
		}
		
		/**
		 * Renvoie <b>l'id, le nom, le prenom et le mois</b> des visiteurs ayant une fiche validées et mise en paiement<br>
		 * Ajoute le résultat de la requête dans la collection <b>Visiteur</b>
		 * @author ...
		 * @return lesVisiteurs
		 */
		public static  ArrayList<Visiteur> getVisiteurSuiviPaiement() {
			//Collection les visiteurs
			ArrayList<Visiteur>lesVisiteurs = new ArrayList<Visiteur>();
			
			try {
				PreparedStatement st = dbconnect().prepareStatement("SELECT distinct id, nom, prenom,mois FROM visiteur,fichefrais WHERE visiteur.id = fichefrais.idVisiteur AND comptable=0 AND idEtat='VA' ORDER BY id");
				ResultSet rs = st.executeQuery(); 
				while(rs.next()){
					String id = rs.getString("id");
					String nom = rs.getString("nom");
					String prenom = rs.getString("prenom");
					lesVisiteurs.add(new Visiteur(id, nom, prenom));	
				}
			} 
			catch (SQLException e) {
				System.out.println(e);
			}
			finally{
				
				   try{
					   //fermeture de la connexion
					   dbconnect().close();
				   }
				   catch(Exception e){
					   e.printStackTrace();
				   }
				 }
			return lesVisiteurs ;
		}
		
		/**
		 * @author hzoubert
		 */
		public static  ArrayList<Visiteur> getIdVisiteur(String nom) {
			//Collection les visiteurs
			ArrayList<Visiteur>lesVisiteurs = new ArrayList<Visiteur>();
			
			try {
				PreparedStatement st = dbconnect().prepareStatement("SELECT id FROM visiteur WHERE nom='"+nom+"'");
				ResultSet rs = st.executeQuery(); 
				while(rs.next()){
					String id = rs.getString("id");
					lesVisiteurs.add(new Visiteur(id, null, null));	
				}
			} 
			catch (SQLException e) {
				System.out.println(e);
			}
			finally{
				
				   try{
					   //fermeture de la connexion
					   dbconnect().close();
				   }
				   catch(Exception e){
					   e.printStackTrace();
				   }
				 }
			return lesVisiteurs ;
		}		
		
		/**
		 *Renvoie le mois de la fiche des visiteurs ayant une fiche créée, saisie en cours "CR". 
		 *@author Fraizy Brandon
		 *return lesMoisVisiteur
		 */
		public static  ArrayList<Mois> getLesMois(String idVisiteur) {
			String moisEnCour = new SimpleDateFormat("yMM", Locale.FRANCE).format(new Date());
			//Collection les visiteurs
			ArrayList<Mois> lesMoisVisiteur = new ArrayList<Mois>();
			try {
				
				PreparedStatement st = dbconnect().prepareStatement("SELECT mois FROM fichefrais WHERE idVisiteur='"+idVisiteur+"' AND idEtat='CR' AND mois='"+moisEnCour+"' ");
				ResultSet rs = st.executeQuery(); 
				
				while(rs.next()){
					
					String mois = rs.getString("mois");
					lesMoisVisiteur.add(new Mois(mois));
					
					
				}
			} 
			catch (SQLException e) {
				System.out.println(e);
			}
			finally{	
				   try{
					   //fermeture de la connexion
					   dbconnect().close();
				   }
				   catch(Exception e){
					   e.printStackTrace();
				   }
				 }
			return lesMoisVisiteur ;
		}	
		
		
		/**
		 *Renvoie le libellé de tout les etats
		 *@author Zoubert hanem
		 *@return lesLibs
		 */
		public static  ArrayList<Etat> getEtatVa() {
			
		ArrayList<Etat> lesLibs = new ArrayList<Etat>();
			
			try {
				PreparedStatement st = dbconnect().prepareStatement("SELECT libelle FROM etat where id='VA'");
				ResultSet rs = st.executeQuery(); 	
				while(rs.next()){
				
				String libelle = rs.getString("libelle");
				lesLibs.add(new Etat("",libelle));
				
				}
			} 
			catch (SQLException e) {
				System.out.println(e);
			}
			finally{
				   try{
					   //fermeture de la connexion
					   dbconnect().close();
				   }
				   catch(Exception e){
					   e.printStackTrace();
				   }
				 }
			return lesLibs;
		}
		
		/**
		 *Renvoie l'etat actuel de la fiche du visiteur séléctionné
		 *@author Zoubert hanem
		 *@return lesEtats
		 */
		public static  ArrayList<Etat> getEtatActuel(String idVisiteur,String mois) {
			
		ArrayList<Etat> lesEtats = new ArrayList<Etat>();
			
			try {
				PreparedStatement st = dbconnect().prepareStatement("SELECT libelle FROM etat, fichefrais WHERE etat.id=fichefrais.idEtat AND idVisiteur ='"+idVisiteur+"' AND mois ='"+mois+"'");
				ResultSet rs = st.executeQuery(); 	
				while(rs.next()){
				
				String libelle = rs.getString("libelle");
				lesEtats.add(new Etat(null,libelle));
				
				}
			} 
			catch (SQLException e) {
				System.out.println(e);
			}
			finally{
				   try{
					   //fermeture de la connexion
					   dbconnect().close();
				   }
				   catch(Exception e){
					   e.printStackTrace();
				   }
				 }
			return lesEtats ;
		}
		
		/**
		 * Retourne toutes la lignefraisforfait d'un visiteur
		 * @author Zoubert hanem
		 * @param idVisiteur
		 * @param mois - sous la forme aaaamm
		 * @return fraisForfait
		 * @author Zoubert Hanem
		 */
		public static  ArrayList<FraisForfait> getLesFraisForfait(String idVisiteur, String mois) {
			
			ArrayList<FraisForfait> fraisForfait = new ArrayList<FraisForfait>();
			
			try {
				PreparedStatement st = dbconnect().prepareStatement("SELECT libelle,quantite FROM lignefraisforfait,fraisforfait WHERE idVisiteur ='"+idVisiteur+"' AND mois ='"+mois+"' AND fraisforfait.id = lignefraisforfait.idFraisForfait ORDER BY idFraisForfait");
				ResultSet	rs = st.executeQuery(); 	
				
				while(rs.next()){
					
					String lib = rs.getString("libelle");
					int qte = rs.getInt("quantite");
					fraisForfait.add(new FraisForfait(lib, qte));
				}
				
			} 
			catch (SQLException e) {
				System.out.println(e);
			}
			finally{
				   try{
					   //fermeture de la connexion
					   dbconnect().close();
				   }
				   catch(Exception e){
					   e.printStackTrace();
				   }
				 }
			return fraisForfait ;
		}
		
		/**
		 * Retourne toutes toutes les lignes de frais hors forfait
		 * @author Zoubert hanem
		 * @param idVisiteur
		 * @param mois sous la forme aaaamm
		 * @return fraisForfait
		 * @author Zoubert Hanem
		 */
		public static  ArrayList<FraisHorsForfait> getLesFraisHorsForfait(String idVisiteur, String mois) {
			
			ArrayList<FraisHorsForfait> fraisHorsForfait = new ArrayList<FraisHorsForfait>();
			
			try {
				PreparedStatement st = dbconnect().prepareStatement("SELECT libelle,date,montant FROM lignefraishorsforfait  WHERE lignefraishorsforfait.idvisiteur ='"+idVisiteur+"'  AND lignefraishorsforfait.mois = '"+mois+"'");
				ResultSet rs = st.executeQuery(); 	
				
				while(rs.next()){
					
					String lib = rs.getString("libelle");
					Date date = rs.getDate("date");
					float montant = rs.getFloat("montant");
					
					fraisHorsForfait.add(new FraisHorsForfait(lib,date, montant));
				}
				
			} 
			catch (SQLException e) {
				System.out.println(e);
			}
			finally{
				   try{
					   //fermeture de la connexion
					   dbconnect().close();
				   }
				   catch(Exception e){
					   e.printStackTrace();
				   }
				 }
			return fraisHorsForfait ;
		}
		/**
		 * @author Fraizy Brandon
		 * @return le nom et le prenom du comptable
		 */
		public static  ArrayList<Visiteur> getNomPrenomC(){
			
			 ArrayList<Visiteur> NomPrenom =  new ArrayList<Visiteur>();
			
			try {
				PreparedStatement st = dbconnect().prepareStatement("SELECT  nom, prenom FROM visiteur WHERE login ='"+V_login.getJtfId().getText()+"';");
				ResultSet rs = st.executeQuery(); 
				while(rs.next()){	
					
					String nomC = rs.getString("nom");
					String prenomC = rs.getString("prenom");
					NomPrenom.add(new Visiteur(null, nomC, prenomC));
				}
			} 
			
			catch (SQLException e) {
				System.out.println(e);
			}
			finally{
				
				   try{
					   //fermeture de la connexion
					   dbconnect().close();
				   }
				   catch(Exception e){
					   e.printStackTrace();
				   }
				 }	
			return NomPrenom;
		}
		
		/**
		 * @author Zoubert Hanem
		 * @param idEtat
		 */
		public static  int validerFicheFrais(String idEtat,String mois,String idVis,float montant,int nbJustificatifs) {	
			int nbLignes = 0;
			try {
				PreparedStatement st = dbconnect().prepareStatement("UPDATE fichefrais SET idEtat='"+idEtat+"', montantValide='"+montant+"' , nbJustificatifs='"+nbJustificatifs+"' WHERE mois='"+mois+"' AND idVisiteur='"+idVis+"'");
					
				nbLignes = st.executeUpdate();
			} 
			catch (SQLException e) {
				System.out.println(e);
			}
			finally{
				   try{
					   //fermeture de la connexion
					   dbconnect().close();
				   }
				   catch(Exception e){
					   e.printStackTrace();
				   }
				 }
			return nbLignes;
		}
		
		/**
		 * @author Zoubert Hanem
		 * @param idEtat
		 */
		/*public static  int updateLigneFraisForfait(int qte,String id,String mois) {	
			int nbLignes = 0;
			try {
				PreparedStatement st = dbconnect().prepareStatement("UPDATE lignefraisforfait SET  WHERE idVisiteur='"+id+"' mois='"+mois+"' ");
					
				nbLignes = st.executeUpdate();
			} 
			catch (SQLException e) {
				System.out.println(e);
			}
			finally{
				   try{
					   //fermeture de la connexion
					   dbconnect().close();
				   }
				   catch(Exception e){
					   e.printStackTrace();
				   }
				 }
			return nbLignes;
		}*/
		
		/**
		 * @param lib
		 * @return idEtat
		 */
		public static  ArrayList<Etat>  getIdEtat(String lib) {	
			ArrayList<Etat> idEtat = new ArrayList<Etat>();
			try {
				PreparedStatement st = dbconnect().prepareStatement("SELECT id FROM etat WHERE libelle='"+lib+"'");
				ResultSet rs = st.executeQuery(); 
				
				while(rs.next()){
					
					String id = rs.getString("id");
					idEtat.add(new Etat(id,""));
				}
			} 
			catch (SQLException e) {
				System.out.println(e);
			}
			finally{
				   try{
					   //fermeture de la connexion
					   dbconnect().close();
				   }
				   catch(Exception e){
					   e.printStackTrace();
				   }
				 }
			return idEtat;
		}
		
		
		/**
		 *
		 * @author Brandon Fraizy
		 * @return lesVisiteurs
		 */
		public static  ArrayList<Visiteur> getFicheValidees(){
			
			ArrayList<Visiteur>lesVisiteurs = new ArrayList<Visiteur>();
			
			try {
				PreparedStatement st = dbconnect().prepareStatement("SELECT nom, prenom FROM etat, visiteur, fichefrais WHERE visiteur.id=fichefrais.idVisiteur AND fichefrais.idEtat=etat.id AND etat.id='VA'");
				ResultSet rs = st.executeQuery(); 
				
				while(rs.next()){
					String nom = rs.getString("nom");
					String prenom = rs.getString("prenom");
					lesVisiteurs.add(new Visiteur(null,nom, prenom));	
				}
			} 
			catch (SQLException e) {
				System.out.println(e);
			}
			finally{
				   try{
					   //fermeture de la connexion
					   dbconnect().close();
				   }
				   catch(Exception e){
					   e.printStackTrace();
				   }
				   
				 }
			
			
			return lesVisiteurs;
			
		}
	
		/**
		 * Renvoie l'id , le nom , le prenom,le mois,le montant validé et l'idEtat 
		 * des visiteurs ayant une fiche "VA".<br>
		 * Ajoute le résultat de la requête dans la collection <b>Suivi.</b>
		 * @author Folaké AGUIAR
		 * @return lesSuivis
		 */
		public static  ArrayList<Suivi> getSuivi() {
			//Collection les visiteurs
			ArrayList<Suivi>lesSuivis = new ArrayList<Suivi>();
			
			try {
				PreparedStatement st = dbconnect().prepareStatement("SELECT mois,idVisiteur,nom,prenom,montantValide,idEtat"
						+ " FROM fichefrais , visiteur  WHERE visiteur.id = fichefrais.idVisiteur AND idEtat='VA' ");
				ResultSet rs = st.executeQuery(); 
				while(rs.next()){
					String date = rs.getString("mois");
					String id = rs.getString("idVisiteur");
					String nom = rs.getString("nom");
					String prenom = rs.getString("prenom");
					int montant = rs.getInt("montantValide");
					String etat = rs.getString("idEtat");
					lesSuivis.add(new Suivi(id, nom, prenom,date,montant,etat));	
				}
			} 
			catch (SQLException e) {
				System.out.println(e);
			}
			finally{
				
				   try{
					   //fermeture de la connexion
					   dbconnect().close();
				   }
				   catch(Exception e){
					   e.printStackTrace();
				   }
				 }
			return lesSuivis ;
		}
}
