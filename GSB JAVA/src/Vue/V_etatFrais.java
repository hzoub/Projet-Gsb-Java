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
		private JLabel etatActuel;
		private String etatAct;
		
		private JPanel panStatut;
		private JPanel panLesForfais;
		private Color bgColor;
		
		private Object[][] donneesElFofaitises;
	    private JTable tableauElFofaitises;
	    private JScrollPane scrollElFofaitises;
	    
	    private Object[][] ElHorFofais;
	    private JTable tblElHorFofais;
	    private JScrollPane scrollElHorFofais;
	    
	    private JButton bntValider;
	    
	    private String idVisiteur;
	    
	    /*---Descriptif des éléments hors forfait---*/
	    private  String libelleElHorFofais ;
	    private String dateElHorFofais ;
	    private float montantElHorFofais ;
		
	    private int [] tabQte;
	public V_etatFrais(String visiteur, final String mois){
		
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
		
		/**
		 * Cette fonction recupére l'idVisiteur en fonction de son nom
		 * @author Zoubert Hanem
		 */
		for (int i = 0; i <Modele.getIdVisiteur(visiteur).size(); i++) {
			
			Visiteur visit = Modele.getIdVisiteur(visiteur).get(i);
			idVisiteur = visit.getId();
		}
		/**
		 *
		 */
		for(int i=0; i<Modele.getEtatActuel(idVisiteur, mois).size();i++){
			Etat etat = Modele.getEtatActuel(idVisiteur, mois).get(i);
			this.etatAct = etat.getlibelle();
		}
		//etat actuel de la fiche du visiteur séléctionné
		this.etatActuel = new JLabel("Etat actuel : "+this.etatAct);
		
		this.statutFiche = new JLabel("Statut de la fiche : ");
	
		this.listeStatut = new JComboBox<String>();
		
		/**
		 * Liste deroulante "etat"
		 */
		for(int i=0; i<Modele.getLesEtats().size();i++){
			Etat etat = Modele.getLesEtats().get(i);
			this.listeStatut.addItem(etat.getlibelle());
		}
		
		
		
		this.etatActuel.setPreferredSize(new Dimension(700,30));
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
    	
    	tabQte = new int[Modele.getLesFraisForfait(idVisiteur,mois).size()];
		for (int i=0 ; i<Modele.getLesFraisForfait(idVisiteur,mois).size() ;i++){
			
			FraisForfait fiche = Modele.getLesFraisForfait(idVisiteur,mois).get(i);
			this.donneesElFofaitises[i][0] = fiche.getLibelle();
			this.donneesElFofaitises[i][1] = fiche.getQte();
			
			tabQte[i] = fiche.getQte();
			//qteElFofaitises = Integer.parseInt(this.donneesElFofaitises[i][1].toString());
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
    	this.ElHorFofais = new Object[Modele.getLesFraisHorsForfait(idVisiteur,mois).size()][entetesHorsForfait.length];
    	
    	this.tblElHorFofais = new JTable(ElHorFofais,entetesHorsForfait);
  
		for (int i=0 ; i<Modele.getLesFraisHorsForfait(idVisiteur,mois).size() ;i++){
			
			FraisHorsForfait fhf = Modele.getLesFraisHorsForfait(idVisiteur,mois).get(i);
			this.ElHorFofais[i][0] = fhf.getLibelle();
			this.ElHorFofais[i][1] = fhf.getDate();
			this.ElHorFofais[i][2] = fhf.getMontant();
			
			libelleElHorFofais = this.ElHorFofais[i][0].toString();
			dateElHorFofais = this.ElHorFofais[i][1].toString();
			montantElHorFofais = Float.parseFloat(this.ElHorFofais[i][2].toString());
			
		}
		this.scrollElHorFofais = new JScrollPane(tblElHorFofais);
		this.scrollElHorFofais.setPreferredSize(new Dimension(730,50));
		/*-------------------------------------------------------------*/
		
		//boutton valider
		this.bntValider = new JButton("Valider");
		
		
		//ajout
		this.add(this.nomVmedicale);
		this.add(this.date);
		
		this.add(this.etatActuel);
		
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
		this.add(this.scrollElHorFofais);
		
		this.add(this.bntValider );
		
		/**
		 * Action boutton valider
		 */
		this.bntValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String statut = (String) listeStatut.getSelectedItem();
				JOptionPane.showConfirmDialog(null,"Confirmez-vous le nouveau statut : "+statut+" ?","Validation",JOptionPane.YES_NO_OPTION);
				
				System.out.println("---Eléments fofaitisés---");
				
					
					System.out.println("Forfait Etape-> "+tabQte[0]+"\nFrais Kilométrique -> "+tabQte[1]+"\nNuitée Hôtel -> "+tabQte[2]);
				
			
				System.out.println("---Descriptif des éléments hors forfait---");
				System.out.print("Libelle -> "+libelleElHorFofais+"\nDate -> "+dateElHorFofais+"\nMontant -> "+montantElHorFofais);
			}
		});
	}
}
