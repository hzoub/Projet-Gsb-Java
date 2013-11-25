package Vue;

import javax.swing.*;

@SuppressWarnings("serial")
public class V_etatFrais extends JPanel{
	
		private JLabel visiteur;
		
	public V_etatFrais(){
		
		//+V_choixVisiteur.getChoixVisiteur()
		this.visiteur = new JLabel("Fiche frais de ");
		this.add(visiteur);
	}
}
