package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modele.Etat;
import Vue.AffichageIngredients;

/** Classe qui gère le bouton d'annulation de la séléction d'ingrédients*/
public class ControlIngredientsValider implements ActionListener {

    /* Variables  utiles au modèle MVC */
    private Etat etat;

    private AffichageIngredients affichage;

    public ControlIngredientsValider(Etat etat, AffichageIngredients affichageIngredients) {
        this.setEtat(etat);
        this.affichage = affichageIngredients;
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
        this.etat.production();
        this.affichage.repaint();
    }
}
