package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modele.Etat;
import Vue.AffichageIngredients;

/**
 *  Class ControlIngredientsCancel implémente 'ActionListener'
 *  et génère le bouton d'annulation de la sélection d'ingrédients
 *
 * @version 1.0
 * */
public class ControlIngredientsCancel implements ActionListener {

    /**
     *  Variables utiles au modèle MVC
     * */
    private Etat etat;
    private AffichageIngredients affichage;

    /**
     * Constructeur
     * Gère la désélection des ingrédients
     *
     * @param affichageIngredients  de type 'AffichageIngredients'
     * @param etat  de type 'Etat'
     * */
    public ControlIngredientsCancel(Etat etat, AffichageIngredients affichageIngredients) {
        this.setEtat(etat);
        this.affichage = affichageIngredients;
    }

    /**
     * Getter
     * Obtient et renvoie l'état dans notre classe ControlIngredientsCancel
     *
     * @return etat  de type Etat
     * */
    public Etat getEtat() {
        return etat;
    }

    /**
     * Setter
     * Définit l'état de notre classe ControlIngredientsCancel
     *
     * @param etat  de type Etat
     * */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    /**
     * Méthode qui permet de désélectionner les ingrédients
     * et de mettre à jour l'interface avec la méthode "repaint"
     *
     * @param e  de type "ActionEvent"
     * */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.etat.videIngredients();
        this.affichage.repaint();
    }
}
