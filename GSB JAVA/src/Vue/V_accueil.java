package Vue;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Modele.Modele;
import Modele.Visiteur;
/**
 * Accueil de l'application affiche la vue <b>V_afficherVisiteur</b>
 *@author Aguiar Folaké
 *@version 1.0
 */
@SuppressWarnings("serial")
public class V_accueil extends JFrame {
		
	private JMenuBar menu;
	private JMenu fiche ;
	private JMenuItem consulter;
	private JMenuItem listeDesVisiteur;
	
	private JMenuItem suivi ;
	private JMenuItem valider ;
	private JMenuItem deconnexion ;
	private Color bgColor;
	private String nom,prenom;

	//PANELS
	private JPanel panAccueil;
	
	private V_choixVisiteur choixVis;
	private V_etatFrais ficheFrais;
	private V_afficherVisiteur listeVisiteurs;
	private V_choixSuivi choixSuivi;
	private V_ficheValidee v_validee;
	/**
	* Constructeur..
	* */
	public V_accueil () {
		
	    /*
	     * TITRE DE LA FENETRE
	     */
		this.setTitle("Laboratoire Galaxy-Swiss Bourdin : Gestion des Fiches visiteurs");
	    /*
	     * TAILLE DE LA FENETRE
	     */
	    this.setSize(800, 600);
	    /*
	     *  LA FENETRE DOIT SE FERMER QUAND ON CLIQUE SUR LA CROIX ROUGE
	     */
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    /*
	     * CENTRE LA FENETRE
	     */
	    this.setLocationRelativeTo(null);
	   /*
	    * Empêche le redimensionement de la fenêtre
	    */
	    this.setResizable(false);

	    
	    /**
		 * ICONE DE l'application
		 * @author Zoubert hanem
		 */
	    this.setIconImage(new ImageIcon(getClass().getResource("/logo.png")).getImage());
		
		/*
		 * Couleur arriere-plan de la fenetre
		 */
		this.bgColor = Color.decode("#77aadd");
		
		/**
		 * Panel choixVisiteur
		 */
		this.choixVis = new V_choixVisiteur();
		
		this.choixSuivi = new V_choixSuivi();
		
		/**
		 * Panel de l'accueil
		 */
		this.panAccueil = new JPanel();
		this.panAccueil.setBackground(bgColor);
		
	
		
		/**
		 * Panel afficher fiche validées
		 */
		this.v_validee = new V_ficheValidee();
		this.v_validee.setBackground(bgColor);
		
		/*
		 * MENU BAR
		 */
		this.menu = new JMenuBar();
		
		/*
		 * MENU
		 */
		this.fiche = new JMenu("Fiche");
		
		/*
		 * ITEMS
		 */
		this.consulter = new JMenuItem("Consulter");
		this.listeDesVisiteur = new JMenuItem("Liste des visiteurs");
		this.suivi = new JMenuItem("Suivi paiement");
		this.valider = new JMenuItem("Fiche Validées");
		this.deconnexion = new JMenuItem("Deconnexion");

		
		
		/*
		 * Label visiteur
		 */

		//Recupere le nom et le prenom du visiteur
		for(int i =0; i<Modele.getNomPrenomC().size(); i++){
			Visiteur comptable = Modele.getNomPrenomC().get(i); 
			nom = comptable.getNom();
			prenom = comptable.getPrenom();
		}
		
		/**
		 * Tableau visiteur
		 */
		this.listeVisiteurs = new V_afficherVisiteur(nom,prenom);
		this.listeVisiteurs.setBackground(bgColor);
		

		 /* AJOUT DE "JMenuBar->menu" DANS LA FENETRE
		 */
		this.setJMenuBar(menu);
	
		//AJOUT DU MENU "consulter" DANS le "JMenuBar->menu"
		this.menu.add(fiche);
		
		/*
		 * AJOUT DES ITEMS DANS LE MENU "fiche"
		 */
		this.fiche.add(consulter);
		this.fiche.add(listeDesVisiteur);
		this.fiche.add(suivi);
		this.fiche.add(valider);
		this.fiche.add(deconnexion);
		
		
		/*
		 * Ajout du label nomVisiteur dans le panel "paneAccueil"
		 * Ajout du tableau listeVisiteur dans le panel "paneAccueil"
		 */

		this.panAccueil.add(listeVisiteurs);
		
		
		/*
		 * Ajout du panel "panAccueil" dans la fenêtre
		 */
		this.getContentPane().add(panAccueil);
		
		/**
		 * ACTION ITEM "FicheVisiteur"
		 * Cette action permet d'ouvrir le panel "ChoixVisiteur"
		 * @author Zoubert hanem
		 */
		this.consulter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * Remplace le panel "panAccueil" par le panel "choixVis"
				 */
				setContentPane(choixVis);
				setVisible(true);
			}
		});
		
		/**
		 * ACTION ITEM "listeDesVisiteur"
		 * Cette action permet d'ouvrir le panel "listeVisiteurs"
		 */
		this.listeDesVisiteur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setContentPane(listeVisiteurs);
				setVisible(true);
			}
		});

		
		/**
		 * ACTION ITEM "suivi"
		 * Cette action permet d'ouvrir le panel "listeVisiteurs"
		 */
		this.suivi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setContentPane(choixSuivi);
				setVisible(true);
			}
		});
		
		/**
		 * ACTION ITEM "valider"
		 * Cette action permet d'ouvrir le panel "listeVisiteurs"
		 */
		this.valider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setContentPane(v_validee);
				setVisible(true);
			}
		});
		/**
		 * ACTION ITEM "deconnexion"
		 * Cette action permet de deconecter
		 * @author Zoubert hanem
		 */
		this.deconnexion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//fermer la premiere fenêtre 
				dispose();
				
				V_login log = new  V_login();
				log.setVisible(true);
			}
		});
		
		
		/**
		 * ACTION boutton "BtnValider" de la classe V_choixVisiteur
		 * Cette action permet d'ouvrir le panel "ficheFrais"
		 * @author Zoubert hanem
		 */
		V_choixVisiteur.getBtnValider().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
	
				ficheFrais = new V_etatFrais(choixVis.getChoixVisiteur(),choixVis.getChoixMois());
				ficheFrais.setBackground(bgColor);
				setContentPane(ficheFrais);
				setVisible(true);
			}
		});
		
		/**
		 * ACTION boutton "BtnValider" de la classe V_choixSuivi
		 *
		 * @author 
		 */
		V_choixSuivi.getBtnValider().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null,"Suivie paiement EN COURS","Partie Folaké",JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}
