package Vue;
import Modele.*;

import javax.swing.*;

import java.awt.*;

/**
 * Affiche la liste de tout les visiteurs sauf les comptables
 * @author Fraizy Brandon
 */
@SuppressWarnings("serial")
public class V_afficherVisiteur extends JPanel {
	
	private Object[][] donnees;
    private JTable tableau;
    private JScrollPane scroll;
    
    private JLabel nomVisiteur;
	private JLabel lstVisiteur;
	
	private Color bgColor;
	private JPanel pan;
	/**
	 * 
	 * @param nomVisiteur
	 * @param prenomVisiteur
	 */
    public V_afficherVisiteur(String nomVisiteur,String prenomVisiteur){
    	
    	
    	/*
		 * Couleur arriere-plan de la fenetre
		 */
		this.bgColor = Color.decode("#77aadd");
    	/**
    	 * Création du tableau, affichant les visiteurs non comptable
    	 */
		this.pan = new JPanel();
		this.pan.setPreferredSize(new Dimension(700,600));
		this.pan.setBackground(bgColor);
    	
    	this.nomVisiteur= new JLabel("<html>"+
				"<h1 style=\"font-family:Comic Sans MS\">"+
					"Comptable : "+nomVisiteur+" "+prenomVisiteur+
				"</h1></html>",JLabel.CENTER);
		this.nomVisiteur.setPreferredSize(new Dimension(700,50));
		
		this.lstVisiteur = new JLabel("<html>"+"<h2 style=\"font-family:Comic Sans MS\">"+" Liste des visiteurs :"+"</h2></html>",JLabel.CENTER);
		this.lstVisiteur.setPreferredSize(new Dimension(700,50));

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
	this.scroll.setPreferredSize(new Dimension(500, 350));
	
	this.pan.add(this.nomVisiteur);
	this.pan.add(this.lstVisiteur);
	this.pan.add(scroll);
	
	this.add(this.pan);
	
  }

    
}
