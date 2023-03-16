package Controleur;

import Modele.Etat;
import Vue.Repaint;
import Vue.miniAffichageClient;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControlClientClicDroit implements MouseListener, KeyListener {

    /* Variables  utiles au modèle MVC */
    private Etat etat;
    private miniAffichageClient miniAffichageClient;

    /* Threads */
    private Repaint repaint;

    /* Constructeur */
    public ControlClientClicDroit(Etat etat, miniAffichageClient miniAffichageClient) {

        this.setEtat(etat);
        this.miniAffichageClient = miniAffichageClient;
    }

    /* Ce qui se passe quand je presse et relache (entre autre clique) sur les boutons de ma souris  */
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    /* Ce qui se passe quand je presse les boutons de ma souris  */
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

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

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
}

