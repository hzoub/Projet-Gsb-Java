package Vue;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import Modele.*;
/**
 * 
 * @author Aguiar
 *
 */
@SuppressWarnings("serial")
public class V_choixSuivi extends JPanel{
	
	private JLabel lblTitre;
	private JLabel lblChoixVisiteur;
	private JComboBox<String>choixVisiteur;
	private JLabel lblChoixMois;
	private JComboBox<Date>choixMois;
	private JPanel panelForm;
	private Color bgColor;
	private  static JButton btnValider;
	private JLabel espace;

	/**
	 * Constructeur V_ficheFrais
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
					"Choix du visiteur ( Suivi )"+
				"</h1>",JLabel.CENTER);
		this.lblTitre.setPreferredSize(new Dimension(800,100));
		
		//LABEL Visiteur
		this.lblChoixVisiteur = new JLabel("Visiteur :");
		this.lblChoixVisiteur.setPreferredSize(new Dimension(70,10));
		
		
		//Liste deroulante Visiteur
		this.choixVisiteur = new JComboBox<String>();

		for(int i=0; i<Modele.getVisiteurSuiviPaiement().size();i++){
			Visiteur visiteur = Modele.getVisiteurSuiviPaiement().get(i);
			this.choixVisiteur.addItem(visiteur.getNom());
		}
		this.choixVisiteur.setPreferredSize(new Dimension(150,20));
		
		//LABEL mois
		this.lblChoixMois = new JLabel("Mois :");
		this.lblChoixMois.setPreferredSize(new Dimension(70,10));
		
		//Liste deroulante mois
		this.choixMois = new JComboBox<Date>();
		this.choixMois.setPreferredSize(new Dimension(150,20));
		
		//Espace entre les labels est les bouttons
		this.espace = new JLabel();
		this.espace.setPreferredSize(new Dimension(220,15));
		
		//BOUTTON VALIDER
		btnValider = new JButton("Valider");
		
		//this.btnValider.addActionListener(this);
		
		//AJOUT DU TITRE DANS LE PANEL
		this.add(lblTitre);
		
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

		/**
		 * @return le boutton "Valider"
		 */
		public static JButton getBtnValider() {
			return btnValider;
		}
}
