package Vue;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/**
 * 
 * @author Aguiar Folaké
 *@version 1.0
 */

public class V_accueil extends JFrame {
	
	
	private JMenuBar menu;
	private JMenu consulter ;
	private JMenuItem FicheVisiteur;
	private JMenuItem ToutesLesFiches;
	private JMenu validation ;
	private JMenu suivi ;
	private JMenuItem deconnexion ;
	private V_ficheFrais ficheFrais;
	private Image icone ;
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

	    /**
		 * ICONE DE l'application
		 * @author Zoubert hanem
		 */
		this.icone = Toolkit.getDefaultToolkit().getImage("images/test.png");
		this.setIconImage(icone);

		//MENU BAR
		this.menu = new JMenuBar();
		
		//MENU
		this.consulter = new JMenu("Consulter");
		this.validation = new JMenu("Validation");
		this.suivi = new JMenu("Suivi");
		
		//ITEMS
		this.deconnexion = new JMenuItem("Deconnexion");
		this.FicheVisiteur = new JMenuItem("Consulter");
		this.ToutesLesFiches = new JMenuItem("Toutes Les Fiches");
		
		//AJOUT DE "JMenuBar->menu" DANS LA FENETRE
		this.setJMenuBar(menu);
	
		//AJOUT DU MENU "consulter" DANS le "JMenuBar->menu"
		this.menu.add(consulter);
		
		//AJOUT DES ITEMS DANS LE MENU "consulter"
		this.consulter.add(FicheVisiteur);
		this.consulter.add(ToutesLesFiches);
		this.consulter.add(deconnexion);
		
		//AJOUT DU MENU "validation&suivi" DANS le "JMenuBar->menu"
		this.menu.add(validation);
		this.menu.add(suivi);
		
		
		//PANEL FICHE FRAIS
		this.ficheFrais = new V_ficheFrais();
		
		/**
		 * ACTION ITEM "FicheVisiteu"
		 * Cette action permet d'ouvrir le panel "ficheFrais"
		 * @author Zoubert hanem
		 */
		this.FicheVisiteur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setContentPane(ficheFrais);
				setVisible(true);
			}
		});
		
	}

}
