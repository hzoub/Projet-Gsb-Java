package Modele;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		 * 
		 * @author Zoubert hanem
		 * @param idVisiteur
		 * @return leVisiteur
		 */
		public static  ArrayList<Visiteur> getLeVisiteur(String idVisiteur) {
			//Collection les visiteurs
			ArrayList<Visiteur>leVisiteur = new ArrayList<Visiteur>();
			try {
				PreparedStatement st = dbconnect().prepareStatement("SELECT id, nom, prenom FROM visiteur WHERE comptable=0 +"+
						 											"AND id='"+idVisiteur+"'"+
						 											"ORDER BY id");
				ResultSet rs = st.executeQuery(); 
				
				while(rs.next()){
					
					String id = rs.getString("id");
					String nom = rs.getString("nom");
					String prenom = rs.getString("prenom");
					leVisiteur.add(new Visiteur(id, nom, prenom));	
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
			return leVisiteur ;
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
			try {
				
				PreparedStatement st = dbconnect().prepareStatement("SELECT distinct mois FROM fichefrais WHERE idVisiteur='"+idVisiteur+"'");
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
		 * Retourne toutes les lignes de frais au forfait d'un visiteur
		 * @author Zoubert hanem
		 * @param idVisiteur
		 * @param mois
		 * @return fraisForfait
		 * 
		 */
		public static  ArrayList<FraisForfait> getFraisForfaitVisiteur(String idVisiteur, int mois) {
			
			ArrayList<FraisForfait> fraisForfait= new ArrayList<FraisForfait>();
			
			try {
				PreparedStatement st = dbconnect().prepareStatement("SELECT quantite"+
						                                             "FROM fraisforfait,lignefraisforfait"+
																	 "WHERE fraisforfait.id = lignefraisforfait.idFraisForfait "+
						                                             "AND idVisiteur = '"+idVisiteur+"' AND mois = '"+mois+"' ");
				ResultSet	rs = st.executeQuery(); 	
				
				while(rs.next()){
					int qte = rs.getInt("quantite");
					fraisForfait.add(new FraisForfait(qte));
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
