package Vue;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Modele.Modele;
import Modele.Visiteur;
/**
 * @author Aguiar Folaké
 *@version 1.0
 */
@SuppressWarnings("serial")
public class V_accueil extends JFrame {
		
	private JMenuBar menu;
	private JMenu fiche ;
	private JMenuItem consulter;
	private JMenuItem ToutesLesFiches;
	private JMenuItem validation ;
	private JMenuItem suivi ;
	private JMenuItem deconnexion ;
	private V_choixVisiteur choixVis;
	private JLabel nomVisiteur;
	private JPanel panAccueil;
	private Color bgColor;
	private V_etatFrais ficheFrais;
	private V_afficherVisiteur listeVisiteurs;
	private String nom,prenom;
	private JLabel lstVisiteur;

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
		
		/*
		 * Panel choixVisiteur
		 */
		this.choixVis = new V_choixVisiteur();
		
		
		
		/*
		 * Panel de l'accueil
		 */
		this.panAccueil = new JPanel();
		this.panAccueil.setBackground(bgColor);
		
		/*
		 * Tableau visiteur
		 */
		this.listeVisiteurs = new V_afficherVisiteur();
		this.listeVisiteurs.setBackground(bgColor);
		/*
		 * MENU BAR
		 */
		this.menu = new JMenuBar();
		
		/*
		 * MENU
		 */
		this.fiche = new JMenu("Fiche");
		this.validation = new JMenuItem("Validation");
		this.suivi = new JMenuItem("Suivi");
		
		/*
		 * ITEMS
		 */
		this.deconnexion = new JMenuItem("Deconnexion");
		this.consulter = new JMenuItem("Consulter");
		this.ToutesLesFiches = new JMenuItem("Toutes Les Fiches");


		
		
		/*
		 * Label visiteur
		 */

		//Recupere le nom et le prenom du visiteur
		for(int i =0; i<Modele.getNomPrenomC().size(); i++){
			Visiteur comptable = Modele.getNomPrenomC().get(i); 
			nom = comptable.getNom();
			prenom = comptable.getPrenom();
		}
		this.nomVisiteur= new JLabel("<html>"+
										"<h1 style=\"font-family:Comic Sans MS\">"+
											"Comptable : "+nom+" "+prenom+
										"</h1></html>",JLabel.CENTER);
		this.nomVisiteur.setPreferredSize(new Dimension(700,50));
		
		this.lstVisiteur = new JLabel("<html>"+"<h2 style=\"font-family:Comic Sans MS\">"+" Liste des visiteurs :"+"</h2></html>",JLabel.CENTER);
		this.lstVisiteur.setPreferredSize(new Dimension(700,50));
		
		 /* AJOUT DE "JMenuBar->menu" DANS LA FENETRE
		 */
		this.setJMenuBar(menu);
	
		//AJOUT DU MENU "consulter" DANS le "JMenuBar->menu"
		this.menu.add(fiche);
		
		/*
		 * AJOUT DES ITEMS DANS LE MENU "fiche"
		 */
		this.fiche.add(consulter);
		this.fiche.add(ToutesLesFiches);
		this.fiche.add(validation);
		this.fiche.add(suivi);
		this.fiche.add(deconnexion);
		
		
		/*
		 * Ajout du label nomVisiteur dans le panel "paneAccueil"
		 * Ajout du tableau listeVisiteur dans le panel "paneAccueil"
		 */
		this.panAccueil.add(nomVisiteur);
		this.panAccueil.add(listeVisiteurs);
		
		
		/*
		 * Ajout du panel "panAccueil" dans la fenêtre
		 */
		this.getContentPane().add(panAccueil);
		
		/**
		 * ACTION boutton "BtnValider" de la classe V_choixVisiteur
		 * Cette action permet d'ouvrir le panel "ficheFrais"
		 * @author Zoubert hanem
		 */
		V_choixVisiteur.getBtnValider().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * Panel fiche frais
				 */
				ficheFrais = new V_etatFrais(choixVis.getChoixVisiteur());
				ficheFrais.setBackground(bgColor);
				setContentPane(ficheFrais);
				setVisible(true);
			}
		});
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
	}
}
