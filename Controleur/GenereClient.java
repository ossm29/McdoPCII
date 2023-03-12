package Controleur;

import Modele.Client;
import Modele.Etat;

public class GenereClient extends Thread{

    Control control;

    public GenereClient(Control control){
        this.control = control;
    }

    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(10000);
                this.control.getEtat().getClients().addClient(new Client(this.control.getEtat().getCompteurCLients()));
                this.control.getAffichagePrincipal().getAffichageGauche().getAffichageServeur().afficherTexteTemporairement("Le client N° : "+this.control.getEtat().getCompteurCLients() +" vient d'arriver !",5000);
                this.control.getEtat().updateCompteurClients();
            } catch (Exception e) { e.printStackTrace(); }
        }
    }
}
