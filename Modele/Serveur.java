package Modele;

/**
 * Classe Serveur hérite de la classe 'Thread'.
 * Elle permet de représenter un serveur.
 *
 * @version 1.0
 * */
public class Serveur extends Thread{

    /** Attribut */

    /* L'état correspondant  */
    private int etat;

    /**
     * Constructeur
     * Initialise l'état du serveur à 0.
     *
     * */
    public Serveur(){
        this.setEtat(0);
    }

    /** Getter
     * Obtient et renvoie l'état actuel du serveur.
     *
     * @return l'état actuel du serveur.
     * */
    public int getEtat() {
        return etat;
    }

    /** Setter
     * Définit et initialise l'état du serveur.
     *
     * @param etatServeur le nouvel état du serveur de type 'Etat'
     * */
    public void setEtat(int etatServeur) {
        this.etat = etatServeur;
    }

    /**
     * Méthode qui met a jour l'état du serveur en incrémentant
     * sa valeur.
     *
     * */
    public void updateEtat(){
        this.etat++;
    }


    /**
     * Méthode appelée lors du démarrage du Thread.
     * Elle met aà jour l'état du serveur toutes les 200ms tant que le Thread
     * est en cours d'exécution.
     *
     * */
    @Override
    public void run() {
        /*Tant que true */
        while(true) {
            try {
                /* Attendre 200ms */
                Thread.sleep(200);
                /* Mettre a jour l'état du serveur*/
                this.updateEtat();
            }
            catch (Exception e) { e.printStackTrace(); }
        }
    }
}
