package Vue;

import Modele.Etat;

import javax.swing.*;
import java.awt.*;

public class AfffichageProduits extends JPanel {
    public static final int LARGEUR = 1000;                              	/* Largeur Fenetre */
    public static final int HAUTEUR = 200;                              	/* Hauteur Fenetre */

    /* Variables */
    private Etat etat;                                                  	/* Variable Etat que notre classe retranscrira en affichage */

    /* Constructeurs */
    public AfffichageProduits(Etat etat){
        this.setEtat(etat);
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));               	/* On définit les dimensions de notre JPanel */
    }

    /* Affichage */
    @Override
    public void paint(Graphics g) {
        this.setBackground(Color.green);
        super.paint(g);                                                     /* Effacer les précédents "dessin" */
    }

    /*Getter Etat*/
    public Etat getEtat() {
        return etat;
    }

    /*Setter etat*/
    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}
