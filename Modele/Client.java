package Modele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Client extends Thread{

    /* Attributs */
    private int identifiant;            /* Identifiant du Client */
    private double timer;                  /* Le temps qu'il reste avant que le patient ne décide de s'en aller */
    private double anger;                  /* L'indicateur de colère du Client compris entre 0 et 2 inclu*/

    private String produit;             /* Produit désiré par le client */

    private boolean traitementcommande; /* La valeur traitementCommande indique si la commande a été traité ou pas */

    private int etat;                   /* L'état du client - utile pour l'affichage comme les oiseaux dans flappy-*/


    /* Constructeur */
    public Client(){
        this.setTraitementcommande();
        this.setAnger();
        this.setIdentifiant();
        this.setTimer();
        this.setProduit();
    }


    /* Getters */
    public int getIdentifiant(){
        return this.identifiant;
    }
    public double getTimer(){
        return this.timer;
    }
    public double getAnger(){
        return this.anger;
    }
    public String getProduit(){
        return this.produit;
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
        this.anger = random.nextInt(3);
    }
    public void setTraitementcommande(){
        this.traitementcommande = false;
    }
    public void setIdentifiant(){

        Random random = new Random();
        this.identifiant = random.nextInt(2);
    }
    public void setTimer(){
        //Le timer sera compris entre 25 et 35
        Random random = new Random();
        this.timer =25 +random.nextInt(10);
    }
    public void setProduit(){
        // La liste de notre menu
        ArrayList<String>menu = new ArrayList<>(Arrays.asList("plat0", "plat1", "plat2", "plat3", "plat4"));
        // Le client choisira un des 5 produits du menu -pour l'instant un produit-
        Random random = new Random();
        // Le choix sera aléatoire pour essayer de varier les demandes des clients grace a un int compris entre 0 et 5
        int produitChoisi = random.nextInt(5);
        this.produit = menu.get(produitChoisi);
    }


    /* Méthode updateAnger qui met à jour la colère du client */
    public void updateAnger(){
        this.anger = this.anger - 0.2;
    }

    /*Méthode updateTimer qui met à jour le temps restant avant le départ du client */
    public void updateTimer(){ this.timer = this.timer - 0.2;}

    /* Méthode updateEtat qui met à jour l'état du client */
    public void updateEtat() { this.etat = this.etat+1; }

    @Override
    public void run() {
        /*Tant que timer du client n'est pas fini */
        while(true) {   // while(this.timer>0) au future
            try {
                /* Attendre 200ms */
                Thread.sleep(200);
                /* Mettre a jour la colère et le timer */
                this.updateAnger();
                this.updateTimer();
                this.updateEtat();
            }
            catch (Exception e) { e.printStackTrace(); }
        }
    }
}
