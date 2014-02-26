package Vue;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Modele.*;
@SuppressWarnings("serial")
public class V_suiviePaiement extends JPanel {

	
			private JLabel nomVmedicale;
			private JLabel date;
			private JLabel descriptifElement;
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
		    
		    private JButton rembourse ;
		    
		    private String idVisiteur;

		    private JLabel saut ;

		    /**
		     * Constructeur
		     * @param visiteur
		     * @param mois
		     */
		public V_suiviePaiement(final String visiteur, final String mois){
			
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
			
			
			this.saut = new JLabel();
			this.saut.setPreferredSize(new Dimension(730,20));
			this.rembourse = new JButton("Rembourser");
		
			
		
			
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
			 * Tableau 2
			 */
			this.add(this.descriptifElement);
			this.add(this.scrollElHorFofais);

			this.add(this.saut);
			
			this.add(this.rembourse);
			
			this.rembourse.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
						  
					int verifValidFiche = Modele.rembourserFiche(mois,idVisiteur);
					
					if(verifValidFiche==1){
						
						JOptionPane.showMessageDialog(null,"La fiche de frais du visiteur "+visiteur+" a bien été mise en paiement","Remboursement",JOptionPane.INFORMATION_MESSAGE);
						
						for(int i=0; i<Modele.getEtatActuel(idVisiteur, mois).size();i++){
							Etat etat = Modele.getEtatActuel(idVisiteur, mois).get(i);
							etatAct = etat.getlibelle();
						}
						
						/**
						 * Affiche l'etat actuelle de la fiche
						 */
						etatActuel.setText("Etat actuel : "+etatAct);
						/**
						 * Désactive le bouton rembourser
						 */
						rembourse.setEnabled(false);
					}
					
					else{
						
						JOptionPane.showMessageDialog(null,"La remboursement a échoué","Erreur",JOptionPane.ERROR_MESSAGE);
					}
				
				}
						
				});
				}
			}

		
			
	