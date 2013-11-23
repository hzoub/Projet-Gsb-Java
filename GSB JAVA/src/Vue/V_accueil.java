package Vue;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/**
 * @author Aguiar Folaké
 *@version 1.0
 */
@SuppressWarnings("serial")
public class V_accueil extends JFrame {
	
	
	private JMenuBar menu;
	private JMenu consulter ;
	private JMenuItem FicheVisiteur;
	private JMenuItem ToutesLesFiches;
	private JMenuItem validation ;
	private JMenuItem suivi ;
	private JMenuItem deconnexion ;
	private V_choixVisiteur choixVis;
	private Image icone ;
	private JLabel nomVisiteur;
	private JPanel panAccueil;
	private Color bgColor;
	private V_etatFrais fiche;
	/**
	* Constructeur..
	* */
	public V_accueil () {
		
	    //TITRE DE LA FENETRE
		this.setTitle("Laboratoire Galaxy-Swiss Bourdin : Gestion des Fiches visiteurs");
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
		this.icone = Toolkit.getDefaultToolkit().getImage("images/logo.png");
		this.setIconImage(icone);
		
		this.bgColor = Color.decode("#77aadd");
		
		this.fiche = new V_etatFrais();
		this.fiche.setBackground(bgColor);
		
		this.panAccueil = new JPanel();
		this.panAccueil.setBackground(bgColor);
		
		//MENU BAR
		this.menu = new JMenuBar();
		
		//MENU
		this.consulter = new JMenu("Fiche");
		this.validation = new JMenuItem("Validation");
		this.suivi = new JMenuItem("Suivi");
		
		//ITEMS
		this.deconnexion = new JMenuItem("Deconnexion");
		this.FicheVisiteur = new JMenuItem("Consulter");
		this.ToutesLesFiches = new JMenuItem("Toutes Les Fiches");
		
		//Label visiteur
	
		this.nomVisiteur= new JLabel("<html>"+
										"<h1 style=\"font-family:Comic Sans MS\">"+
											"Visiteur : "+V_login.getJtfId().getText()+
										"</h1>",JLabel.CENTER);
		//AJOUT DE "JMenuBar->menu" DANS LA FENETRE
		this.setJMenuBar(menu);
	
		//AJOUT DU MENU "consulter" DANS le "JMenuBar->menu"
		this.menu.add(consulter);
		
		//AJOUT DES ITEMS DANS LE MENU "consulter"
		this.consulter.add(FicheVisiteur);
		this.consulter.add(ToutesLesFiches);
		this.consulter.add(validation);
		this.consulter.add(suivi);
		this.consulter.add(deconnexion);
		

		
		this.panAccueil.add(nomVisiteur);
		
		this.getContentPane().add(panAccueil);
		
		//PANEL ChoixVisiteur
		this.choixVis = new V_choixVisiteur();
		this.choixVis.getBtnValider().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setContentPane(fiche);
				setVisible(true);
			}
		});
		
		/**
		 * ACTION ITEM "FicheVisiteu"
		 * Cette action permet d'ouvrir le panel "ChoixVisiteur"
		 * @author Zoubert hanem
		 */
		this.FicheVisiteur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setContentPane(choixVis);
				setVisible(true);
			}
		});	
	}
	
}
