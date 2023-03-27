package Controleur;

import Modele.Etat;
import Vue.miniAffichageClient;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *  Class ControlClientClicGauche implémente 'MouseListener' et 'KeyListener'
 *  et définit les fonctions pour pouvoir changer et voir le client précédent
 *
 * @version 1.0
 * */
public class ControlClientClicGauche implements MouseListener , KeyListener {

    /**
     * Variables utiles au modèle MVC
     * */
    private Etat etat;
    private miniAffichageClient miniAffichageClient;


    /**
     * Constructeur
     * Gère le changement de clients vers celui qui précède
     *
     * @param miniAffichageClient  de type 'miniAffichageClient'
     * @param etat  de type 'Etat'
     * */
    public ControlClientClicGauche(Etat etat, miniAffichageClient miniAffichageClient) {
        this.setEtat(etat);
        this.miniAffichageClient = miniAffichageClient;
    }



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
     * Change au client précédent quand je presse ma souris
     *
     * @param e  de type MouseEvent
     * */
    @Override
    public void mousePressed(MouseEvent e) {
        if ( e.getButton() == MouseEvent.BUTTON1 ) {
            this.etat.clientprecedent();
            System.out.println(this.etat.getClient_en_cours());
            this.miniAffichageClient.repaint();
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


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * Getter
     * Obtient et renvoie l'état dans notre classe ControlClientClicGauche
     *
     * @return etat  de type Etat
     * */
    public Etat getEtat() {
        return etat;
    }

    /**
     * Setter
     * Définit l'état de notre classe ControlClientClicGauche
     *
     * @param etat  de type Etat
     * */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}

