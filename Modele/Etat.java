package Modele;
import Vue.Affichage;

/* Ensemble des données qui caractériseront l'état de mon interface */
public class Etat {

    /*Variable */
    private int hauteur;
    private int limitehauteur = 800;
    
    /* Constructeur */
    public Etat(){
      this.hauteur = 250;								
    }

    /* Getters */

    /* Renvoie la hauteur à laquelle se trouve mon cercle */
    public int getHauteur(){
        return this.hauteur;
    }

    /* Methode */
    
}