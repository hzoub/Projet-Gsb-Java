package Vue;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class V_GsbFrame extends JFrame {
		private V_login login;
		
	public V_GsbFrame(){
	        //TITRE DE LA FENETRE
	        this.setTitle("");
	        //TAILLE DE LA FENETRE
	        this.setSize(800, 600);
	        // LA FENETRE DOIT SE FERMER QUAND ON CLIQUE SUR LA CROIX ROUGE
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //CENTRE LA FENETRE
	        this.setLocationRelativeTo(null);
	        this.setResizable(false);
	        
	        this.login = new V_login();
	        
	        //AJOUT DU PANEL LOGIN DANS LA FENETRE
	        this.getContentPane().add(this.login);
	        
	        this.setVisible(true);
	}
}
