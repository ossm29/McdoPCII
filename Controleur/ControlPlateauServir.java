package Controleur;

import Modele.Etat;
import Vue.AffichageServeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  Class ControlPlateauServir implémente l'interface 'ActionListener'
 *  et gère le bouton de service du plateau de produits
 *
 * @version 1.0
 * */
public class ControlPlateauServir implements ActionListener {

    /** Variables utiles au modèle MVC */

    // L'état du modèle
    private Etat etat;
    // L'affichage dans l'application
    private AffichageServeur affichage;


    /**
     * Constructeur
     * Initialise les variables d'instances nécessaires à la classe.
     * Gère le bouton de service du plateau
     *
     * @param etat       l'état du modèle de type 'Etat'
     * @param affichage  l'affichage de l'application de type 'AffichageServeur'
     * */
    public ControlPlateauServir(Etat etat, AffichageServeur affichage) {
        this.etat = etat;
        this.affichage = affichage;
    }


    /**
     * Cette méthode permet de servir le plateau et met à jour l'affichage.
     *
     * @param e  l'évènement déclenché de type 'ActionEvent'
     * */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.etat.serveTray();
        this.affichage.repaint();
    }
}
