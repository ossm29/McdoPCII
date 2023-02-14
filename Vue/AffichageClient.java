package Vue;

import Modele.Etat;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AffichageClient extends JPanel {

    /* Constantes Fenetre*/
    public static final int LARGEUR = 400;                              	/* Largeur Fenetre */
    public static final int HAUTEUR = 350;                              	/* Hauteur Fenetre */

    /* Variables */
    private Etat etat;                                                  	/* Variable Etat que notre classe retranscrira en affichage */

    /* Constructeurs */
    public AffichageClient(Etat etat){
        this.setEtat(etat);
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));               	/* On définit les dimensions de notre JPanel */
    }

    /* Affichage */
    @Override
    public void paint(Graphics g) {
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);
        this.setBackground((new Color(255, 193, 59)));
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
