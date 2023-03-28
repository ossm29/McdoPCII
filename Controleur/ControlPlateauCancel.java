package Controleur;

import Modele.Etat;
import Vue.AffichageServeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  Class ControlPlateauCancel implémente 'ActionListener'
 *  et gère le bouton d'annulation du plateau de produits
 *
 * @version 1.0
 * */
public class ControlPlateauCancel implements ActionListener {

    /**
     * Variables utiles au modèle MVC
     * */
    private Etat etat;
    private AffichageServeur affichage;

    /**
     * Constructeur
     * Gère la réinitialisation du plateau
     *
     * @param affichage  de type 'AffichageServeur'
     * @param etat  de type 'Etat'
     * */
    public ControlPlateauCancel(Etat etat, AffichageServeur affichage) {
        this.etat = etat;
        this.affichage = affichage;
    }


    /**
     * Méthode qui permet la réinitialisation du plateau de produits
     *
     * @param e  de type 'ActionEvent'
     * */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.etat.cancelTray();
        this.affichage.repaint();
    }
}
