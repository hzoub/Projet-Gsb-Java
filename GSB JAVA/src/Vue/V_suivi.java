package Vue;
import javax.swing.*;
import java.awt.*;
import javax.swing.JTable;
import Modele.Modele;
import Modele.Suivi;

/**
 * @author Aguiar F
 *@version 1.0
 */
//SUIvi
@SuppressWarnings("serial")
public class V_suivi extends JPanel{
	
	private Object[][] donnees;
    private JTable tab;
    private JScrollPane scroll;
    
    private JPanel suiviEtat ;
    private JLabel titre ;
    private Color bgColor;
   // private JComboBox <String> majEtat ; 
    
    
       
     public  V_suivi() {
    	
    	 /*
 		 * Couleur arriere-plan de la fenetre
 		 */
 		this.bgColor = Color.decode("#77aadd");
 		
 		this.suiviEtat = new JPanel();
 		this.suiviEtat.setPreferredSize(new Dimension(700,600));
 		this.suiviEtat.setBackground(bgColor);
    	
    	 this.titre = new JLabel(	"<html>"+
					"<h1 style=\"font-family:Comic Sans MS\">"+
					"Suivi fiche de frais</h1>",JLabel.CENTER);
    	 
       this.titre.setPreferredSize(new Dimension(700,30));


	    /**
	     * Creation de l'entête du tableau 
	     */
       String[]entetes = {"Id","Nom","Prenom","Date","Montant Valide","Etat"}; {
       
       //Définition de la taille du tableau
       this.donnees = new Object[Modele.getSuivi().size()][entetes.length];
       
       //Ajout des données dans le tableau JTable
       this.tab = new JTable(donnees, entetes);
      
       
            //Boucle qui parcours la fonction getSuivi() 
            for (int i=0 ; i<Modele.getSuivi().size();i++){
            		Suivi suivi = Modele.getSuivi().get(i);
                    
                    this.donnees[i][0] = suivi.getId();
                    this.donnees[i][1] = suivi.getNom();
                    this.donnees[i][2] = suivi.getPrenom();
                    this.donnees[i][3] = suivi.getDate();
                    this.donnees[i][4] = suivi.getMontantValide();
                    this.donnees[i][5] = suivi.getEtat();
            }
           
            this.scroll = new JScrollPane(tab);
            this.scroll.setPreferredSize(new Dimension(500, 350));
            
            this.suiviEtat.add(this.titre);
            this.suiviEtat.add(this.scroll);
            
            
            this.add(this.suiviEtat);

      }

     }

    
}
