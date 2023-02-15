package Vue;

import Modele.Etat;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.html.MinimalHTMLWriter;
import java.awt.*;
import java.io.IOException;

public class miniAffichageClient extends JPanel {
    /* Constantes Fenetre*/
    public static final int LARGEUR = 290;                              	/* Largeur Fenetre */
    public static final int HAUTEUR = 290;                              	/* Hauteur Fenetre */

    /* Variables */
    private Etat etat;                                                  	/* Variable Etat que notre classe retranscrira en affichage */
    private Clients Clients;

    /* Constructeurs */
    public miniAffichageClient(Etat etat){
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));               	/* On définit les dimensions de notre JPanel */
        this.setEtat(etat);
    }

    /* Affichage */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.white);
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);
        try {
            if (this.etat.fileVide() == false) {
                boolean b = this.etat.gameOver(); this.etat.getClients().dessiner(g);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

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
