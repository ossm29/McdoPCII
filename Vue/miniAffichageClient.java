package Vue;

import Modele.Etat;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.html.MinimalHTMLWriter;
import java.awt.*;
import java.io.IOException;

/**
 * Classe miniAffichageClient qui hérite de la classe 'JPanel'
 * et sert à afficher l'état des clients.
 *
 * @version 1.0
 * */
public class miniAffichageClient extends JPanel {

    /** Constantes Fenêtre */

    /* Largeur Fenetre */
    public static final int LARGEUR = 290;
    /* Hauteur Fenetre */
    public static final int HAUTEUR = 290;

    /** Attributs */

    /* Variable Etat que notre classe retranscrira en affichage */
    private Etat etat;
    /* Variable qui représente les clients */
    private Clients Clients;

    /**
     * Constructeur
     * Définit les dimensions du JPanel et l'état de l'application.
     *
     * @param etat  l'état actuel à afficher de type 'Etat'
     * */
    public miniAffichageClient(Etat etat){
        // On définit les dimensions de notre JPanel
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));
        this.setEtat(etat);
    }

    /** Affichage */

    /**
     * Méthode utilisée pour afficher l'état des clients en dessinant
     * un bord noir sur un fond jaune.
     *
     * @param g  l'objet Graphics utilisé pour dessiner de type 'Graphics'
     * */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.WHITE);
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);
        try {
            if (!this.etat.fileVide()) {
                this.etat.getClients().dessiner(g);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * Getter
     * Méthode qui renvoie l'état actuel.
     *
     * @return l'état actuel de type 'Etat'
     */
    public Etat getEtat() {
        return etat;
    }

    /**
     * Setter
     * Méthode qui définit l'état pour l'affichage.
     *
     * @param etat l'état à afficher de type 'Etat'
     */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }

}
