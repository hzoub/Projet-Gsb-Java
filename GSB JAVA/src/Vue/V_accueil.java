package Vue;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Modele.Modele;
import Modele.Mois;
import Modele.Visiteur;
/**
 * Accueil de l'application affiche la vue <b>V_afficherVisiteur</b>
 *@author Aguiar Folaké
 *@version 1.0
 */
@SuppressWarnings("serial")
public class V_accueil extends JFrame {
		
	private JMenuBar menuBar;
	
	private JMenu menu ;
	
	private JMenuItem validerFiche;
	private JMenuItem listeDesVisiteur;
	private JMenuItem suivi ;
	private JMenuItem infosFicheVa ;
	private JMenuItem deconnexion ;
	
	private Color bgColor;
	private String nomC,prenomC;

	//PANELS
	private JPanel panAccueil;
	
	private V_etatFrais panFicheFrais;
	private V_afficherVisiteur panListeVisiteurs;
	private V_choixVisiteur panChoixVis;
	private V_ficheValidee panFicheValidee;
	private V_choixSuivi panChoixSuivi;
	private V_suivi panSuiviV ;
	private V_suiviePaiement panSuiviePaiement ;
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
		this.panChoixVis = new V_choixVisiteur();

		
		/**
		 * Panel de l'accueil
		 */
		this.panAccueil = new JPanel();
		this.panAccueil.setBackground(bgColor);
		
	
		
		/**
		 * Panel fiche validées
		 */
		this.panFicheValidee = new V_ficheValidee();
		this.panFicheValidee.setBackground(bgColor);
		
		/**
		 * Panel suivi
		 */
		this.panSuiviV = new V_suivi();
		this.panSuiviV.setBackground(bgColor);
		
		/**
		 * Panel choixSuivi
		 */
		this.panChoixSuivi = new V_choixSuivi();
		
		/*
		 * MENU BAR
		 */
		this.menuBar = new JMenuBar();
		
		/*
		 * MENU
		 */
		this.menu = new JMenu("Menu");
		
		/*
		 * ITEMS
		 */
		this.validerFiche = new JMenuItem("Valider fiche",new ImageIcon("images/valider.png"));
		
		this.listeDesVisiteur = new JMenuItem("Liste des visiteurs",new ImageIcon("images/lstVisiteur.png"));
		this.suivi = new JMenuItem("Suivi paiement",new ImageIcon("images/rembourser.png"));
		this.infosFicheVa = new JMenuItem("Fiche Validée(s)",new ImageIcon("images/ficheVa.png"));
		this.deconnexion = new JMenuItem("Déconnexion",new ImageIcon("images/logout.png"));

		
		
		/*
		 * Label visiteur
		 */

		//Recupere le nom et le prenom du visiteur
		for(int i =0; i<Modele.getNomPrenomC().size(); i++){
			Visiteur comptable = Modele.getNomPrenomC().get(i); 
			nomC = comptable.getNom();
			prenomC = comptable.getPrenom();
		}
		
		/**
		 * Tableau visiteur
		 */
		this.panListeVisiteurs = new V_afficherVisiteur(nomC,prenomC);
		this.panListeVisiteurs.setBackground(bgColor);
		

		 /* AJOUT DE "JMenuBar->menu" DANS LA FENETRE
		 */
		this.setJMenuBar(menuBar);
	
		//AJOUT DU MENU "consulter" DANS le "JMenuBar->menu"
		this.menuBar.add(menu);
		
		/*
		 * AJOUT DES ITEMS DANS LE MENU "fiche"
		 */
		this.menu.add(validerFiche);
		this.menu.add(new JSeparator());
		this.menu.add(listeDesVisiteur);
		this.menu.add(new JSeparator());
		this.menu.add(suivi);
		this.menu.add(new JSeparator());
		this.menu.add(infosFicheVa);
		this.menu.add(new JSeparator());
		this.menu.add(deconnexion);
		
		
		/*
		 * Ajout du label nomVisiteur dans le panel "paneAccueil"
		 * Ajout du tableau listeVisiteur dans le panel "paneAccueil"
		 */

		this.panAccueil.add(panListeVisiteurs);
		
		
		/*
		 * Ajout du panel "panAccueil" dans la fenêtre
		 */
		this.getContentPane().add(panAccueil);
		
		/***************************ACTIONS ITEMS***********************/
		this.validerFiche.addActionListener(new ActionItemValiderFiche());
		
		this.listeDesVisiteur.addActionListener(new ActionItemLstVisiteur());

		this.suivi.addActionListener(new ActionItemSuivi());
		
		this.infosFicheVa.addActionListener(new ActionItemInfosFicheVA());
		
		this.deconnexion.addActionListener(new ActionItemDeconnexion());
		
		
		
		/***********************ACTIONS BOUTTONS PANEL***********************/
		/**
		 * ACTION boutton "BtnValider" de la classe V_choixVisiteur
		 * Cette action permet d'ouvrir le panel "ficheFrais"
		 * @author Zoubert hanem
		 */
		V_choixVisiteur.getBtnValider().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
	
				panFicheFrais = new V_etatFrais(panChoixVis.getChoixVisiteur(),panChoixVis.getChoixMois());
				panFicheFrais.setBackground(bgColor);
				setContentPane(panFicheFrais);
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
				/**
				 * Panel recap
				 */
				
				panSuiviePaiement = new V_suiviePaiement(panChoixSuivi.getChoixVisiteur(),panChoixSuivi.getChoixMois());
				panSuiviePaiement.setBackground(bgColor);
				setContentPane(panSuiviePaiement);
				setVisible(true);
			}
		});
		/**
		 * ACTION boutton "BtnValider" de la classe V_choixSuivi
		 *
		 * @author 
		 */
		V_choixSuivi.getBtnSuiviComplet().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setContentPane(panSuiviV);
				setVisible(true);
			}
		});
	}
	
	/**
	 * ACTION ITEM "validerFiche"
	 * Cette action permet d'ouvrir le panel "ChoixVisiteur"
	 * @author Zoubert hanem
	 */
	class ActionItemValiderFiche implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			/*
			 * Remplace le panel "panAccueil" par le panel "choixVis"
			 */
			updateV_choixVisiteur();
			setContentPane(panChoixVis);
			setVisible(true);
		}
		
	}
	
	/**
	 * ACTION ITEM "listeDesVisiteur"
	 * Cette action permet d'ouvrir le panel "listeVisiteurs"
	 */
	class ActionItemLstVisiteur implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			setContentPane(panListeVisiteurs);
			setVisible(true);
		}
		
	}
	
	
	/**
	 * ACTION ITEM "suivi"
	 * Cette action permet d'ouvrir le panel "listeVisiteurs"
	 */
	class ActionItemSuivi implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			setContentPane(panChoixSuivi);
			setVisible(true);
		}
		
	}
	
	/**
	 * ACTION ITEM "infosFicheVa"
	 * Cette action permet d'ouvrir le panel "listeVisiteurs"
	 */
	class ActionItemInfosFicheVA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			setContentPane(panFicheValidee);
			setVisible(true);
		}
		
	}
	
	/**
	 * ACTION ITEM "deconnexion"
	 * Cette action permet de deconecter
	 * @author Zoubert hanem
	 */
	class ActionItemDeconnexion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//fermer la premiere fenêtre 
			dispose();
			
			V_login log = new  V_login();
			log.setVisible(true);
		}
		
	}
	
	/**
	 * Met à jour le panel V_choixVisiteur
	 * @author Zoubert Hanem.
	 */
	public void updateV_choixVisiteur(){

		//Vide la liste deroulante choixVisiteur
		panChoixVis.getListeVisiteur().removeAllItems();
		
		for(int i=0; i<Modele.getVisiteursFicheCR().size();i++){
			Visiteur visiteur = Modele.getVisiteursFicheCR().get(i);
			
			//Ajoute les nouvelles donnée dans liste deroulante
			panChoixVis.getListeVisiteur().addItem(visiteur.getNom());
		}
		
		panChoixVis.getListeMois().removeAllItems();
		//Recupere le nom selectionné
		String nomVisiteur = (String) panChoixVis.getListeVisiteur().getSelectedItem();
		String idVisiteur = null;
		
		for (int i = 0; i <Modele.getIdVisiteur(nomVisiteur).size(); i++) {
			
			Visiteur visiteur = Modele.getIdVisiteur(nomVisiteur).get(i);
			idVisiteur = visiteur.getId();	
		}
		
		//Affiche le mois de la fiche du visiteur selectioné dans une liste déroulante
		for(int i=0; i<Modele.getMoisFicheCR(idVisiteur).size();i++){
			Mois mois = Modele.getMoisFicheCR(idVisiteur).get(i);
			panChoixVis.getListeMois().addItem(mois.getUnMois());
		}
		
		/**
		 * Si la liste est vide ,désactive le bouton valider du panel V_choixVisiteur
		 * et affiche un message
		 */
		if(panChoixVis.getListeVisiteur().getSelectedItem()==null){
			
			panChoixVis.add(V_choixVisiteur.getMsg());
			V_choixVisiteur.getBtnValider().setEnabled(false);
			
		}
		else{
			
			panChoixVis.remove(V_choixVisiteur.getMsg());
			V_choixVisiteur.getBtnValider().setEnabled(true);
		}
	}
}
