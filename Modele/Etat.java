package Modele;
import Vue.Clients;
import Vue.miniAffichageClient;

import java.util.ArrayList;

/* Ensemble des données qui caractériseront l'état de mon interface */
public class Etat {

    /* Attributs */
    private int score;                          /* Score Joueur */
    private int client_insatisfait;             /* Nb de client insatisfait */

    private Clients clients;                    /* La liste de tous les clients dans le magasin */
    private int client_en_cours;                /* index ( et NON PAS ID )  du client
                                                qui se fait traiter sa commande actuellement */
    
    /* Constructeur */
    public Etat(){
        this.score = 0;
        this.client_insatisfait = 0;
        this.clients = new Clients(new miniAffichageClient(this));
    }

    /* Getters */
    public int getClient_en_cours(){
        return this.client_en_cours;
    }
    public Clients getClients(){
        return this.clients;
    }
    /* Setters */

    /* Méthodes */

    // Méthode qui met a jour le score
    public void updateScore(){
        this.score++;
    }

    // Méthode qui met a jour le nombre de client insatisfait du service
    public void updateClientInsatisfait(){
        this.client_insatisfait++;
    }

    // Méthode qui update l'index du client en cours en passant au suivant
    public void clientsuivant(){
        if ( this.client_en_cours + 1 < this.clients.getListeClients().size()){
            this.client_en_cours++;
        }
    }

    // Méthode qui update l'index du client en cours en passant au précédent
    public void clientprecedent(){
        if ( this.client_en_cours -1 > -1){
            this.client_en_cours --;
        }
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