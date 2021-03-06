package Vue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import Modele.Visiteur;
/**
 * Affiche les visiteurs ayant une fiche dont l'id de l'etat est <b>"VA"</b> 
 * c'est � dire <b>"Valid�e et mise en paiement"</b> et le mois dont la fiche
 * a �t� valid�e dans une liste d�roulante
 * @author Aguiar
 *
 */
@SuppressWarnings("serial")
public class V_choixSuivi extends JPanel implements ActionListener {
	
	private JLabel lblTitre;
	private JLabel lblChoixVisiteur;
	private JLabel lblChoixMois;
	private JLabel msg;// s'il n y a aucune fiche
	private JLabel espace;
	
	private JComboBox<String>choixMois;
	private JComboBox<String>choixVisiteur;
	
	private JPanel panelForm;
	private Color bgColor;
	
	private  static JButton btnValider;
	private static JButton btnSuiviComplet ;

	

	/**
	 * Constructeur V_ficheFrais
	 * @param visiteur 
	 */
	public V_choixSuivi(ArrayList<Visiteur> infosFicheVA){
		
		//COULEUR ARRIERE-PLAN DU PANEL
		this.bgColor = Color.decode("#77aadd");
		this.setBackground(bgColor);
		
		//PANEL POUR LE FORMUAIRE
		this.panelForm = new JPanel();
		this.panelForm.setPreferredSize(new Dimension(250,160));
		this.panelForm.setBorder(new TitledBorder("Choix visiteur"));
		this.panelForm.setBackground(bgColor);
		
		//TITRE
		this.lblTitre = new JLabel("<html>"+
				"<h1 style=\"font-family:Comic Sans MS\">"+
					"Choix du visiteur ( Suivi ) </h1>",JLabel.CENTER);
		this.lblTitre.setPreferredSize(new Dimension(800,100));
		
		//LABEL Visiteur
		this.lblChoixVisiteur = new JLabel("Visiteur :");
		this.lblChoixVisiteur.setPreferredSize(new Dimension(70,10));
		
		
		//Liste deroulante Visiteur
		this.choixVisiteur = new JComboBox<String>();
		
		
		
		for(int i=0; i<infosFicheVA.size();i++){
			Visiteur visiteur = infosFicheVA.get(i);

			this.choixVisiteur.addItem(visiteur.getNom());
		}
		this.choixVisiteur.setPreferredSize(new Dimension(150,20));
		
		//LABEL mois
		this.lblChoixMois = new JLabel("Mois :");
		this.lblChoixMois.setPreferredSize(new Dimension(70,10));
		
		//Liste deroulante mois
		this.choixMois = new JComboBox<String>();
		this.choixMois.setPreferredSize(new Dimension(150,20));
		

		//Affiche le mois de la fiche du visiteur selection� dans une liste d�roulante
		for(int i=0; i<infosFicheVA.size();i++){
			Visiteur visiteur = infosFicheVA.get(i);
			
			this.choixMois.addItem(visiteur.getMois());
		}
		
	
		
		//Espace entre les labels est les bouttons
		this.espace = new JLabel();
		this.espace.setPreferredSize(new Dimension(220,15));
		
		//BOUTTON VALIDER
		btnValider = new JButton("Valider");
		btnSuiviComplet = new JButton("Suivi de tous les visiteurs");
		
		//Ce message va s'afficher que quand il n y' aucune fiche
		this.msg = new JLabel("Il n y'a aucune fiche a rembourser",JLabel.CENTER);
		this.msg.setPreferredSize(new Dimension(700,50));
		
		//AJOUT DU TITRE DANS LE PANEL
		this.add(lblTitre);
		
		if(this.choixVisiteur.getSelectedItem()==null){
			btnValider.setEnabled(false);
			this.add(this.msg);
		}
		
		//AJOUT DES COMPOSANT DANS LE FORMAULAIRE "panelForm"
		this.panelForm.add(lblChoixVisiteur);
		this.panelForm.add(choixVisiteur);
		this.panelForm.add(lblChoixMois);
		this.panelForm.add(choixMois);
		
		this.panelForm.add(espace);
		
		this.panelForm.add(btnValider);
		this.panelForm.add(btnSuiviComplet);
		
		//AJOUT DU FORMULAIRE DANS LE PANEL
		this.add(panelForm);
	}
	
		/**
		 * @return le visiteur
		 */
		public String getChoixVisiteur() {
			String visiteur = choixVisiteur.getSelectedItem().toString();
			return visiteur;
		}
	
		public String  getChoixMois() {
			String mois =  (String) choixMois.getSelectedItem();
			return mois;
		}
		
		/**
		 * @return la liste deroulante visiteur
		 */
		public JComboBox<String> getLstVisiteur() {
			return choixVisiteur;
		}
		
		/**
		 * @return la liste deroulante mois
		 */
		public JComboBox<String>  getLstMois() {
			return choixMois;
		}


		/**
		 * @return le boutton "Valider"
		 */
		public static JButton getBtnValider() {
			return btnValider;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	
		public static JButton getBtnSuiviComplet(){
			return btnSuiviComplet ;
			
		}

		

		
}
