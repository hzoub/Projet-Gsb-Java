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
		
//		private Object[][] donnees;
//	    private JTable tableau;
//	    private JScrollPane scroll;
	    
	public V_etatFrais(Visiteur visiteur){
		
		this.panStatut = new JPanel();
		this.panStatut.setPreferredSize(new Dimension(400,50));
		
		this.panLesForfais = new JPanel();
		this.panLesForfais.setBackground(bgColor);
		
		this.bgColor = Color.decode("#77aadd");
		
		this.panStatut.setBackground(bgColor);
		
		
		
		this.nomVmedicale = new JLabel(	"<html>"+
										"<h1 style=\"font-family:Comic Sans MS\">"+
										"Fiche visteur de"+
									"</h1>",JLabel.CENTER);
		this.nomVmedicale.setPreferredSize(new Dimension(700,30));
		
		
		this.date = new JLabel("<html>"+
									"<h2 style=\"font-family:Comic Sans MS\">"+
									"Date : "+
								"</h2>");
		this.date.setPreferredSize(new Dimension(700,30));
		
		
		this.statutFiche = new JLabel("Statut de la fiche : ");
	
		this.listeStatut = new JComboBox<String>();

		
		for(int i=0; i<Modele.getLesEtats().size();i++){
			Etat etat = Modele.getLesEtats().get(i);
			
			this.listeStatut.addItem(etat.getlibelle());
		
		}
		
		
		this.elementFofaitises = new JLabel("El�ments fofaitis�s :");
		this.elementFofaitises.setPreferredSize(new Dimension(700,30));
		
		this.descriptifElement = new JLabel("Descriptif des �l�ments hors forfait ");
		this.descriptifElement.setPreferredSize(new Dimension(700,30));
		//ajout
		this.add(this.nomVmedicale);
		this.add(this.date);
		
		//Ajout du label statut est de la liste deroulante des statuts dans le panel "panStatut"
		this.panStatut.add(this.statutFiche);
		this.panStatut.add(this.listeStatut);
		
		//Ajout du panel "panStatut & "elementFofaitises"
		this.add(this.panStatut);
		
		this.add(this.elementFofaitises);
		

		
		this.add(this.descriptifElement);
	}
}
