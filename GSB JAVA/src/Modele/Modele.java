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
}
