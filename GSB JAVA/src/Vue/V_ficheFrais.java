package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class V_ficheFrais extends JPanel {
	
	private JLabel lblTitre;
	private JLabel lblChoixVisiteur;
	private JComboBox<String>choixVisiteur;
	private JLabel lblChoixMois;
	private JComboBox<Date>choixMois;
	private JPanel panelForm;
	private Color bgColor;
	private JButton btnValider;
	
	public V_ficheFrais(){
		
		this.bgColor = Color.decode("#00CED1");
		this.setBackground(bgColor);
		
		this.panelForm = new JPanel();
		this.panelForm.setPreferredSize(new Dimension(250,140));
		this.panelForm.setBorder(new TitledBorder("Choix visiteur"));
		this.panelForm.setBackground(bgColor);
		
		
		this.lblTitre = new JLabel("<html>"+
				"<h1 style=\"font-family:Comic Sans MS\">"+
					"Choix du visiteur"+
				"</h1>",JLabel.CENTER);
		this.lblTitre.setPreferredSize(new Dimension(800,100));
		
		this.lblChoixVisiteur = new JLabel("Visiteur :");
		this.lblChoixVisiteur.setPreferredSize(new Dimension(70,10));
		this.choixVisiteur = new JComboBox<String>();
		this.choixVisiteur.setPreferredSize(new Dimension(150,20));
		
		this.lblChoixMois = new JLabel("Mois :");
		this.lblChoixMois.setPreferredSize(new Dimension(70,10));
		this.choixMois = new JComboBox<Date>();
		this.choixMois.setPreferredSize(new Dimension(150,20));
		
		this.btnValider = new JButton("Valider");
		
		this.add(lblTitre);
		
		this.panelForm.add(lblChoixVisiteur);
		this.panelForm.add(choixVisiteur);
		this.panelForm.add(lblChoixMois);
		this.panelForm.add(choixMois);
		this.panelForm.add(btnValider);
		
		this.add(panelForm);
	}
}
