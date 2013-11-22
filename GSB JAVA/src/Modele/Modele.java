package Modele;
import java.sql.*;
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
			 connexion = DriverManager.getConnection("jdbc:mysql://localhost/mvc", "root", "");
				
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			} catch (SQLException e) {
				System.out.println(e);
			}
		return connexion;
	 }
	
		/**
		 * Retourne les mois pour lesquel un visiteur a une fiche de frais
		 * @return un  ResultSet
		 * @author Zoubert hanem
		 * */
		
		public static  ResultSet getLesMoisDisponibles() {
			ResultSet rs = null;
			try {
				 
				PreparedStatement st = dbconnect().prepareStatement("SELECT fichefrais.mois AS mois "
																	+"FROM  fichefrais "
																	+ "ORDER BY fichefrais.mois desc");
				rs = st.executeQuery(); 
				
			} catch (SQLException e) {
				System.out.println(e);
			}
			return rs ;
		}
		
		/**
		 * Fonction qui renvoie tout les visiteur médicale
		 * @return rs
		 * @author Zoubert hanem
		 */
		public static  ResultSet getContact() {
			ResultSet rs = null;
			try {
				PreparedStatement st = dbconnect().prepareStatement("SELECT * FROM visiteur WHERE comptable=0 ORDER BY id");
				rs = st.executeQuery(); 	
			} catch (SQLException e) {
				System.out.println(e);
			}
			return rs ;
		}
}
