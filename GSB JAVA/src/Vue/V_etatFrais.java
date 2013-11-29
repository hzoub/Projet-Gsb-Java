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
	    
	public V_etatFrais(String visiteur){
		
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
									"Fiche de frais du mois : "+
								"</h2>");
		this.date.setPreferredSize(new Dimension(700,30));
		
		
		this.statutFiche = new JLabel("Statut de la fiche : ");
	
		this.listeStatut = new JComboBox<String>();

		
		for(int i=0; i<Modele.getLesEtats().size();i++){
			Etat etat = Modele.getLesEtats().get(i);
			
			this.listeStatut.addItem(etat.getlibelle());
		
		}
		
		
		this.elementFofaitises = new JLabel("Eléments fofaitisés :");
		this.elementFofaitises.setPreferredSize(new Dimension(700,30));
		
		/**TABLEAU 1**/
		//Entete
    	String[]entetesElFofaitises = {"Forfait Etape","Frais Kilométrique","Nuitée Hôtel","Repas Restaurant"};
    	
    	//Définir la taille du tableau
    	this.donneesElFofaitises = new Object[1][entetesElFofaitises.length];
    	
    
    	 this.tableauElFofaitises = new JTable(donneesElFofaitises, entetesElFofaitises);
  
		for (int i=0 ; i<1 ;i++){
		
			
			this.donneesElFofaitises[i][0] = "";
			this.donneesElFofaitises[i][1] = "";
			this.donneesElFofaitises[i][2] = "";
		}
		this.scrollElFofaitises = new JScrollPane(tableauElFofaitises);
		this.scrollElFofaitises.setPreferredSize(new Dimension(730, 60));
		
		
		
		this.descriptifElement = new JLabel("Descriptif des éléments hors forfait ");
		this.descriptifElement.setPreferredSize(new Dimension(700,30));
		
		/**TABLEAU 2**/
		//Entete
    	String[]entetesDescElement = {"Date","Libellé","Montant"};
    	
    	//Définir la taille du tableau
    	this.donneesDescElement = new Object[1][entetesElFofaitises.length];
    	
    
    	 this.tableauDescElement = new JTable(donneesDescElement, entetesDescElement);
  
		for (int i=0 ; i<1 ;i++){
		
			
			this.donneesDescElement[i][0] = "";
			this.donneesDescElement[i][1] = "";
			this.donneesDescElement[i][2] = "";
		}
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
		this.add(this.scrollDescElement);
		this.add(this.bntValider );
	}
}
