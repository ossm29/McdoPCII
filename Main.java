import Controleur.Control;
import Modele.Etat;
import Vue.AffichagePrincipale;
import Vue.AffichageProduits;
import Vue.AffichageServeur;
import Vue.FenetrePrincipale;

import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
        Etat etat = new Etat();
        AffichagePrincipale affichagePrincipale = FenetrePrincipale.FP(etat);
        new Control(etat, affichagePrincipale);
    }
}