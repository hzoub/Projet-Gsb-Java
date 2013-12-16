package Vue;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	    
	    private Object[][] DescElHorFofais;
	    private JTable tblDescElHorFofais;
	    private JScrollPane scrollDescElHorFofais;
	    
	    private JButton bntValider;
	    
	    private String idVisiteur;
	    
	public V_etatFrais(String visiteur, Object mois){
		
		/**
		 * 
		 */
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

		/**
		 * Liste deroulante "etat"
		 */
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
		
		/*-----------------------------------------------------------*/
		/**
		 * TABLEAU Eléments fofaitisés
		 * @author Zoubert Hanem
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
		/*------------------------------------------------------------*/
		
		this.descriptifElement = new JLabel("Descriptif des éléments hors forfait ");
		this.descriptifElement.setPreferredSize(new Dimension(700,30));	
		
		/*------------------------------------------------------------*/
		/**
		 * TABLEAU Descriptif des éléments hors forfait
		 */
		//Entete
		String[]entetesHorsForfait = {"Libellé","Date","Montant"};
    	//Définir la taille du tableau
    	this.DescElHorFofais = new Object[Modele.getLesFraisHorsForfait(idVisiteur,mois).size()][entetesHorsForfait.length];
    	
    	this.tblDescElHorFofais = new JTable(DescElHorFofais,entetesHorsForfait);
  
		for (int i=0 ; i<Modele.getLesFraisHorsForfait(idVisiteur,mois).size() ;i++){
			
			FraisHorsForfait fhf = Modele.getLesFraisHorsForfait(idVisiteur,mois).get(i);
			this.DescElHorFofais[i][0] = fhf.getLibelle();
			this.DescElHorFofais[i][1] = fhf.getDate();
			this.DescElHorFofais[i][2] = fhf.getMontant();
		}
		this.scrollDescElHorFofais = new JScrollPane(tblDescElHorFofais);
		this.scrollDescElHorFofais.setPreferredSize(new Dimension(730,50));
		/*-------------------------------------------------------------*/
		
		//boutton valider
		this.bntValider = new JButton("Valider");
		
		
		//ajout
		this.add(this.nomVmedicale);
		this.add(this.date);
		
		//Ajout du label statut est de la liste deroulante des statuts dans le panel "panStatut"
		this.panStatut.add(this.statutFiche);
		this.panStatut.add(this.listeStatut);
		
		//Ajout du panel "panStatut & "elementFofaitises"
		this.add(this.panStatut);
		
		/**
		 * Tableau 1
		 */
		this.add(this.elementFofaitises);
		this.add(this.scrollElFofaitises);

		/**
		 * Tabeau 2
		 */
		this.add(this.descriptifElement);
		this.add(this.scrollDescElHorFofais);
		
		this.add(this.bntValider );
		
		/**
		 * Action boutton valider
		 */
		this.bntValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String statut = (String) listeStatut.getSelectedItem();
				JOptionPane.showConfirmDialog(null,"Confirmez-vous le nouveau statut : "+statut+" ?","Validation",JOptionPane.YES_NO_OPTION);
			}
		});
	}
}
