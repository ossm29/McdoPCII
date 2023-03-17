package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import Modele.Etat;
import Vue.AffichageIngredients;
import Vue.AffichageServeur;

/** Classe qui gère le bouton de validation de la séléction d'ingrédients*/
public class ControlIngredientsValider implements ActionListener {

    /* Variables  utiles au modèle MVC */
    private Etat etat;

    private AffichageIngredients affichageIngredients;

    public ControlIngredientsValider(Etat etat, AffichageIngredients aI) {
        this.setEtat(etat);
        this.affichageIngredients = aI;
    }

    /* Getter */
    public Etat getEtat() {
        return etat;
    }
    /* Setter */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Selon le produit généré on lance un timer
        String produit = this.etat.production();
        switch (produit) {
            case "burger":
                this.affichageIngredients.lancerBurgerTimer();
                break;
            case "frites" :
                this.affichageIngredients.lancerFritesTimer();
                break;
            case "pizza" :
                this.affichageIngredients.lancerPizzaTimer();
                break;
            case "wrap" :
                this.affichageIngredients.lancerWrapTimer();
                break;
        }
        this.affichageIngredients.repaint();
    }
}
