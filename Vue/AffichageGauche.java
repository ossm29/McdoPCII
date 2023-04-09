package Vue;

import javax.swing.*;
import java.awt.*;

/**
 * Classe AffichageGauche hérite de la classe 'JPanel' de Swing.
 * Elle représente la partie gauche de l'interface graphique de l'application.
 * Elle contient les affichages du serveur, des produits et des ingrédients.
 *
 * */
public class AffichageGauche extends JPanel{

    /** Attributs */

    /* L'affichage du serveur */
    private AffichageServeur affichageServeur;
    /* L'affichage des produits */
    /* L'affichage des ingrédients */
    private AffichageIngredients affichageIngredients;


    /**
     * Constructeur
     * Initialise les affichages nécessaires et les ajoute
     * à la vue.
     *
     * @param affichage            l'affichage du serveur de type 'AffichageServeur'
     * @param affichageIngredients l'affichage des ingrédients de type 'AffichageIngredients'
     * */
    public AffichageGauche(AffichageServeur affichage, AffichageIngredients affichageIngredients){
        // Définition des affichages
        this.affichageServeur = affichage;
        this.affichageIngredients = affichageIngredients;
        // Définition des dimensions du JPanel
        this.setPreferredSize(new Dimension(1000,850));
        // Ajout de l'affichage du serveur en haut à gauche de l'écran
        this.add(this.affichageServeur, BorderLayout.NORTH);
        // Ajout de l'affichage des ingrédients en bas à gauche de l'écran
        this.add(this.affichageIngredients, BorderLayout.SOUTH);
    }

    /** Getter */

    /**
     * Retourne l'affichage du serveur de l'application.
     *
     * @return affichageServeur  l'affichage du serveur de type 'AffichageServeur'
     * */
    public AffichageServeur getAffichageServeur(){
        return affichageServeur;
    }

    // Affichage
/*    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }*/
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
