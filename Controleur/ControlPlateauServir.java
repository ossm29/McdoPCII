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


    /** Constructeur */
    public ControlPlateauServir(Etat etat, AffichageServeur affichage) {
        this.etat = etat;
        this.affichage = affichage;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.etat.serveTray();
        this.affichage.repaint();
    }
}
