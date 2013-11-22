package Modele;
public class Visiteur {
	
		private String id;
		private String nom;
		private String prenom;
	
		public Visiteur(String unId,String unNom, String unPrenom) {
			
			this.id = unId;
			this.nom = unNom;
			this.prenom = unPrenom;
		}
	
			/**
			 * @return l'id 
			 */
			public String getId() {
				return this.id;
			}
	
			/**
			 * @return le nom
			 */
			public String getNom() {
				return this.nom;
			}
		
			/**
			 * @return le prenom
			 */
			public String getPrenom() {
				return this.prenom;
			}	
}
