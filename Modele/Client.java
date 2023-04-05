package Modele;

import java.util.Random;

/**
 *  Class Client hérite de la classe 'Thread'
 *  et initialise les données des clients
 *
 * @version 1.0
 * */
public class Client extends Thread{

    /**
     * Boolean qui indique si le thread associé au timer du client peut commencer
     * (utile quand y a une erreur d'interruption)
     * */
    private boolean running;

    /**
     *  Attributs
     * */

    /** Nombre entier qui représente l'identifiant unique du client */
    private int identifiant;

    /**
     * Nombre entier qui représente l'identifiant de l'image du client
     * */
    private int idImage;

    /**
     * Nombre à virgule qui représente le temps maximum que le client
     * va attendre pour sa commande
     * */
    private double timer;

    /**
     * Nombre entier qui représente la colère d'un client
     * sur une échelle de 0 à 5 (inclus)
     * */
    private int anger;

    /**
     * Boolean qui indique si la commande du client a été traitée ou pas
     * */
    private boolean traitementcommande;

    /**
     * Nombre entier qui représente l'état du client
     * (utile pour leur affichage)
     * */
    private int etatclient;

    /**
     * Variable de type 'Commande' qui représente la commande
     * du client
     * */
    private Commande commande;

    //private Etat modele;            /*permet de mettre à jour les variables score et client insatisfaits*/


    /**
     * Constructeur
     * Définit les données attribuées au client et permet
     * au Thread de s'exécuter
     *
     * @param id  de type 'int'
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
     * @return idImage  de type 'int'
     * */
    public int getIdImage(){
        return this.idImage;
    }

    /**
     * Obtient et renvoie le temps d'attente du client
     *
     * @return timer  de type 'double'
     * */
    public double getTimer(){
        return this.timer;
    }

    /**
     * Obtient et renvoie le degré de colère du client
     *
     * @return anger  de type 'int'
     * */
    public int getAnger(){
        return this.anger;
    }

    /**
     * Obtient et renvoie la commande du client
     *
     * @return commande  de type 'Commande'
     * */
    public Commande getCommande(){
        return this.commande;
    }

    /**
     * Obtient et renvoie le statut de la commande du client
     *
     * @return traitementcommande  de type 'boolean'
     * */
    public boolean getTraitementCommande(){
        return this.traitementcommande;
    }

    /**
     * Obtient et renvoie l'état du client
     *
     * @return etatclient  de type 'int'
     * */
    public int getEtatclient(){
        return this.etatclient;
    }

    /**
     * Obtient et renvoie l'identifiant du client
     *
     * @return identifiant  de type 'int'
     * */
    public int getIdentifiant(){ return this.identifiant; }



    /** Setters **/

    /**
     * Définit l'identifiant du client
     *
     * @param id  de type 'int'
     * */
    public void setIdentifiant(int id ){
        this.identifiant = id;
    }

    /**
     * Définit le degré de colère du client de manière aléatoire
     *
     * */
    public void setAnger(){
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
     * de manière aléatoire
     *
     * */
    public void setIdImage(){
        Random random = new Random();
        this.idImage = random.nextInt(3);
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
        // si temps est égal à 0, on incrémente le nb de clients insatisfaits
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
        /*Tant que timer du client n'est pas fini */
        while(this.timer>0 && running) {
            try {
                /* Attendre 200ms */
                Thread.sleep(400/(this.anger+1));
                /* Mettre a jour la colère et le timer */
                this.updateTimer();
                this.updateEtat();

            }
            catch (InterruptedException e) {
                System.out.println("client "+this.getIdentifiant()+" interrompu ");
                running = false;
            }
        }
    }
}
