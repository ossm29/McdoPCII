package Vue;
import javax.swing.*;

import Modele.Etat;

import java.awt.*;

public class FenetrePrincipale extends JFrame{
	
	public static Affichage FP (Etat etat){

        /* Différentes zones d'affichages */
		Affichage affichage = new Affichage(etat);
        AffichageClient affichageClient = new AffichageClient(etat);
        AffichageCommande affichageCommande = new AffichageCommande(etat);
        AfffichageProduits afffichageProduits = new AfffichageProduits(etat);

        /* Declaration de notre Jframe */
		JFrame fenetre = new JFrame("McDo Game");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Organisation des zones d'affichage */

        // partie gauche
        JPanel jPanelGauche = new JPanel();
        jPanelGauche.setPreferredSize(new Dimension(1000,800));
        jPanelGauche.add(affichage, BorderLayout.NORTH);
        jPanelGauche.add(afffichageProduits, BorderLayout.SOUTH);
        fenetre.add(jPanelGauche, BorderLayout.WEST);

        // partie droite
        JPanel jpanelDroite = new JPanel();
        jpanelDroite.setPreferredSize(new Dimension(400,800));
        jpanelDroite.add(affichageClient, BorderLayout.NORTH);
        jpanelDroite.add(affichageCommande, BorderLayout.SOUTH);
        fenetre.add(jpanelDroite, BorderLayout.EAST);

        // Fin
        fenetre.pack();
        fenetre.setVisible(true);
        return affichage;
	}
}
