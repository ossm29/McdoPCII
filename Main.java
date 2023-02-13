import Controleur.Control;
import Modele.Etat;
import Vue.Affichage;
import Vue.FenetrePrincipale;

public class Main {
    public static void main(String [] args){
        Etat etat = new Etat();
        Affichage affichage = FenetrePrincipale.FP(etat);
        new Control(etat, affichage);
    }
}