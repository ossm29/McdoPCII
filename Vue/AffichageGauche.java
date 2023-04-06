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
    private AffichageProduits affichageProduits;
    /* L'affichage des ingrédients */
    private AffichageIngredients affichageIngredients;


    /**
     * Constructeur
     * Initialise les affichages nécessaires et les ajoute
     * à la vue.
     *
     * @param affichage            l'affichage du serveur de type 'AffichageServeur'
     * @param affichageProduits    l'affichage des produits de type 'AffichageProduits'
     * @param affichageIngredients l'affichage des ingrédients de type 'AffichageIngredients'
     * */
    public AffichageGauche(AffichageServeur affichage, AffichageProduits affichageProduits, AffichageIngredients affichageIngredients){
        // Définition des affichages
        this.affichageServeur = affichage;
        this.affichageProduits = affichageProduits;
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
     * Retourne l'affichage des produits de l'application.
     *
     * @return affichageProduits  l'affichage des produits de type 'AffichageProduits'
     * */
    public AffichageProduits getAffichageProduits() {
        return affichageProduits;
    }

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
