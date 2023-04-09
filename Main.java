import Controleur.Control;
import Modele.Etat;
import Vue.AffichagePrincipal;
import Vue.FenetrePrincipale;

import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
        Etat etat = new Etat();
        AffichagePrincipal affichagePrincipal = FenetrePrincipale.FP(etat);
        new Control(etat, affichagePrincipal);
    }
}