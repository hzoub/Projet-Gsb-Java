package Vue;
import java.awt.*;

import javax.swing.*;

import Modele.*;
/**
 * 
 * @author Zoubert hanem
 *
 */
@SuppressWarnings("serial")
public class V_etatFrais extends JPanel{
	
		private JLabel nomVmedicale;
		private JLabel date;
		private JLabel statutFiche;
		private JLabel descriptifElement;
		
		private JComboBox<String>listeStatut;
		private JLabel elementFofaitises;
		
		private JPanel panStatut;
		private JPanel panLesForfais;
		private Color bgColor;
		
		private Object[][] donneesElFofaitises;
	    private JTable tableauElFofaitises;
	    private JScrollPane scrollElFofaitises;
	    
	    private Object[][] donneesDescElement;
	    private JTable tableauDescElement;
	    private JScrollPane scrollDescElement;
	    
	    private JButton bntValider;
	    
	    private String idVisiteur;
	    
	public V_etatFrais(String visiteur, Object mois){
		
		this.panStatut = new JPanel();
		this.panStatut.setPreferredSize(new Dimension(400,50));
		
		this.panLesForfais = new JPanel();
		this.panLesForfais.setBackground(bgColor);
		
		this.bgColor = Color.decode("#77aadd");
		
		this.panStatut.setBackground(bgColor);
		
		
		
		this.nomVmedicale = new JLabel(	"<html>"+
										"<h1 style=\"font-family:Comic Sans MS\">"+
										"Fiche visteur de "+visiteur+
									"</h1>",JLabel.CENTER);
		this.nomVmedicale.setPreferredSize(new Dimension(700,30));
		
		
		
		this.date = new JLabel("<html>"+
									"<h2 style=\"font-family:Comic Sans MS\">"+
									"Fiche de frais du mois : "+mois+
								"</h2>");
		this.date.setPreferredSize(new Dimension(700,30));
		
		
		this.statutFiche = new JLabel("Statut de la fiche : ");
	
		this.listeStatut = new JComboBox<String>();

		
		for(int i=0; i<Modele.getLesEtats().size();i++){
			Etat etat = Modele.getLesEtats().get(i);
			
			this.listeStatut.addItem(etat.getlibelle());
		
		}
		
		/**
		 * Cette fonction recupére l'idVisiteur en fonction de son nom
		 * @author Zoubert Hanem
		 */
		for (int i = 0; i <Modele.getIdVisiteur(visiteur).size(); i++) {
			
			Visiteur visit = Modele.getIdVisiteur(visiteur).get(i);
			idVisiteur = visit.getId();
		}
		
		this.elementFofaitises = new JLabel("Eléments fofaitisés :");
		this.elementFofaitises.setPreferredSize(new Dimension(700,30));
		
		
		/**
		 * TABLEAU 1
		 */
		//Entete
	
    	String[]entetesElFofaitises = {"Libellé","quantité"};
    	
    	//Définir la taille du tableau
    	this.donneesElFofaitises = new Object[Modele.getLesFraisForfait(idVisiteur,mois).size()][entetesElFofaitises.length];
    	
    
    	 this.tableauElFofaitises = new JTable(donneesElFofaitises, entetesElFofaitises);
  
		for (int i=0 ; i<Modele.getLesFraisForfait(idVisiteur,mois).size() ;i++){
			
			FraisForfait fiche = Modele.getLesFraisForfait(idVisiteur,mois).get(i);
			this.donneesElFofaitises[i][0] = fiche.getLibelle();
			this.donneesElFofaitises[i][1] = fiche.getQte();
		}
		this.scrollElFofaitises = new JScrollPane(tableauElFofaitises);
		this.scrollElFofaitises.setPreferredSize(new Dimension(730,85));
		
		this.descriptifElement = new JLabel("Descriptif des éléments hors forfait ");
		this.descriptifElement.setPreferredSize(new Dimension(700,30));
		
		
		for (int i=0 ; i<Modele.getLesFraisHorsForfait(idVisiteur, mois).size() ;i++){
			
			FraisHorsForfait fhf = Modele.getLesFraisHorsForfait(idVisiteur, mois).get(i);
			
			System.out.println("Libellé -> "+fhf.getLibelle());
			System.out.println("Date -> "+fhf.getDate());
			System.out.println("Montant -> "+fhf.getMontant()+" €");
		}
		
		
		/**
		 * TABLEAU 2
		 */
		//Entete
    	String[]entetesDescElement = {"Libellé","Date","Montant"};
    	//Définir la taille du tableau
    	this.donneesDescElement = new Object[Modele.getLesFraisHorsForfait(idVisiteur,mois).size()][entetesElFofaitises.length];
    	this.tableauDescElement = new JTable(donneesDescElement,entetesDescElement);
		
		this.scrollDescElement = new JScrollPane(tableauDescElement);
		this.scrollDescElement.setPreferredSize(new Dimension(730, 60));
		
		this.bntValider = new JButton("Valider");
		
		
		//ajout
		this.add(this.nomVmedicale);
		this.add(this.date);
		
		//Ajout du label statut est de la liste deroulante des statuts dans le panel "panStatut"
		this.panStatut.add(this.statutFiche);
		this.panStatut.add(this.listeStatut);
		
		//Ajout du panel "panStatut & "elementFofaitises"
		this.add(this.panStatut);
		
		this.add(this.elementFofaitises);
		this.add(this.scrollElFofaitises);

		
		this.add(this.descriptifElement);
		//this.add(this.scrollDescElement);
		this.add(this.bntValider );
	}
}
