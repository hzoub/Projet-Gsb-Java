package Vue;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.Etat;
import Modele.Modele;
import Modele.Visiteur;
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
		private JComboBox<String>listeStatut;
		private JLabel elementFofaitises;
		private JLabel fraisKilometrique;
		private JLabel nuitHotel;
		private JLabel repasRestaurant;
		private JPanel panStatut;
		private Color bgColor;
		
	public V_etatFrais(Visiteur visiteur){
		
		this.panStatut = new JPanel();
		this.panStatut.setPreferredSize(new Dimension(300,50));
		
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
		
		
		this.statutFiche = new JLabel("<html>"+
				"<h2 style=\"font-family:Comic Sans MS\">"+
				"Statut de la fiche : "+
			"</h2>");
	
		this.listeStatut = new JComboBox<String>();
		
		for(int i=0; i<Modele.getLesEtats().size();i++){
			Etat etat = Modele.getLesEtats().get(i);
			this.listeStatut.addItem(etat.getlibelle());
		}
		
		
		this.elementFofaitises = new JLabel("<html>"+
				"<h2 style=\"font-family:Comic Sans MS\">"+
				"Eléments fofaitisés : "+
			"</h2>");
		this.elementFofaitises.setPreferredSize(new Dimension(700,30));
		//ajout
		this.add(this.nomVmedicale);
		this.add(this.date);
		
		//Ajout du label statut est de la liste deroulante des statuts dans le panel "panStatut"
		this.panStatut.add(this.statutFiche);
		this.panStatut.add(this.listeStatut);
		
		//Ajout du panel "panStatut & "elementFofaitises"
		this.add(this.panStatut);
		this.add(this.elementFofaitises);
		
		
	}
}
