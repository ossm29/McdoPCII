package Controleur;

import Modele.Client;

/**
 *  Class GenereClient hérite la classe 'Thread'
 *  et gère l'apparition de clients sur l'écran.
 *
 *  Elle est responsable de la génération de nouveaux clients
 *  et de l'affichage d'un avertissement lors de leur arrivée.
 *
 * @version 1.0
 * */
public class GenereClient extends Thread{

    /** Attributs */

    // Variable de type 'Control'
    // Utilisée pour définir l'affichage et l'état de l'interface utilisateur
    Control control;

    /**
     * Constructeur
     * Initialise la variable d'instance nécessaire à la classe.
     * Définit l'affichage et l'état de l'interface
     * avec une variable de type 'Control'
     *
     * @param control  objet qui gère l'interface de l'utilisateur de type 'Control'
     * */
    public GenereClient(Control control){
        this.control = control;
    }


    /**
     * La méthode 'run' est appelée lorsqu'un nouveau Thread est démarré.
     * Permet de générer des clients sur l'écran de l'utilisateur
     * et de l'affichage d'un message lors de leur arrivée.
     *
     * */
    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(10000);
                // Génère un nouveau client
                this.control.getEtat().getClients().addClient(new Client(this.control.getEtat().getCompteurClients()));
                // Affichage d'un texte lors de leur apparition
                this.control.getAffichagePrincipal().getAffichageGauche().getAffichageServeur().afficherTexteTemporairement("Le client N° : "+this.control.getEtat().getCompteurClients() +" vient d'arriver !",5000);
                this.control.getEtat().updateCompteurClients();
            } catch (Exception e) { e.printStackTrace(); }
        }
    }
}
