package Vue;



import javax.swing.*;
import java.awt.*;

/**
 * Classe AffichageDroite hérite de la classe 'JPanel' de Swing.
 * Elle représente la partie droite de l'interface graphique de l'application.
 * Elle contient les affichages des clients et des commandes.
 *
 * @version 1.0
 * */
public class AffichageDroite extends JPanel {

    /** Attributs */

    /* Affichage des clients */
    private AffichageClient affichageClient;
    /* Affichage des commandes */
    private AffichageCommande affichageCommandes;

    /**
     * Constructeur
     * Initialise les affichages des clients et des commandes et les ajoute
     * à la vue.
     *
     * @param affichageClient     l'affichage des clients de type 'AffichageClient'
     * @param affichageCommandes  l'affichage des commandes de type 'AffichageCommande'
     * */
    public AffichageDroite(AffichageClient affichageClient, AffichageCommande affichageCommandes) {
        // Définition des affichages nécessaires
        this.affichageClient = affichageClient;
        this.affichageCommandes = affichageCommandes;
        // Initialisation des dimensions du JPanel
        this.setPreferredSize(new Dimension(400, 800));
        // Ajout de l'affichage des clients en haut à droite de l'écran
        this.add(this.affichageClient, BorderLayout.NORTH);
        // Ajout de l'affichage des commandes en bas à droite de l'écran
        this.add(this.affichageCommandes, BorderLayout.SOUTH);
    }

    /**
     * Getter
     * Méthode pour récupérer l'affichage des clients
     *
     * @return affichageClient  l'affichage des clients de type 'AffichageClient'
     * */
    public AffichageClient getAffichgeClient(){
        return this.affichageClient;
    }
}
