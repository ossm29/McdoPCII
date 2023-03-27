package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import Modele.Etat;
import Vue.AffichageIngredients;
import Vue.AffichageServeur;

/**
 *  Class ControlIngredientsValider implémente 'ActionListener'
 *  et gère le bouton de validation de la séléction d'ingrédients
 *
 * @version 1.0
 * */
public class ControlIngredientsValider implements ActionListener {

    /**
     *  Variables utiles au modèle MVC
     * */
    private Etat etat;
    private AffichageIngredients affichageIngredients;

    /**
     * Constructeur
     * Gère le timer de produits lancé par la validation de la
     * sélection d'ingrédients
     *
     * @param aI  de type 'AffichageIngredients'
     * @param etat  de type 'Etat'
     * */
    public ControlIngredientsValider(Etat etat, AffichageIngredients aI) {
        this.setEtat(etat);
        this.affichageIngredients = aI;
    }

    /**
     * Getter
     * Obtient et renvoie l'état dans notre classe ControlIngredientsValider
     *
     * @return etat  de type Etat
     * */
    public Etat getEtat() {
        return etat;
    }


    /**
     * Setter
     * Définit l'état de notre classe ControlIngredientsValider
     *
     * @param etat  de type Etat
     * */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    /**
     * Méthode qui lance un timer à côté du produit qu'on veut créer
     * (avec la sélection des ingrédients)
     *
     * @param e  de type "ActionEvent"
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
