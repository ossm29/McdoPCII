package Controleur;

import Modele.Etat;
import Vue.AffichageServeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  Class ControlPlateauCancel implémente l'interface 'ActionListener'
 *  et gère le bouton d'annulation du plateau de produits
 *
 * @version 1.0
 * */
public class ControlPlateauCancel implements ActionListener {

    /** Variables utiles au modèle MVC */

    // L'état du modèle
    private Etat etat;
    // L'affichage dans l'application
    private AffichageServeur affichage;


    /**
     * Constructeur
     * Initialise les variables d'instances nécessaires à la classe.
     * Gère la réinitialisation du plateau
     *
     * @param etat       l'état courant de l'application de type 'Etat'
     * @param affichage  l'affichage graphique de l'applciation de type 'AffichageServeur'
     * */
    public ControlPlateauCancel(Etat etat, AffichageServeur affichage) {
        this.etat = etat;
        this.affichage = affichage;
    }


    /**
     * La méthode actionPerformed est appelée lorsqu'un événement est déclenché.
     * Cette méthode réinitialise le plateau de produits de l'application.
     *
     * @param e  l'évènement déclenché de type 'ActionEvent'
     * */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!this.etat.gameOver()) {
            this.etat.cancelTray();
            this.affichage.repaint();
        }
    }
}
