package Controleur;
import java.awt.event.*;
import Modele.Etat;
import Vue.*;

/* Ma classe Control qui fera le lien entre ma Classe Etat et ma Classe Affichage suite à toute interaction */
public class Control implements MouseListener{

    /* Variables  utiles au modèle MVC */
    private Etat etat;                              
    private AffichagePrincipale affichagePrincipale;

    /* Threads */
    private Repaint repaint;
    
    /* Constructeur */
    public Control(Etat etat, AffichagePrincipale affichagePrincipale) {

        this.setEtat(etat);
        this.affichagePrincipale = affichagePrincipale;

        
        /* On initialise nos threads */
        //this.repaint = new Repaint(this.affichagePrincipale);
        
        /*On lance les threads */
        //this.repaint.start();
        
        this.affichagePrincipale.addMouseListener(this);
    }

    /* Ce qui se passe quand je presse et relache (entre autre clique) sur les boutons de ma souris  */
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    
    /* Ce qui se passe quand je presse les boutons de ma souris  */
    @Override
    public void mousePressed(MouseEvent e) {
    	/*if ( e.getButton() == MouseEvent.BUTTON1 ) {
            this.etat.jump();                           
            this.affichage.repaint();                  
        }*/
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
}