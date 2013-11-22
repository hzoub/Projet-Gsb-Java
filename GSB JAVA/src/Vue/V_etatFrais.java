package Vue;
import javax.swing.*;

@SuppressWarnings("serial")
public class V_etatFrais extends JFrame{
		
	public V_etatFrais(){
		 //TITRE DE LA FENETRE
		this.setTitle("Laboratoire Galaxy-Swiss Bourdin : Gestion des Fiches visiteurs");
	    //TAILLE DE LA FENETRE
	    this.setSize(800, 600);
	    // LA FENETRE DOIT SE FERMER QUAND ON CLIQUE SUR LA CROIX ROUGE
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //CENTRE LA FENETRE
	    this.setLocationRelativeTo(null);
	    
	    this.setResizable(false);
	
	    this.setVisible(true);
	}
}
