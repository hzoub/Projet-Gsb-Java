package Vue;

import javax.swing.*;

@SuppressWarnings("serial")
public class V_etatFrais extends JPanel{
	
		private JLabel visiteur;
		private V_choixVisiteur choix;
		
	public V_etatFrais(){
		
		this.choix = new V_choixVisiteur();
		this.visiteur = new JLabel("Fiche frais de "+choix.getChoixVisiteur());
		this.add(visiteur);
	}
}
