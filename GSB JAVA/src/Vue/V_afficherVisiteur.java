package Vue;
import Modele.*;

import javax.swing.*;

import java.awt.*;


@SuppressWarnings("serial")
public class V_afficherVisiteur extends JPanel {
	
	private Object[][] donnees;
    private JTable tableau;
    private JScrollPane scroll;
    
    
    public V_afficherVisiteur(){
    	/**
    	 * Création du tableau, affichant les visiteurs non comptable
    	 */
    	
    	
    	//Entete
    	String[]entetes = {"Id","Nom","Prenom"};
    	
    	//Définir la taille du tableau
    	this.donnees = new Object[Modele.getLesVisiteurs().size()][entetes.length];
    	
    
    	 this.tableau = new JTable(donnees, entetes);
  
    	//Boucle parcourant la taille de la fonction getLesVisiteurs(), et les ajoute dans le tableau (le nom, prenom et id)
	for (int i=0 ; i<Modele.getLesVisiteurs().size();i++){
		Visiteur visiteur = Modele.getLesVisiteurs().get(i);
		
		this.donnees[i][0] = visiteur.getId();
		this.donnees[i][1] = visiteur.getNom();
		this.donnees[i][2] = visiteur.getPrenom();
	}
	//Taille et scroll
	this.scroll = new JScrollPane(tableau);
	this.scroll.setPreferredSize(new Dimension(450, 300));
	this.add(scroll);
  }

    
}
