package Vue;
import javax.swing.JFrame;
import Modele.Etat;

public class FenetrePrincipale extends JFrame{
	
	public static Affichage FP (Etat etat){
		Affichage affichage = new Affichage(etat);
		JFrame fenetre = new JFrame("McDo Game");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.add(affichage);
        fenetre.pack();
        fenetre.setVisible(true);
        return affichage;
	}
}
