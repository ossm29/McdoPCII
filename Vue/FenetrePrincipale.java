package Vue;
import javax.swing.*;

import Modele.Etat;

import java.io.IOException;
/** Classe qui correspond à la fenêtre principale dans laquelle on ajoute les affichages */
public class FenetrePrincipale extends JFrame{
	
	public static AffichagePrincipal FP (Etat etat) throws IOException {

        /* Différentes zones d'affichages */

		AffichageServeur affichageServeur = new AffichageServeur(etat);
        AffichageClient affichageClient = new AffichageClient(etat);
        AffichageIngredients affichageIngredients = new AffichageIngredients(etat, affichageServeur);
        AffichageProduits affichageProduits = new AffichageProduits(etat);
        AffichageCommande affichageCommande = new AffichageCommande(etat);

        /* Declaration de notre Jframe */
		JFrame fenetre = new JFrame("McDo Game");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Organisation des zones d'affichage */

        // partie gauche
        AffichageGauche affichageGauche = new AffichageGauche(affichageServeur, affichageProduits,affichageIngredients);

        // partie droite
        AffichageDroite affichageDroite = new AffichageDroite(affichageClient, affichageCommande);

        // partie principale
        AffichagePrincipal affichagePrincipal = new AffichagePrincipal(affichageGauche,affichageDroite);

        fenetre.add(affichagePrincipal);

        // Fin
        fenetre.pack();
        fenetre.setVisible(true);
        return affichagePrincipal;
	}
}
