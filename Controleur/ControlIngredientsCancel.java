package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modele.Etat;
import Vue.AffichageIngredients;

/**
 *  Class ControlIngredientsCancel implémente l'interface 'ActionListener'
 *  et est responsable de la désélection des ingrédients sélectionnés
 *  par l'utilisateur dans l'interface graphique.
 *  Elle gère le bouton d'annulation de la sélection d'ingrédients.
 *
 * @version 1.0
 * */
public class ControlIngredientsCancel implements ActionListener {

    /** Variables utiles au modèle MVC */
    // L'état courant de l'application
    private Etat etat;
    // L'affichage dans l'application
    private AffichageIngredients affichage;

    /**
     * Constructeur
     * Initialise les variables d'instance avec les variables choisies (en paramètre)
     *
     * @param etat                  l'état courant de l'application de type 'Etat'
     * @param affichageIngredients  l'affichage de la liste d'ingrédients de type 'AffichageIngredients'
     * */
    public ControlIngredientsCancel(Etat etat, AffichageIngredients affichageIngredients) {
        this.setEtat(etat);
        this.affichage = affichageIngredients;
    }


    /**
     * Getter
     * Obtient et renvoie l'état dans notre classe ControlIngredientsCancel
     *
     * @return etat  l'état de l'application de type 'Etat'
     * */
    public Etat getEtat() {
        return etat;
    }

    /**
     * Setter
     * Définit l'état de notre classe ControlIngredientsCancel
     *
     * @param etat  l'état de l'application de type 'Etat'
     * */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }


    /**
     * Cette méthode est appelée lorsqu'un événement est déclenché
     * par le bouton d'annulation de la sélection d'ingrédients.
     * Elle vide la liste des ingrédients sélectionnés dans l'objet 'Etat'
     * et met à jour l'affichage de la liste des ingrédients
     * à l'aide de la méthode "repaint".
     *
     * @param e  l'évènement déclanché par le bouton d'annulation
     *           de la sélection d'ingrédients de type 'ActionEvent'
     * */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!this.etat.gameOver()) {
            this.etat.videIngredients();
            this.affichage.repaint();
        }
    }
}
