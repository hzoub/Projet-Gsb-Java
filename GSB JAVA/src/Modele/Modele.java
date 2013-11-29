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
			 connexion = DriverManager.getConnection("jdbc:mysql://localhost/gsb_frais", "root", "");
				
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			} catch (SQLException e) {
				System.out.println(e);
			}
		return connexion;
	 }
			
		/**
		 * Fonction qui renvoie les visiteurs
		 * @author Zoubert hanem
		 * @return lesVisiteurs
		 */
		public static  ResultSet getLesVisiteurs() {
			ResultSet lesVisiteurs = null;
			try {
				PreparedStatement st = dbconnect().prepareStatement("SELECT * FROM visiteur WHERE comptable=0 ORDER BY id");
				lesVisiteurs = st.executeQuery(); 	
			} catch (SQLException e) {
				System.out.println(e);//aaa
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
}
