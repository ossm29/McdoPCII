package Vue;
import javax.swing.*;

import Modele.Etat;

import java.io.IOException;

/**
 * Classe FenetrePrincipale hérite de la classe 'JPanel de Swing.
 * Elle représente la fenêtre principale de l'application
 * dans laquelle sont ajoutés les différents affichages
 *
 * @version 1.0
 * */
public class FenetrePrincipale extends JFrame{

    /**
     * Méthode qui crée les différents affichages et les ajoute
     * à la fenêtre principale.
     *
     * @param etat  l'état courant de l'application de type 'Etat'
     * @return l'affichage principal
     * @throws IOException en cas d'erreur lors de la lecture des fichiers
     *                     de données.
     * */
	public static AffichagePrincipal FP (Etat etat) throws IOException {

        /* Création des différents affichages */

		AffichageServeur affichageServeur = new AffichageServeur(etat);
        AffichageClient affichageClient = new AffichageClient(etat);
        AffichageIngredients affichageIngredients = new AffichageIngredients(etat, affichageServeur);
        AffichageCommande affichageCommande = new AffichageCommande(etat);

        /* Declaration de notre Jframe
           Création de la fenêtre principale.
        */
		JFrame fenetre = new JFrame("McDo Game");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Organisation des affichages dans la fenêtre principale */

        // partie gauche
        AffichageGauche affichageGauche = new AffichageGauche(affichageServeur, affichageIngredients);

        // partie droite
        AffichageDroite affichageDroite = new AffichageDroite(affichageClient, affichageCommande);

        // partie principale
        AffichagePrincipal affichagePrincipal = new AffichagePrincipal(affichageGauche,affichageDroite);

        fenetre.add(affichagePrincipal);

        // Affichage de la fenêtre principale
        fenetre.pack();
        fenetre.setVisible(true);
        return affichagePrincipal;
	}
}
