package Vue;

import Modele.Etat;

import javax.swing.*;
import java.awt.*;

/**
 * Classe AffichagePrincipal qui hérite de la classe 'JPanel' de Swing.
 * Représente l'affichage principal de l'application avec les sous-affichages
 * gauches et droites.
 *
 * @version 1.0
 * */
public class AffichagePrincipal extends JPanel {

    /** Attributs */

    /* L'affichage gauche de l'application */
    private AffichageGauche affichageGauche;
    /* L'affichage droite de l'application */
    private AffichageDroite affichageDroite;

    /**
     * Constructeur
     * Gére l'affichage gauche et droite des éléments nécessaires de chacun.
     *
     * @param affichageGauche  l'affichage de gauche dans l'application de type 'AffichageGauche'
     * @param affichageDroite  l'affichage de droite dans l'application de type 'AffichageDroite'
     * */
    public AffichagePrincipal(AffichageGauche affichageGauche, AffichageDroite affichageDroite){
        // Définition des affichages
        this.affichageGauche = affichageGauche;
        this.affichageDroite = affichageDroite;
        // Définition des dimensions du JPane;
        this.setPreferredSize(new Dimension(1420, 810));
        // Ajout de l'affichage gauche à la droite du JPanel
        this.add(this.affichageGauche, BorderLayout.EAST);
        // Ajout de l'affichage droit à la gauche du JPanel
        this.add(this.affichageDroite, BorderLayout.WEST);
    }

    /** Getters */

    /**
     * Récupère et retourne l'affichage gauche de l'application.
     *
     * @return l'affichage gauche de l'application de type 'AffichageGauche'
     * */
    public AffichageGauche getAffichageGauche(){
        return this.affichageGauche;
    }
    /**
     * Récupère et retourne l'affiche droite de l'application.
     *
     * @return l'affichage droit de l'application de type 'AffichageDroite'
     * */
    public AffichageDroite getAffichageDroite(){ return this.affichageDroite;  }

    /**
     * Méthode permettant de peindre le composant avec une couleur de fond blanche.
     *
     * @param g  l'objet graphique de l'interface de type 'Graphics'
     * */
    @Override
    public void paintComponent(Graphics g) {
        setBackground(Color.WHITE);
        super.paintComponent(g);
    }
}
