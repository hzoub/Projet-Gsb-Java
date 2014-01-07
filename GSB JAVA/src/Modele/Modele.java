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

import Vue.V_login;
public class Modele {
		
	/**
	 * Fonction qui permet la connexion à la base de données
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
			} catch (SQLException e) {
				System.out.println(e);
			}
		return connexion;
	 }
	
	/**
	 * Connexion membre
	 * @author Fraizy Brandon
	 */
	
	public static boolean Connexion(String login, String mdp) {
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
		 * Fonction qui renvoie un ArrayList de type Visiteur
		 * Permet d'ajouter le résultat de la requête dans la collection <Visiteur>
		 * @author Zoubert hanem
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
		 * Fonction retournant les dates des visiteurs 
		 * @author bfraizy
		 * lesMois
		 * return les mois
		 */
		public static  ArrayList<Mois> getLesMois(String idVisiteur) {
			//Collection les visiteurs
			ArrayList<Mois> lesMoisVisiteur = new ArrayList<Mois>();
			String date = new SimpleDateFormat("yyyyMM", Locale.FRANCE).format(new Date());
			String moisEncour = date.toString(); 
			try {
				
				PreparedStatement st = dbconnect().prepareStatement("SELECT mois FROM fichefrais WHERE idVisiteur='"+idVisiteur+"' AND mois='"+moisEncour+"' ORDER BY mois DESC");
				ResultSet rs = st.executeQuery(); 
				
				while(rs.next()){
					
					int mois = rs.getInt("mois");
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
		 * Fonction qui renvoie les etats
		 * @author Zoubert hanem
		 * @return lesEtats
		 * 
		 */
		public static  ArrayList<Etat> getLesEtats() {
			
		ArrayList<Etat> lesEtats = new ArrayList<Etat>();
			
			try {
				PreparedStatement st = dbconnect().prepareStatement("SELECT libelle FROM etat");
				ResultSet rs = st.executeQuery(); 	
				while(rs.next()){
				
				String libelle = rs.getString("libelle");
				lesEtats.add(new Etat(libelle));
				
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
		 * Fonction qui renvoie l'etat actuel de la fiche du visiteur séléctionné
		 * @author Zoubert hanem
		 * @return lesEtats
		 * 
		 */
		public static  ArrayList<Etat> getEtatActuel(String idVisiteur,Object mois) {
			
		ArrayList<Etat> lesEtats = new ArrayList<Etat>();
			
			try {
				PreparedStatement st = dbconnect().prepareStatement("SELECT libelle FROM etat, fichefrais WHERE etat.id=fichefrais.idEtat AND idVisiteur ='"+idVisiteur+"' AND mois ='"+mois+"'");
				ResultSet rs = st.executeQuery(); 	
				while(rs.next()){
				
				String libelle = rs.getString("libelle");
				lesEtats.add(new Etat(libelle));
				
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
		 * @param mois sous la forme aaaamm
		 * @return fraisForfait
		 * @author Zoubert Hanem
		 */
		public static  ArrayList<FraisForfait> getLesFraisForfait(String idVisiteur, Object mois) {
			
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
		public static  ArrayList<FraisHorsForfait> getLesFraisHorsForfait(String idVisiteur, Object mois) {
			
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
}
