package Controleur;

import Modele.Etat;
import Vue.AffichageIngredients;
import Vue.AffichageServeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  Class ControlServeurAide implémente l'interface 'ActionListener'
 *  et gère l'annulation de la sélection d'ingrédients
 *
 * @version 1.0
 * */
public class ControlServeurAide implements ActionListener {

    /** Variables utiles au modèle MVC */

    // L'état du modèle
    private Etat etat;
    // L'affichage dans l'application
    private AffichageServeur affichage;


    /**
     * Constructeur
     * Gère l'annulation de la sélection d'ingrédients
     *
     * @param etat       l'état actuel du modèle de type 'Etat'
     * @param affichage  l'affichage graphique de l'application de type 'AffichageServeur'
     * */
    public ControlServeurAide(Etat etat, AffichageServeur affichage) {
        this.setEtat(etat);
        this.affichage = affichage;
    }


    /**
     * Getter
     * Obtient et renvoie l'état courant de l'application
     * dans notre classe ControlServeurAide
     *
     * @return etat  l'état courant de l'application de type 'Etat'
     * */
    public Etat getEtat() {
        return etat;
    }

    /**
     * Setter
     * Définit l'état de l'applicaton de notre classe ControlServeurAide
     *
     * @param etat  l'état courant de l'application de type 'Etat'
     * */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }


    /**
     * La méthode actionPerformed permet d'annuler la sélection d'ingrédients
     * et de mettre à jour l'affichage de l'application.
     *
     * @param e  l'évènement déclenché de type 'ActionEvent'
     **/
    @Override
    public void actionPerformed(ActionEvent e) {
        this.affichage.revertDisplayHelp();
        this.affichage.repaint();
    }
}
