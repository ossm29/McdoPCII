package Controleur;

import Modele.Client;

/**
 *  Class GenereClient hérite la classe 'Thread'
 *  et gère l'apparition de clients sur l'écran
 *
 * @version 1.0
 * */
public class GenereClient extends Thread{

    /**
     * Variable de type 'Control'
     * */
    Control control;

    /**
     * Constructeur
     * Définit l'affichage et l'état de l'interface
     * avec une variable de type 'Control'
     *
     * @param control  de type 'Control'
     * */
    public GenereClient(Control control){
        this.control = control;
    }


    /**
     * Méthode qui permet de générer des clients sur l'écran
     * de l'utilisateur ainsi que l'avertissement de leurs arrivées
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
