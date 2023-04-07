package Vue;

import Modele.Etat;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * Classe AffichageProduits hérite de la classe 'JPanel' de Swing.
 * Elle gère l'affichage de la barre des produits en bas de l'écran
 * extraits du fichier "ressources.produits".
 *
 * @version 1.0
 * */
public class AffichageProduits extends JPanel {

    /** Constantes fenêtre */

    /* Largeur Fenêtre */
    public static final int LARGEUR = 994;
    /* Hauteur Fenetre */
    public static final int HAUTEUR = 400;

    /** Variables */

    /* Variable Etat que notre classe retranscrira en affichage */
    private Etat etat;

    /**
     * Constructeur
     * Initialise les dimensions du JPanel et définit l'état de l'application.
     *
     * @param etat  l'état à définir de type 'Etat'
     * */
    public AffichageProduits(Etat etat){
        this.setEtat(etat);
        // On définit les dimensions de notre JPanel
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));
    }

    /** Getter
     * Renvoie l'état actuel de l'application
     *
     * @return etat l'état actuel de type 'Etat'
     * */
    public Etat getEtat() {
        return etat;
    }

    /**
     * Setter
     * Définit l'état de l'application.
     *
     * @param etat l'état à définir de type 'Etat'
     * */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    /** Affichage */

    /**
     * Méthode qui gère l'affichage de la barre de produits.
     *
     * @param g  l'objet graphique de l'interface de type 'Graphics'
     * */
    @Override
    public void paint(Graphics g) {

        super.paint(g);

        /* Arrière Plan et Bordures */
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);

    }
}
