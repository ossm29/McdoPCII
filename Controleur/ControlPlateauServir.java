package Controleur;

import Modele.Etat;
import Vue.AffichageServeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  Class ControlPlateauServir implémente 'ActionListener'
 *  et gère le bouton de service du plateau de produits
 *
 * @version 1.0
 * */
public class ControlPlateauServir implements ActionListener {

    /**
     * Variables utiles au modèle MVC
     * */
    private Etat etat;
    private AffichageServeur affichage;


    /**
     * Constructeur
     * Gère le bouton de service du plateau
     *
     * @param affichage  de type 'AffichageServeur'
     * @param etat  de type 'Etat'
     * */
    public ControlPlateauServir(Etat etat, AffichageServeur affichage) {
        this.etat = etat;
        this.affichage = affichage;
    }

    /**
     * Méthode qui permet de servir le plateau et
     * update l'affichage
     *
     * @param e  de type 'ActionEvent'
     * */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.etat.serveTray();
        this.affichage.repaint();
    }
}
