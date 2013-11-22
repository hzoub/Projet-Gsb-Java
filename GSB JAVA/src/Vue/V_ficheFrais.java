package Vue;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
/**
 * 
 * @author Zoubert hanem
 *
 */
@SuppressWarnings("serial")
public class V_ficheFrais extends JPanel {
	
	private JLabel lblTitre;
	private JLabel lblChoixVisiteur;
	private JComboBox<String>choixVisiteur;
	private JLabel lblChoixMois;
	private JComboBox<Date>choixMois;
	private JPanel panelForm;
	private Color bgColor;
	private JButton btnValider;
	
	/**
	 * Constructeur V_ficheFrais
	 */
	public V_ficheFrais(){
		
		//COULEUR ARRIERE-PLAN
		this.bgColor = Color.decode("#00CED1");
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
		this.lblTitre.setPreferredSize(new Dimension(800,100));
		
		//LABEL Visiteur
		this.lblChoixVisiteur = new JLabel("Visiteur :");
		this.lblChoixVisiteur.setPreferredSize(new Dimension(70,10));
		
		//Liste deroulante Visiteur
		this.choixVisiteur = new JComboBox<String>();
		this.choixVisiteur.setPreferredSize(new Dimension(150,20));
		
		//LABEL mois
		this.lblChoixMois = new JLabel("Mois :");
		this.lblChoixMois.setPreferredSize(new Dimension(70,10));
		
		//Liste deroulante mois
		this.choixMois = new JComboBox<Date>();
		this.choixMois.setPreferredSize(new Dimension(150,20));
		
		//BOUTTON VALIDER
		this.btnValider = new JButton("Valider");
		
		//AJOUT DU TITRE DANS LE PANEL
		this.add(lblTitre);
		
		//AJOUT DES COMPOSANT DANS LE FORMAULAIRE "panelForm"
		this.panelForm.add(lblChoixVisiteur);
		this.panelForm.add(choixVisiteur);
		this.panelForm.add(lblChoixMois);
		this.panelForm.add(choixMois);
		this.panelForm.add(btnValider);
		
		//AJOUT DU FORMULAIRE DANS LE PANEL
		this.add(panelForm);
	}
}
