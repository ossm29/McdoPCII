package Modele;

import java.util.Random;

/**
 *  Class Client hérite de la classe 'Thread' et permet de représenter
 *  un client dans notre système de restaurant.
 *
 *  Elle initialise les données du client telles que l'identifiant, l'image,
 *  le temps d'attente, la colère, la commande, le statut de la commande
 *  et l'état du client.
 *
 * @version 1.0
 * */
public class Client extends Thread{


    // Boolean qui indique si le thread associé au timer du client peut commencer
    // (utile en cas d'interruption)
    private boolean running;

    /** Attributs */

    /* Identifiant unique du client */
    private int identifiant;

    /* Identifiant de l'image du client */
    private int idImage;

    /* Temps d'attente maximum du client */
    private double timer;

    /* Colère du client sur une échelle de 0 à 5 */
    private int anger;

    /* Statut de la commande */
    private boolean traitementcommande;

    /* État du client (utile pour leur affichage) */
    private int etatclient;

    /* Commande passée par le client */
    private Commande commande;

    //private Etat modele;            /*permet de mettre à jour les variables score et client insatisfaits*/


    /**
     * Constructeur
     * Initialise les attributs du client et lance le thread.
     *
     * @param id  Identifiant unique du client de type 'int'
     * */
    public Client( int id){
        this.running = true;
        this.setIdentifiant(id);
        this.setTraitementcommande();
        this.setAnger();
        this.setIdImage();
        this.setTimer();
        this.setCommande();
        this.start();

    }


    /** Getters **/

    /**
     * Obtient et renvoie l'identifiant de l'image du client
     *
     * @return idImage  l'identifiant de l'image du client de type 'int'
     * */
    public int getIdImage(){
        return this.idImage;
    }

    /**
     * Obtient et renvoie le temps d'attente maximum du client
     *
     * @return timer  le temps d'attente de type 'double'
     * */
    public double getTimer(){
        return this.timer;
    }

    /**
     * Obtient et renvoie la colère du client
     *
     * @return anger  le degré de colère de type 'int'
     * */
    public int getAnger(){
        return this.anger;
    }

    /**
     * Obtient et renvoie la commande du client
     *
     * @return commande  la commande passée par le client
     *                   de type 'Commande'
     * */
    public Commande getCommande(){
        return this.commande;
    }

    /**
     * Obtient et renvoie le statut de la commande du client
     *
     * @return traitementcommande  le statut de la commande
     *                             de type 'boolean'
     * */
    public boolean getTraitementCommande(){
        return this.traitementcommande;
    }

    /**
     * Obtient et renvoie l'état du client
     *
     * @return etatclient  l'état du client de type 'int'
     * */
    public int getEtatclient(){
        return this.etatclient;
    }

    /**
     * Obtient et renvoie l'identifiant du client
     *
     * @return identifiant  l'identifiant du client de type 'int'
     * */
    public int getIdentifiant(){ return this.identifiant; }



    /** Setters **/

    /**
     * Définit l'identifiant du client
     *
     * @param id  L'identifiant unique du client de type 'int'
     * */
    public void setIdentifiant(int id ){
        this.identifiant = id;
    }

    /**
     * Définit le degré de colère du client de manière aléatoire
     *
     * */
    public void setAnger(){
        // la colère sera comprise entre 0 et 5 (inclus)
        Random random = new Random();
        this.anger = random.nextInt(6);
    }

    /**
     * Définit le statut de la commande du client
     *
     * */
    public void setTraitementcommande(){
        // traitement initialisé à 'false' à l'arrivée du client
        this.traitementcommande = false;
    }

    /**
     * Définit l'identifiant de l'image du client
     * Définit l'identifiant de l'image du client
     * de manière aléatoire
     *
     * */
    public void setIdImage(){
        Random random = new Random();
        this.idImage = random.nextInt(5);
    }

    /**
     * Définit le temps d'attente du client de manière aléatoire
     *
     * */
    public void setTimer(){
        // Le timer sera compris entre 25 et 35 secondes
        Random random = new Random();
        this.timer =25 +random.nextInt(10);
    }

    /**
     * Définit la commande du client
     *
     * */
    public void setCommande(){
        // Nouvelle commande à l'arrivée d'un nouveau client
        this.commande = new Commande();
    }

    /**
     * Méthode qui met à jour le temps restant avant
     * le départ du client
     *
     * */
    public void updateTimer(){
        this.timer = this.timer - 0.2;
        // Si temps est égal à 0, on incrémente le nb de clients insatisfaits
        if(this.timer <= 0) {
            Etat.updateClientInsatisfait();
        }
    }

    /**
     *  Méthode qui met à jour l'état du client en l'incrémentant
     *
     * */
    public void updateEtat() { this.etatclient = this.etatclient +1; }


    /**
     * Methode qui met à jour l'état du client (sa colère) et
     * son temps d'attente
     *
     * */
    @Override
    public void run() {
        // Tant que timer du client n'est pas fini
        while(this.timer>0 && running) {
            try {
                // Attendre 200ms
                Thread.sleep(400/(this.anger+1));
                // Mettre a jour la colère et le timer du client
                this.updateTimer();
                this.updateEtat();

            }
            catch (InterruptedException e) {
                // Exception levée si l'interruption du thread se produit
                System.out.println("client "+this.getIdentifiant()+" interrompu ");
                running = false;
            }
        }
    }
}
