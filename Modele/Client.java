package Modele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Client extends Thread{

    /* Attributs */
    private int identifiant;            /* Identifiant du Client */
    private double timer;                  /* Le temps qu'il reste avant que le patient ne décide de s'en aller */
    private int anger;                  /* L'indicateur de colère du Client compris entre 0 et 5 inclu*/
    private boolean traitementcommande; /* La valeur traitementCommande indique si la commande a été traité ou pas */
    private int etat;                   /* L'état du client - utile pour l'affichage comme les oiseaux dans flappy-*/
    private Commande commande;

    /* Constructeur */
    public Client(){
        this.setTraitementcommande();
        this.setAnger();
        this.setIdentifiant();
        this.setTimer();
        this.setCommande();
        this.start();
    }


    /* Getters */
    public int getIdentifiant(){
        return this.identifiant;
    }
    public double getTimer(){
        return this.timer;
    }
    public int getAnger(){
        return this.anger;
    }
    public Commande getCommande(){
        return this.commande;
    }
    public boolean getTraitementCommande(){
        return this.traitementcommande;
    }
    public int getEtat(){
        return this.etat;
    }


    /* Setters */
    public void setAnger(){
        Random random = new Random();
        this.anger = random.nextInt(6);
    }

    public void setTraitementcommande(){
        this.traitementcommande = false;
    }

    public void setIdentifiant(){
        Random random = new Random();
        this.identifiant = random.nextInt(3);
    }

    public void setTimer(){
        //Le timer sera compris entre 25 et 35
        Random random = new Random();
        this.timer =25 +random.nextInt(10);
    }

    public void setCommande(){
        this.commande = new Commande();
    }

    /*Méthode updateTimer qui met à jour le temps restant avant le départ du client */
    public void updateTimer(){ this.timer = this.timer - 0.2;}

    /* Méthode updateEtat qui met à jour l'état du client */
    public void updateEtat() { this.etat = this.etat+1; }


    @Override
    public void run() {
        /*Tant que timer du client n'est pas fini */
        while(this.timer>0) {
            try {
                /* Attendre 200ms */
                Thread.sleep(400/(this.anger+1));
                /* Mettre a jour la colère et le timer */
                this.updateTimer();
                this.updateEtat();
            }
            catch (Exception e) { e.printStackTrace(); }
        }
    }
}
