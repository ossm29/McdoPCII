package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import Modele.Etat;
import Vue.AffichageIngredients;
import Vue.AffichageServeur;

/**
 *  Class ControlIngredientsValider implémente l'interface 'ActionListener'
 *  et gère le bouton de validation de la sélection d'ingrédients
 *
 * @version 1.0
 * */
public class ControlIngredientsValider implements ActionListener {

    /** Variables utiles au modèle MVC */

    // L'état du modèle
    private Etat etat;
    // Vue de l'affichage des ingrédients
    private AffichageIngredients affichageIngredients;


    /**
     * Constructeur
     * Initialise les attributs de la classe.
     * Gère le timer de produits lancé par la validation de la
     * sélection d'ingrédients
     *
     * @param etat  État du modèle de type 'Etat'
     * @param aI    Vue de l'affichage des ingrédients de type 'AffichageIngredients'
     * */
    public ControlIngredientsValider(Etat etat, AffichageIngredients aI) {
        this.setEtat(etat);
        this.affichageIngredients = aI;
    }

    /**
     * Getter
     * Obtient et renvoie l'état dans notre classe ControlIngredientsValider
     *
     * @return etat  l'état courant de l'application de type 'Etat'
     * */
    public Etat getEtat() {
        return etat;
    }

    /**
     * Setter
     * Définit l'état de notre classe ControlIngredientsValider
     *
     * @param etat  l'état courant de l'application de type 'Etat'
     * */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }


    /**
     * Implémentation de la méthode actionPerformed de l'interface ActionListener.
     * Cette méthode est appelée lorsque le bouton de validation des ingrédients est cliqué
     * Elle lance un timer à côté du produit que l'on veut créer avec la sélection des ingrédients.
     *
     * @param e  l'évènement déclenché de type "ActionEvent"
     * */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Selon le produit généré on lance un timer
        String produit = this.etat.production();
        switch (produit) {
            case "Burger":
                this.affichageIngredients.getAffichageServeur().lancerBurgerTimer();
                break;
            case "Frites" :
                this.affichageIngredients.getAffichageServeur().lancerFritesTimer();
                break;
            case "Pizza" :
                this.affichageIngredients.getAffichageServeur().lancerPizzaTimer();
                break;
            case "Wrap" :
                this.affichageIngredients.getAffichageServeur().lancerWrapTimer();
                break;
        }
        //this.affichageIngredients.repaint();
    }
}
