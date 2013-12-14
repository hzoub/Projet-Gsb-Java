package Vue;
import java.awt.*;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import Modele.*;
/**
 * 
 * @author Zoubert hanem
 *
 */
@SuppressWarnings("serial")
public class V_choixVisiteur extends JPanel implements ActionListener{
	
	private JLabel lblTitre;
	private JLabel lblChoixVisiteur;
	private JComboBox<String>choixVisiteur;
	private JLabel lblChoixMois;
	private JComboBox<Integer>choixMois;
	private JPanel panelForm;
	private Color bgColor;
	private static JButton btnValider;
	private JLabel espace;
	private String nomVisiteur;
	private String idVisiteur;
	private int moisFiche;
	private String date;
	private JLabel lblDate;
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

		for(int i=0; i<Modele.getLesVisiteurs().size();i++){
			Visiteur visiteur = Modele.getLesVisiteurs().get(i);
			this.choixVisiteur.addItem(visiteur.getNom());
		}
		this.choixVisiteur.setPreferredSize(new Dimension(150,20));
		
		//LABEL mois
		this.lblChoixMois = new JLabel("Mois :");
		this.lblChoixMois.setPreferredSize(new Dimension(70,10));
		
		//Liste deroulante mois
		this.choixMois = new JComboBox<Integer>();
		this.choixMois.setPreferredSize(new Dimension(150,20));
		this.choixMois = new JComboBox<Integer>();
		this.choixMois.setPreferredSize(new Dimension(150,20));
		
		//Recupere le nom selectionné
		nomVisiteur = (String) choixVisiteur.getSelectedItem();
		
		for (int i = 0; i <Modele.getIdVisiteur(nomVisiteur).size(); i++) {
			
			Visiteur visiteur = Modele.getIdVisiteur(nomVisiteur).get(i);
			idVisiteur = visiteur.getId();	
		}
		
		//Affiche le mois de la fiche du visiteur selectioné dans une liste déroulante
		for(int i=0; i<Modele.getLesMois(idVisiteur).size();i++){
			Mois mois = Modele.getLesMois(idVisiteur).get(i);
			this.choixMois.addItem(mois.getUnMois());
		}
		
		/**
		 * Action liste deroulante visiteur
		 * @author hzoubert
		 */
		this.choixVisiteur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Recupere le nom selectionné
				nomVisiteur = (String) choixVisiteur.getSelectedItem();
				
				for (int i = 0; i <Modele.getIdVisiteur(nomVisiteur).size(); i++) {
					
					Visiteur visiteur = Modele.getIdVisiteur(nomVisiteur).get(i);
					idVisiteur = visiteur.getId();	
				}
				
				
				choixMois.removeAllItems();
				for(int i=0; i<Modele.getLesMois(idVisiteur).size();i++){
					Mois mois = Modele.getLesMois(idVisiteur).get(i);	
					choixMois.addItem(mois.getUnMois());
					moisFiche = (int) choixMois.getSelectedItem();
				}
				
				if(moisFiche==0){
					JOptionPane.showMessageDialog(null,"Ce visiteur n'a pas de fiche","Erreur",JOptionPane.INFORMATION_MESSAGE);
					btnValider.setEnabled(false);
				}else{
					btnValider.setEnabled(true);
				}
			}
		});
		//Espace entre les labels est les bouttons
		this.espace = new JLabel();
		this.espace.setPreferredSize(new Dimension(220,15));
		
		//BOUTTON VALIDER
		V_choixVisiteur.btnValider = new JButton("Valider");
		
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
		
		
	}
	

	
	/**
	 * @return le visiteur
	 */
	public String getChoixVisiteur() {
		String visiteur = choixVisiteur.getSelectedItem().toString();
		return visiteur;
	}

	public Object getChoixMois() {
		Object mois =  choixMois.getSelectedItem();
		return mois;
	}

		/**
		 * @return le boutton "Valider"
		 */
		public static JButton getBtnValider() {
			return btnValider;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("test");
			
		}
}
