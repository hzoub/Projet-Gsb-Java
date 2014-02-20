package Vue;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JTable;

import Modele.Modele;
import Modele.Suivi;

/**
 * @author Aguiar F
 *@version 1.0
 */

@SuppressWarnings("serial")
public class V_suivi extends JPanel implements ActionListener {
	
	  private Object[][] donnees;
    private JTable tab;
    private JScrollPane scroll;
    
    private JPanel suiviEtat ;
    private JLabel titre ;
    private JComboBox <String> majEtat ; 
    
    
       
     public  V_suivi() {
    	
    	 this.titre = new JLabel(	"<html>"+
					"<h1 style=\"font-family:Comic Sans MS\">"+
					"Suivi fiche de frais de </h1>",JLabel.CENTER);
       this.titre.setPreferredSize(new Dimension(700,30));
       this.majEtat = new JComboBox<String>();

                /**
                 * Creation du tableau 
                 */
               
       String[]entetes = {"Date","IdVisiteur","Montant Valide","Etat"}; {
                	//Definir la taille du tableau
     //  this.donnees = new Object[Modele.getSuivi().size()][entetes.length];
       this.tab = new JTable(donnees, entetes);
      
       
                //Boucle qui parcours la BDD pour la fonction getSuivi(), et les ajoute dans le tableau 
            for (int i=0 ; i<Modele.getSuivi().size();i++){
            		Suivi suivi = Modele.getSuivi().get(i);
                    this.donnees[i][0] = suivi.getDate();
                    this.donnees[i][1] = suivi.getId();
                    this.donnees[i][2] = suivi.getNom();
                    this.donnees[i][3] = suivi.getPrenom();
                    this.donnees[i][4] = suivi.getMontantValide();
                    this.donnees[i][5] = suivi.getEtat();
            }
           
            this.scroll = new JScrollPane(tab);
            this.scroll.setPreferredSize(new Dimension(450, 300));
            this.add(scroll);
            this.add(this.suiviEtat);
            this.add(this.titre);
      }

     }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
