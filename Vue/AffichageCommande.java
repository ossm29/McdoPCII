package Vue;

import Modele.Etat;

import javax.swing.*;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class AffichageCommande extends JPanel {
    public static final int LARGEUR = 400;                              	/* Largeur Fenetre */
    public static final int HAUTEUR = 450;                              	/* Hauteur Fenetre */

    /* Variables */
    private Etat etat;                                                  	/* Variable Etat que notre classe retranscrira en affichage */

    /* Constructeurs */
    public AffichageCommande(Etat etat){
        this.setEtat(etat);
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));               	/* On définit les dimensions de notre JPanel */
    }

    /* Affichage */
    @Override
    public void paint(Graphics g) {
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);
        this.setBackground((new Color(31, 62, 89)));
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
