package Vue;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import Modele.*;
/**
 * Affiche les visiteurs ayant une fiche dont l'id de l'etat est <b>"VA"</b> 
 * c'est à dire <b>"Validée et mise en paiement"</b> et le mois dont la fiche
 * a été validée dans une liste déroulante
 * @author Aguiar
 *
 */
@SuppressWarnings("serial")
public class V_choixSuivi extends JPanel implements ActionListener {
	
	private JLabel lblTitre;
	private JLabel lblChoixVisiteur;
	private JComboBox<String>choixSuivi;
	private JLabel lblChoixMois;
	private JComboBox<Date>choixMois;
	private JPanel panelForm;
	private Color bgColor;
	private  static JButton btnValider;
	private static JButton btnSuiviComplet ;
	private JLabel espace;
	private String nomVisiteur;
	private String idVisiteur;
	
	

	/**
	 * Constructeur V_ficheFrais
	 * @param visiteur 
	 */
	public V_choixSuivi(){
		
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
					"Choix du visiteur ( Suivi ) </h1>",JLabel.CENTER);
		this.lblTitre.setPreferredSize(new Dimension(800,100));
		
		//LABEL Visiteur
		this.lblChoixVisiteur = new JLabel("Visiteur :");
		this.lblChoixVisiteur.setPreferredSize(new Dimension(70,10));
		
		
		//Liste deroulante Visiteur
		this.choixSuivi = new JComboBox<String>();

		for(int i=0; i<Modele.getFicheValidees().size();i++){
			Visiteur visiteur = Modele.getFicheValidees().get(i);
			this.choixSuivi.addItem(visiteur.getNom());
		}
		this.choixSuivi.setPreferredSize(new Dimension(150,20));
		
		//LABEL mois
		this.lblChoixMois = new JLabel("Mois :");
		this.lblChoixMois.setPreferredSize(new Dimension(70,10));
		
		//Liste deroulante mois
		this.choixMois = new JComboBox<Date>();
		this.choixMois.setPreferredSize(new Dimension(150,20));
		
		

		//Recupere le nom selectionné
		nomVisiteur = (String) choixSuivi.getSelectedItem();
		
		for (int i = 0; i <Modele.getIdVisiteur(nomVisiteur).size(); i++) {
			
			Visiteur visiteur = Modele.getIdVisiteur(nomVisiteur).get(i);
			idVisiteur = visiteur.getId();	
		}
		//Affiche le mois de la fiche du visiteur selectioné dans une liste déroulante
		for(int i=0; i<Modele.getMoisFicheVA(idVisiteur).size();i++){
			Mois mois = Modele.getMoisFicheVA(idVisiteur).get(i);
			//this.choixMois.addItem(mois.getUnMois());
		}
		
	
		
		//Espace entre les labels est les bouttons
		this.espace = new JLabel();
		this.espace.setPreferredSize(new Dimension(220,15));
		
		//BOUTTON VALIDER
		btnValider = new JButton("Valider");
		btnSuiviComplet = new JButton("Suivi de tous les visiteurs");
		
		//this.btnValider.addActionListener(this);
		
		//AJOUT DU TITRE DANS LE PANEL
		this.add(lblTitre);
		
		//AJOUT DES COMPOSANT DANS LE FORMAULAIRE "panelForm"
		this.panelForm.add(lblChoixVisiteur);
		this.panelForm.add(choixSuivi);
		this.panelForm.add(lblChoixMois);
		this.panelForm.add(choixMois);
		
		this.panelForm.add(espace);
		
		this.panelForm.add(btnValider);
		this.panelForm.add(btnSuiviComplet);
		
		//AJOUT DU FORMULAIRE DANS LE PANEL
		this.add(panelForm);
	}
	
	/**
	 * @return le visiteur
	 */
	public String getChoixVisiteur() {
		String visiteur = choixSuivi.getSelectedItem().toString();
		return visiteur;
	}

	public String  getChoixMois() {
		String mois =  (String) choixMois.getSelectedItem();
		return mois;
	}


		/**
		 * @return le boutton "Valider"
		 */
		public static JButton getBtnValider() {
			return btnValider;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	
		public static JButton getBtnSuiviComplet(){
			return btnSuiviComplet ;
			
		}

		
}
