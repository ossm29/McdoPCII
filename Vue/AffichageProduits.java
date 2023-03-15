package Vue;

import Modele.Etat;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/** Classe qui gère l'affichage de la barre de produits en bas de l'écran */
public class AffichageProduits extends JPanel {
    public static final int LARGEUR = (int) (0.7*Etat.WIDTH);                              	   /* Largeur Fenetre */
    public static final int HAUTEUR = (int) (0.25*Etat.HEIGHT / 2);                              	/* Hauteur Fenetre */

    /* Variables */
    private Etat etat;                                                  	/* Variable Etat que notre classe retranscrira en affichage */

    /* Constructeurs */
    public AffichageProduits(Etat etat){
        this.setEtat(etat);
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));               	/* On définit les dimensions de notre JPanel */
    }

    /*Getter Etat*/
    public Etat getEtat() {
        return etat;
    }

    /*Setter etat*/
    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    /* Affichage */
    @Override
    public void paint(Graphics g) {

        super.paint(g);

        /* Arrière Plan et Bordures */
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);

    }
}
