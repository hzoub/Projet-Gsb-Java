package Modele;
import java.sql.*;
public class Modele {
		
	/**
	 * Fonction qui permet la connexion à la base de données
	 * @return connexion
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
	 * Fonction qui renvoie les contacts
	 * @return rs
	 */
	public static  ResultSet getFicheFrais() {
		ResultSet rs = null;
		try {
			 
			PreparedStatement st = dbconnect().prepareStatement("SELECT * FROM contact ORDER BY numero");
			rs = st.executeQuery(); 
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	
		return rs ;
	}
	
}
