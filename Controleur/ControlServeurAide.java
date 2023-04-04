package Controleur;

import Modele.Etat;
import Vue.AffichageIngredients;
import Vue.AffichageServeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  Class ControlServeurAide implémente 'ActionListener'
 *  et gère l'annulation de la sélection d'ingrédients
 *
 * @version 1.0
 * */
public class ControlServeurAide implements ActionListener {

    /**
     *  Variables utiles au modèle MVC
     **/
    private Etat etat;

    private AffichageServeur affichage;

    /**
     * Constructeur
     * Gère l'annulation de la sélectino d'ingrédients
     *
     * @param affichage  de type 'AffichageServeur'
     * @param etat  de type 'Etat'
     * */
    public ControlServeurAide(Etat etat, AffichageServeur affichage) {
        this.setEtat(etat);
        this.affichage = affichage;
    }

    /**
     * Getter
     * Obtient et renvoie l'état dans notre classe ControlServeurAide
     *
     * @return etat  de type Etat
     * */
    public Etat getEtat() {
        return etat;
    }

    /**
     * Setter
     * Définit l'état de notre classe ControlServeurAide
     *
     * @param etat  de type Etat
     * */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    /**
     * Méthode qui permet d'annuler une sélection et de
     * update l'affichage
     *
     * @param e  de type 'ActionEvent'
     **/
    @Override
    public void actionPerformed(ActionEvent e) {
        this.affichage.revertDisplayHelp();
        this.affichage.repaint();
    }
}
