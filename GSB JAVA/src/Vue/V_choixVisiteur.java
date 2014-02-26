package Vue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Modele.Modele;
import Modele.Mois;
import Modele.Visiteur;
/**
 * Affiche les visiteurs ayant une fiche dont l'id de l'etat est <b>"CR"</b> 
 * c'est � dire <b>"fiche cr��e, saisie en cours"</b> et le mois dont la fiche
 * a �t� cr�e dans une liste d�roulante
 * @author Zoubert hanem
 *
 */
@SuppressWarnings("serial")
public class V_choixVisiteur extends JPanel{
	
	private JLabel lblTitre;
	private JLabel lblChoixVisiteur;
	private JLabel lblChoixMois;
	
	private JComboBox<String>choixVisiteur;
	private JComboBox<String> choixMois;
	
	
	private JPanel panelForm;
	private Color bgColor;
	private static JButton btnValider;
	private JLabel espace;
	private String nomVisiteur;
	private String idVisiteur;

	private String date;


	private JLabel lblDate;
	private static JLabel msg;// s'il n y a aucune fiche 
	/**
	 * Constructeur V_ficheFrais
	 */
	public V_choixVisiteur(){
		
		//COULEUR ARRIERE-PLAN DU PANEL
		this.bgColor = Color.decode("#77aadd");
		this.setBackground(bgColor);
		
		//PANEL POUR LE FORMUAIRE
		this.panelForm = new JPanel();
		this.panelForm.setPreferredSize(new Dimension(250,140));
		this.panelForm.setBorder(new TitledBorder("Choix visiteur"));
		this.panelForm.setBackground(bgColor);
		
		//TITRE
		this.lblTitre = new JLabel("<html>"+
				"<h1 style=\"font-family:Comic Sans MS\">"+
					"Choix du visiteur"+
				"</h1>",JLabel.CENTER);
		this.lblTitre.setPreferredSize(new Dimension(800,50));
		
		this.date = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE).format(new Date());
		
		this.lblDate = new JLabel("Nous sommes le : "+date,JLabel.CENTER);
		this.lblDate.setPreferredSize(new Dimension(700,50));
		
		//LABEL Visiteur
		this.lblChoixVisiteur = new JLabel("Visiteur :");
		this.lblChoixVisiteur.setPreferredSize(new Dimension(70,10));
		
		
		//Liste deroulante Visiteur
		this.choixVisiteur = new JComboBox<String>();
		
		
		for(int i=0; i<Modele.getVisiteursFicheCR().size();i++){
			Visiteur visiteur = Modele.getVisiteursFicheCR().get(i);
			this.choixVisiteur.addItem(visiteur.getNom());
		}
		this.choixVisiteur.setPreferredSize(new Dimension(150,20));
		
		//LABEL mois
		this.lblChoixMois = new JLabel("Mois :");
		this.lblChoixMois.setPreferredSize(new Dimension(70,10));
		
		//Liste deroulante mois
		this.choixMois = new JComboBox<String>();
		this.choixMois.setPreferredSize(new Dimension(150,20));
		
		
		//Recupere le nom selectionn�
		this.nomVisiteur = (String) choixVisiteur.getSelectedItem();
		
		for (int i = 0; i <Modele.getIdVisiteur(nomVisiteur).size(); i++) {
			
			Visiteur visiteur = Modele.getIdVisiteur(nomVisiteur).get(i);
			this.idVisiteur = visiteur.getId();	
		}
		
		//Affiche le mois de la fiche du visiteur selection� dans une liste d�roulante
		for(int i=0; i<Modele.getMoisFicheCR(idVisiteur).size();i++){
			Mois mois = Modele.getMoisFicheCR(idVisiteur).get(i);
			this.choixMois.addItem(mois.getUnMois());
		}
		
		//Espace entre les labels est les bouttons
		this.espace = new JLabel();
		this.espace.setPreferredSize(new Dimension(220,15));
		
		//BOUTTON VALIDER
		btnValider = new JButton("Valider");
		
		//Ce message va s'afficher que quand il n y' aucune fiche 
		msg = new JLabel("Il n y'a aucune fiche a valider ce mois �i",JLabel.CENTER);
		msg.setPreferredSize(new Dimension(700,50));
		//this.btnValider.addActionListener(this);
		
		//AJOUT DU TITRE DANS LE PANEL
		this.add(lblTitre);
		this.add(lblDate);
		
		
		//AJOUT DES COMPOSANT DANS LE FORMAULAIRE "panelForm"
		this.panelForm.add(lblChoixVisiteur);
		this.panelForm.add(choixVisiteur);
		this.panelForm.add(lblChoixMois);
		this.panelForm.add(choixMois);
		
		this.panelForm.add(espace);
		
		this.panelForm.add(btnValider);
		
		//AJOUT DU FORMULAIRE DANS LE PANEL
		this.add(panelForm);
		
		/**
		 * Action liste deroulante visiteur
		 * @author hzoubert
		 */
		choixVisiteur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Recupere le nom selectionn�
				nomVisiteur = (String) choixVisiteur.getSelectedItem();
				
				for (int i = 0; i <Modele.getIdVisiteur(nomVisiteur).size(); i++) {
					
					Visiteur visiteur = Modele.getIdVisiteur(nomVisiteur).get(i);
					idVisiteur = visiteur.getId();	
				}
			}
		});
	}

		/**
		 * @return le visiteur
		 */
		public String getChoixVisiteur() {
			String visiteur = choixVisiteur.getSelectedItem().toString();
			return visiteur;
		}
		/**
		 * 
		 * @return le mois
		 */
		public String  getChoixMois() {
			String mois =  (String) choixMois.getSelectedItem();
			return mois;
		}
		
		/**
		 * 
		 * @return la liste deroulante choixVisiteur
		 */
		public JComboBox<String> getListeVisiteur() {
			return choixVisiteur;
		}
		
		/**
		 * 
		 * @return La liste d�roulant choixMois
		 */
		public JComboBox<String>  getListeMois() {
			return choixMois;
		}
	
		/**
		 * @return le boutton "Valider"
		 */
		public static JButton getBtnValider() {
			return btnValider;
		}

		/**
		 * @return le msg
		 */
		public static JLabel getMsg() {
			return msg;
		}
	
}
