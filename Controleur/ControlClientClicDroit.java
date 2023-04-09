package Controleur;

import Modele.Etat;
import Vue.miniAffichageClient;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *  Class ControlClientClicDroit implémente les interfaces 'MouseListener' et 'KeyListener'
 *  pour gérer le changement et la visualisation du client suivant.
 *
 * @version 1.0
 * */
public class ControlClientClicDroit implements MouseListener, KeyListener {

    /** Variables utiles au modèle MVC */

    // L'état courant de l'application
    private Etat etat;
    // La fenêtre du client dans l'application
    private miniAffichageClient miniAffichageClient;

    /** Threads */


    /**
     * Constructeur
     * Gère le changement de clients vers le suivant ou precedent
     *
     * @param etat                  L'état actuel du système de gestion de clients de type 'Etat'.
     * @param miniAffichageClient   Le widget d'affichage du client actuel de type 'miniAffichageClient'.
     * */
    public ControlClientClicDroit(Etat etat, miniAffichageClient miniAffichageClient) {
        this.setEtat(etat);
        this.miniAffichageClient = miniAffichageClient;
    }

    /** Implémentations des méthodes de l'interface MouseListener */


    @Override
    public void mouseClicked(MouseEvent e) {}

    /**
     * La méthode mousePressed est appelée lorsqu'un bouton de la souris est appuyé.
     * Elle permet de changer au client suivant.
     *
     * @param e  l'évènement de la souris de type 'MouseEvent'
     * */
    @Override
    public void mousePressed(MouseEvent e) {
        if (!this.etat.gameOver()){
            if ( e.getButton() == MouseEvent.BUTTON1 ) {
                // Appel de la méthode clientsuivant pour changer au client suivant dans l'état actuel.
                this.etat.clientsuivant();
                // Actualisation de l'affichage
                this.miniAffichageClient.repaint();
                // Affichage du client actuel dans la console (pour le débogage).
                System.out.println(this.etat.getClient_en_cours());
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}


    /** Implémentations des méthodes de l'interface KeyListener */

    /**
     * Cette méthode est appelée lorsque l'utilisateur tape la touche "precedent" sur le clavier
     * Change le client courant
     *
     * @param e  l'évènement de la touche tapée de type KeyEvent
     * */
    @Override
    public void keyTyped(KeyEvent e) {
        if ( e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            // Appel de la méthode clientprecedent pour changer au client precedent dans l'état actuel.
            this.etat.clientprecedent();
            System.out.println(this.etat.getClient_en_cours());
            // Actualisation de l'affichage
            this.miniAffichageClient.repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    /**
     * Getter
     * Obtient et renvoie l'état dans notre classe ControlClientClicDroit
     *
     * @return etat  l'état courant de l'application de type 'Etat'
     * */
    public Etat getEtat() {
        return etat;
    }

    /**
     * Setter
     * Définit l'état de notre classe ControlClientClicDroit
     *
     * @param etat  l'état courant de l'application de type 'Etat'
     * */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}

