package Modele;
import Vue.Affichage;

/* Ensemble des données qui caractériseront l'état de mon interface */
public class Etat {

    /* Attributs */
    int score;
    int client_insatisfait;
    
    /* Constructeur */
    public Etat(){
        this.score = 0;
        this.client_insatisfait = 0;
    }

    /* Getters */

    /* Setters */

    /* Méthodes */

    // Méthode qui met a jour le score
    public void updateScore(){
        this.score++;
    }
    // Méthode qui met a jour le nombre de client insatisfait du service
    public void updateClient_Insatisfait(){
        this.client_insatisfait++;
    }

    // Méthode qui renvoie true si le jeu est fini sinon false
    public boolean gameOver(){
        // Si le nombre de client insastisfait dépasse 3
        if ( this.client_insatisfait > 2){
            // Alors le jeu est fini
            return true;
        }
        // Sinon non
        return false;
    }
}