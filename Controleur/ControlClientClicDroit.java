package Controleur;

import Modele.Etat;
import Vue.Repaint;
import Vue.miniAffichageClient;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *  Class ControlClientClicDroit implémente 'MouseListener' et 'KeyListener'
 *  et définit les fonctions pour pouvoir changer et voir le client suivant
 *
 * @version 1.0
 * */
public class ControlClientClicDroit implements MouseListener, KeyListener {

    /**
     * Variables utiles au modèle MVC
     * */
    private Etat etat;
    private miniAffichageClient miniAffichageClient;

    /**
     *  Threads
     * */
    private Repaint repaint;

    /**
     * Constructeur
     * Gère le changement de clients vers le suivant
     *
     * @param miniAffichageClient  de type 'miniAffichageClient'
     * @param etat  de type 'Etat'
     * */
    public ControlClientClicDroit(Etat etat, miniAffichageClient miniAffichageClient) {

        this.setEtat(etat);
        this.miniAffichageClient = miniAffichageClient;
    }

    /**
     * Implémentations de MouseListener
     * */

    /**
     * Change l'affichage quand je presse et relache (entre autre clique)
     * sur les boutons de ma souris
     *
     * @param e  de type MouseEvent
     * */
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    /**
     * Change au client suivant quand je presse ma souris
     *
     * @param e  de type MouseEvent
     * */
    @Override
    public void mousePressed(MouseEvent e) {
    	if ( e.getButton() == MouseEvent.BUTTON1 ) {
            this.etat.clientsuivant();
            this.miniAffichageClient.repaint();
            System.out.println(this.etat.getClient_en_cours());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * Change de client quand je tape la clé flèche "suivant"
     *
     * @param e  de type KeyEvent
     * */
    @Override
    public void keyTyped(KeyEvent e) {
        if ( e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            this.etat.clientprecedent();
            System.out.println(this.etat.getClient_en_cours());
            this.miniAffichageClient.repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * Getter
     * Obtient et renvoie l'état dans notre classe ControlClientClicDroit
     *
     * @return etat  de type Etat
     * */
    public Etat getEtat() {
        return etat;
    }

    /**
     * Setter
     * Définit l'état de notre classe ControlClientClicDroit
     *
     * @param etat  de type Etat
     * */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}

