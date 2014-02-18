package Vue;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Modele.*;
/**
 * Affiche la fiche forfais et horsforfais du visiteur séléctionné
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
	    private String idEtat;
	    
	
	    private JLabel justificatif;
	    private int nbJustificatifs = -1;
	    private JTextField jtfJustif;
	    private JLabel saut;
	    /**
	     * Constructeur
	     * @param visiteur
	     * @param mois
	     */
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
		this.listeStatut.addItem("");
		/**
		 * Liste deroulante "etat"
		 */
		for(int i=0; i<Modele.getEtatVa().size();i++){
			
			Etat etat = Modele.getEtatVa().get(i);
			
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
    	this.ElHorFofais = new Object[Modele.getLesFraisHorsForfait(idVisiteur,mois).size()][entetesHorsForfait.length];
    	
    	this.tblElHorFofais = new JTable(ElHorFofais,entetesHorsForfait);
  
		for (int i=0 ; i<Modele.getLesFraisHorsForfait(idVisiteur,mois).size() ;i++){
			
			FraisHorsForfait fhf = Modele.getLesFraisHorsForfait(idVisiteur,mois).get(i);
			this.ElHorFofais[i][0] = fhf.getLibelle();
			this.ElHorFofais[i][1] = fhf.getDate();
			this.ElHorFofais[i][2] = fhf.getMontant();
		}

		this.scrollElHorFofais = new JScrollPane(tblElHorFofais);
		this.scrollElHorFofais.setPreferredSize(new Dimension(730,50));
		/*-------------------------------------------------------------*/
		this.justificatif = new JLabel("Nombre de justificatifs :");
		
		this.jtfJustif = new JTextField(2);
		this.saut = new JLabel();
		this.saut.setPreferredSize(new Dimension(730,20));
		//boutton valider
		this.bntValider = new JButton("Valider");
//		this.bntValider.setEnabled(false);
		
		
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
		
		this.add(this.justificatif);
		this.add(this.jtfJustif);
		this.add(this.saut);
		this.add(this.bntValider );
		
//		if(nbJustificatifs!=-1){
//			this.bntValider.setEnabled(true);
//		}else{
//			this.bntValider.setEnabled(false);
//		}
		
		/**
		 * Action boutton valider
		 */
		this.bntValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String statut = (String) listeStatut.getSelectedItem();
				int verif = JOptionPane.showConfirmDialog(null,"Confirmez-vous le nouveau statut : "+statut+" ?","Validation",JOptionPane.YES_NO_OPTION);
				
				nbJustificatifs = Integer.parseInt(jtfJustif.getText());

				if(verif==0){
					/**
					 * Récapitulatif avant la validation de la fiche
					 */
					int verifRecap = JOptionPane.showConfirmDialog(null,
							
							"---Eléments fofaitisés---"
							
							+"\nForfait Etape -> "+tableauElFofaitises.getValueAt(0,1)+
							"\nFrais Kilométrique -> "+tableauElFofaitises.getValueAt(1,1)+
							"\nNuitée Hôtel -> "+tableauElFofaitises.getValueAt(2,1)+
							"\nRepas Restaurant -> "+tableauElFofaitises.getValueAt(3,1)+
							
							"\n------------------------------"+
							"\nNombre de justificatifs -> "+nbJustificatifs+
							"\nMontant validée -> "+tblElHorFofais.getValueAt(0,2)+" €"+
							"\n------------------------------"+
							
							"\nSouhaitez-vous valider cette fiche ?",
							
							"Détails de la validation",JOptionPane.YES_NO_OPTION);
				
					
					for(int i=0; i<Modele.getIdEtat(statut).size(); i++){
						
						idEtat = Modele.getIdEtat(statut).get(i).getId();
					}
					if(verifRecap==0){
						
						int verifValidFiche = Modele.validerFicheFrais(idEtat,mois,idVisiteur,(float) tblElHorFofais.getValueAt(0,2),nbJustificatifs);
						
						if(verifValidFiche==1){
							
							JOptionPane.showMessageDialog(null,"La fiche est"+statut,"Validation",JOptionPane.INFORMATION_MESSAGE);
								
							for(int i=0; i<Modele.getEtatActuel(idVisiteur, mois).size();i++){
								Etat etat = Modele.getEtatActuel(idVisiteur, mois).get(i);
								etatAct = etat.getlibelle();
							}
							
							etatActuel.setText("Etat actuel : "+etatAct);
							bntValider.setEnabled(false);
							
						}
						else{
							
							JOptionPane.showMessageDialog(null,"Validation échouée","Erreur",JOptionPane.INFORMATION_MESSAGE);
						}
						
					}
					else{
						System.out.println("Validation de la fiche annulée");
					}
					
					
				}
			 }
			
		});
	}
}
