package Controleur;

import Modele.Etat;
import Vue.AffichageIngredients;
import Vue.AffichageServeur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/** Classe qui gère le bouton d'annulation de la séléction d'ingrédients*/
public class ControlServeurAide implements ActionListener {

    /* Variables  utiles au modèle MVC */
    private Etat etat;

    private AffichageServeur affichage;

    public ControlServeurAide(Etat etat, AffichageServeur affichage) {
        this.setEtat(etat);
        this.affichage = affichage;
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
        this.affichage.revertDisplayHelp();
        this.affichage.repaint();
    }
}
