package Modele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Client extends Thread{

    /* Attributs */
    private int identifiant;            /* Identifiant du Client */
    private int timer;                  /* Le temps qu'il reste avant que le patient ne décide de s'en aller */
    private int anger;                  /* L'indicateur de colère du Client */

    private String produit;             /* Produit désiré par le client */

    private boolean traitementcommande; /* La valeur traitementCommande indique si la commande a été traité ou pas */

    private int etat;                   /* L'état du client - utile pour l'affichage comme les oiseaux dans flappy-


    /* Constructeur */
    public Client(int id){
        this.anger = 0;
        this.traitementcommande = false;
        this.setIdentifiant(id);
        this.setTimer();
        this.setProduit();
    }


    /* Getters */
    public int getIdentifiant(){
        return this.identifiant;
    }
    public int getTimer(){
        return this.timer;
    }
    public int getAnger(){
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
    public void setIdentifiant(int id){
        this.identifiant = id;
    }
    public void setTimer(){
        //Le timer sera compris entre 15 et 30
        Random random = new Random();
        this.timer = 15+random.nextInt(15);
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


    /* Méthode updateAnger qui met à jour l'état de colère du client */
    public void updateAnger(){
        this.anger++;
    }

    /*Méthode updateTimer qui met à jour le temps restant avant le départ du client */
    public void updateTimer(){
        this.timer--;
    }

    @Override
    public void run() {
        /*Tant que timer du client n'est pas fini */
        while(this.timer>0) {
            try {
                /* Attendre 1s */
                Thread.sleep(1000);
                /* Mettre a jour la colère et le timer */
                this.updateAnger();
                this.updateTimer();
            }
            catch (Exception e) { e.printStackTrace(); }
        }
    }
}
