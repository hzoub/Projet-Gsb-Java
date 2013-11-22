package Vue;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
/**
 * 
 * @author zoubert hanem
 *@version 1.0
 */
@SuppressWarnings("serial")
public class V_login extends JFrame implements ActionListener {
		
		private JLabel imgLogo;
		private JLabel lblTitre;
		private JLabel lblId;
		private JLabel lblMdp;
		private static JTextField jtfId;
		private JPasswordField jtfMdp;
	
		private JButton btnValider;
		private JButton bntEffacer;
		private Color bgColor;
		private JPanel panelForm;
		private JPanel formulaire;
		private JLabel espace;
		private Image icone ;
		private String nomVisiteur;
		/**
		 * Constructeur
		 */
		public V_login(){
			
		    //TITRE DE LA FENETRE
		    this.setTitle("Laboratoire Galaxy-Swiss Bourdin : Gestion des Fiches visiteurs");
		    //TAILLE DE LA FENETRE
		    this.setSize(800, 600);
		    // LA FENETRE DOIT SE FERMER QUAND ON CLIQUE SUR LA CROIX ROUGE
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    //CENTRE LA FENETRE
		    this.setLocationRelativeTo(null);
		    //EMPECHER LA REMDIMENSION DE LA FENTRE
		    this.setResizable(false);
		    
		    /**
			 * ICONE DE l'application
			 */
			this.icone = Toolkit.getDefaultToolkit().getImage("images/logo.png");
			this.setIconImage(icone);
			
			//logo
			this.imgLogo = new JLabel(new ImageIcon("images/logo.png"));
		

			//titre
			this.lblTitre = new JLabel("<html>"+
										"<h1 style=\"font-family:Comic Sans MS\">"+
					 						"Connexion comptable"+
					 					"</h1>",JLabel.CENTER);
			
			this.lblTitre.setPreferredSize(new Dimension(800,100));
			
			//formulaire
			this.panelForm = new JPanel();
			this.panelForm.setPreferredSize(new Dimension(300,140));
			this.panelForm.setBorder(new TitledBorder("Connexion"));
			
			this.formulaire = new JPanel();
	
			//label identifiant
			this.lblId = new JLabel("Identifiant :");
			this.lblId.setPreferredSize(new Dimension(80,10));
			this.jtfId = new JTextField(15);
			
			//label mot de passe
			this.lblMdp = new JLabel("Mot de passe :");
			this.jtfMdp = new JPasswordField(15);
			
			//Espace entre les labels est les bouttons
			this.espace = new JLabel();
			this.espace.setPreferredSize(new Dimension(220,15));
			
			//Bouttons
			this.btnValider = new JButton("Valider");
			this.bntEffacer = new JButton("Effacer");
			
			//ajout action boutton valider
			this.btnValider.addActionListener(this);
			
			//AJOUT COULEUR DE FOND DES PANELS
			this.bgColor = Color.decode("#77aadd");
			this.setBackground(bgColor);
			this.formulaire.setBackground(bgColor);
			this.panelForm.setBackground(bgColor);
			
			//AJOUT DES COMPPOSANTS DANS LA FENETRE
			this.formulaire.add(this.imgLogo);
			this.formulaire.add(this.lblTitre);
			this.formulaire.add(this.panelForm);
			
			//AJOUT DES COMPOSANTS DANS LE FORMULAIRE
			this.panelForm.add(this.lblId);
			this.panelForm.add(this.jtfId);
			this.panelForm.add(this.lblMdp);
			this.panelForm.add(this.jtfMdp);
			this.panelForm.add(this.espace);
			this.panelForm.add(this.btnValider);
			this.panelForm.add(this.bntEffacer);
			
			
			
			//AJOUT DU FORMULAIRE DANS LE PANEL
			this.getContentPane().add(this.formulaire);
			this.setVisible(true);
		}

		/**
		 * @return l'identifiant du visiteur
		 */
		public static JTextField getJtfId() {
			return jtfId;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			this.dispose();
			V_accueil v = new V_accueil();
			v.setVisible(true);
		}
}
