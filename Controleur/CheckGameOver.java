package Controleur;

import Modele.Etat;
import Vue.AffichagePrincipal;
import Vue.AffichageServeur;

import javax.swing.*;

/**
 * Classe Thread qui vérifie si la partie est perdue.
 * Si c'est le cas, affiche un popup avec le score
 * */
public class CheckGameOver extends Thread {
    /* Attributs */
    private Etat etat;

    private AffichagePrincipal affichagePrincipal;

    private boolean running = true;

    /** Constructeur */

    public CheckGameOver(Etat etat, AffichagePrincipal affichage) {
        this.etat = etat;
        this.affichagePrincipal = affichage;
    }

    @Override
    public void run() {
        // Tant que timer du client n'est pas fini
        while(running) {
            try {
                // Attendre 100ms
                Thread.sleep(100);
                // Mettre a jour la colère et le timer du client
                if(this.etat.gameOver()) {
                    JOptionPane.showMessageDialog(affichagePrincipal, "GAME OVER ! \n SCORE :"+this.etat.getScore());
                    running = false;
                }

            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
