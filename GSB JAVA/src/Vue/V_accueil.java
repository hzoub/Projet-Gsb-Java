package Vue;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * 
 * @author Aguiar Folaké
 *@version 1.0
 */

public class V_accueil extends JFrame  implements ActionListener {
	
	
	private JMenuBar menu;
	private JMenu consulter ;
	private JMenuItem FicheVisiteur;
	private JMenuItem ToutesLesFiches;
	private JMenu validation ;
	private JMenu suivi ;
	private JMenu deconnexion ;


	/**
	* Constructeur..
	* */
	public V_accueil () {
		
	    //TITRE DE LA FENETRE
	    this.setTitle("");
	    //TAILLE DE LA FENETRE
	    this.setSize(800, 600);
	    // LA FENETRE DOIT SE FERMER QUAND ON CLIQUE SUR LA CROIX ROUGE
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //CENTRE LA FENETRE
	    this.setLocationRelativeTo(null);
	  
	    this.setResizable(false);
		
		menu = new JMenuBar();
		consulter = new JMenu("Consulter");
		validation = new JMenu("Validation");
		suivi = new JMenu("Suivi");
		deconnexion = new JMenu("Deconnexion");
		
		FicheVisiteur = new JMenuItem("Fiche Visiteur");
		ToutesLesFiches = new JMenuItem("Toutes Les Fiches");
		
		this.setJMenuBar(menu);
	
		this.menu.add(consulter);
		this.menu.add(FicheVisiteur);
		this.menu.add(ToutesLesFiches);
		this.menu.add(validation);
		this.menu.add(suivi);
		this.menu.add(deconnexion);
		
		
		// this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
