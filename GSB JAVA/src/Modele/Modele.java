package Modele;
import java.sql.*;
public class Modele {
		
	/**
	 * Fonction qui permet la connexion � la base de donn�es
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
	
	
}
