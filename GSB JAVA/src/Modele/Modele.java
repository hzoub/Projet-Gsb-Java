package Modele;
import java.sql.*;
import java.util.ArrayList;
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
		 * @author Zoubert hanem
		 *  Fonction qui renvoie tout les visiteur médicale
		 * Passerelle d'arraylist contact qui permet d'insert un contact
		 * @return lesVisiteurs
		 */
		
		public static ArrayList<Visiteur> getLesVisiteur(){
			
			ArrayList <Visiteur> lesVisiteurs = new ArrayList <Visiteur>();
			
			try {
				PreparedStatement st = dbconnect().prepareStatement("SELECT * FROM visiteur WHERE comptable=0 ORDER BY id");
				ResultSet rs = st.executeQuery(); 
				while (rs.next()) {
					
					String id= rs.getString("id");
					String nom = rs.getString("nom");
					String prenom = rs.getString("prenom");
				
					lesVisiteurs.add(new Visiteur(id,nom,prenom));
				}
			
			}
			    
		    catch (SQLException e) {
				System.out.println(e);
			}
			return lesVisiteurs;
		}
}
