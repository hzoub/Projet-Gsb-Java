package Vue;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Modele.*;
/**
 * Affiche la fiche forfais et horsforfais du visiteur s�l�ctionn�
 * @author Zoubert hanem
 *
 */
@SuppressWarnings("serial")
public class V_validerFiche extends JPanel{
	
		private JLabel nomVmedicale;
		private JLabel date;
		private JLabel descriptifElement;
		private JLabel elementFofaitises;
		private JLabel etatActuel;
		private JPanel panStatut;
		private JPanel panLesForfais;
		
		
		private JLabel justificatif;
		private JLabel saut;
		    
		private String etatAct;
		private String idVisiteur;
		
		private Color bgColor;
		
		private Object[][] donneesElFofaitises;
	    private JTable tableauElFofaitises;
	    private JScrollPane scrollElFofaitises;
	    
	    private Object[][] ElHorFofais;
	    private JTable tblElHorFofais;
	    private JScrollPane scrollElHorFofais;
	    
	    private JButton bntValider;
	    
	    private int nbJustificatifs = 0;
	    
	    private JTextField jtfJustif;
	    
	    private ImageIcon iconSuccess ;
	    /**
	     * Constructeur V_etatFrais
	     * @param visiteur
	     * @param mois
	     */
	public V_validerFiche(final String visiteur, final String mois){
		
		/**
		 * 
		 */
		this.panStatut = new JPanel();
		this.panStatut.setPreferredSize(new Dimension(400,20));
		
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
		
		this.iconSuccess = new ImageIcon("images/success.png");
		
		/**
		 * Cette fonction recup�re l'idVisiteur en fonction de son nom
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
		//etat actuel de la fiche du visiteur s�l�ctionn�
		this.etatActuel = new JLabel("Etat actuel : "+this.etatAct);	
		
		
		this.etatActuel.setPreferredSize(new Dimension(700,30));
		this.elementFofaitises = new JLabel("El�ments fofaitis�s :");
		this.elementFofaitises.setPreferredSize(new Dimension(700,30));
		
		/*-----------------------------------------------------------*/
		/**
		 * TABLEAU El�ments fofaitis�s
		 * @author Zoubert Hanem
		 */
		//Entete
    	String[]entetesElFofaitises = {"Libell�","quantit�"};
    	//D�finir la taille du tableau
    	
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
		
		this.descriptifElement = new JLabel("Descriptif des �l�ments hors forfait ");
		this.descriptifElement.setPreferredSize(new Dimension(700,30));	
		
		/*------------------------------------------------------------*/
		/**
		 * TABLEAU Descriptif des �l�ments hors forfait
		 */
		//Entete
		String[]entetesHorsForfait = {"Libell�","Date","Montant"};
    	//D�finir la taille du tableau
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
		//this.bntValider.setEnabled(false);
		
	
		
		//ajout
		this.add(this.nomVmedicale);
		this.add(this.date);
		
		this.add(this.etatActuel);

		
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

		/**
		 * Action boutton valider
		 */
		this.bntValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				
				if(jtfJustif.getText().isEmpty()){
					
					JOptionPane.showMessageDialog(null,"Veuillez mettre le nombre de justificatifs","Erreur",JOptionPane.ERROR_MESSAGE);
				}
				
				else{
				
					nbJustificatifs = Integer.parseInt(jtfJustif.getText());
					System.out.println(nbJustificatifs);
	
					/**
					 * R�capitulatif avant la validation de la fiche
					 */
					int verifRecap = JOptionPane.showConfirmDialog(null,
							
							"Nombre de justificatifs -> "+nbJustificatifs+
							"\nMontant valid�e -> "+tblElHorFofais.getValueAt(0,2)+" �"+
							"\n------------------------------"+
							
							"\nSouhaitez-vous valider cette fiche ?",
							
							"D�tails de la validation",JOptionPane.YES_NO_OPTION);

					if(verifRecap==0){
						
						int verifValidFiche = Modele.validerFicheFrais(mois,idVisiteur,tblElHorFofais.getValueAt(0,2),nbJustificatifs);
						
						if(verifValidFiche==1){
							
							JOptionPane.showMessageDialog(null,"La fiche frais du visiteur "+visiteur+" a bien �t� valid�e","Validation",JOptionPane.INFORMATION_MESSAGE,iconSuccess);
								
							for(int i=0; i<Modele.getEtatActuel(idVisiteur, mois).size();i++){
								Etat etat = Modele.getEtatActuel(idVisiteur, mois).get(i);
								etatAct = etat.getlibelle();
							}
							
							etatActuel.setText("Etat actuel : "+etatAct);
							bntValider.setEnabled(false);
							
						}
						else{
							
							JOptionPane.showMessageDialog(null,"Validation �chou�e","Erreur",JOptionPane.ERROR_MESSAGE);
						}
						
					}
					else{
						System.out.println("Validation de la fiche annul�e");
					}
						
				}//fin else nbjustif
					
			 }//fin actionPerformed
			
		});
	}
}
