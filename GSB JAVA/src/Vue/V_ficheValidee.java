package Vue;
import Modele.*;

import javax.swing.*;

import java.awt.*;
/**
 * Affiche la liste des visiteur ayant une fiche validées
 * @author Fraizy Brandon
 */

@SuppressWarnings("serial")
public class V_ficheValidee extends JPanel {
	
	private Object[][] donnees;
    private JTable tableau;
    private JScrollPane scroll;
   
	private JLabel lstVisiteur;
	
	private Color bgColor;
	private JPanel pan;
    public V_ficheValidee(){
    	
    	
    	/*
		 * Couleur arriere-plan de la fenetre
		 */
		this.bgColor = Color.decode("#77aadd");
    	/**
    	 * Création du tableau, affichant les visiteurs non comptable
    	 */
    	pan = new JPanel();
    	pan.setPreferredSize(new Dimension(700,600));
    	pan.setBackground(bgColor);
    
		this.lstVisiteur = new JLabel("<html>"+"<h2 style=\"font-family:Comic Sans MS\">"+" Liste des visiteurs dont les fiches sont validées:"+"</h2></html>",JLabel.CENTER);
		this.lstVisiteur.setPreferredSize(new Dimension(700,50));

    	//Entete
    	String[]entetes = {"Id","Nom","Prenom","Date modification","Montant validé","Etat"};
    	
    	//Définir la taille du tableau
    	this.donnees = new Object[Modele.getFicheValidees().size()][entetes.length];
    	
    
    	 this.tableau = new JTable(donnees, entetes);
  
		for (int i=0 ; i<Modele.getFicheValidees().size();i++){
			
			infosFicheVa ficheVa = Modele.getFicheValidees().get(i);
			
			this.donnees[i][0] = ficheVa.getId();
			this.donnees[i][1] = ficheVa.getNom();
			this.donnees[i][2] = ficheVa.getPrenom();
			this.donnees[i][3] = ficheVa.getDate();
			this.donnees[i][4] = ficheVa.getMontant()+" €";
			this.donnees[i][5] = ficheVa.getEtat();
			
		}
		
		//Taille et scroll
		this.scroll = new JScrollPane(tableau);
		this.scroll.setPreferredSize(new Dimension(600, 350));
		
		this.pan.add(this.lstVisiteur);
		this.pan.add(scroll);
		
		this.add(this.pan);
	
  }

    
}
