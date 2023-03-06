package Modele;

public class GenereClient extends Thread{

    Etat etat;

    public GenereClient(Etat etat){
        this.etat = etat;
    }

    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(10000);
                this.etat.getClients().addClient(new Client(this.etat.getCompteurCLients()));
                this.etat.updateCompteurClients();
            } catch (Exception e) { e.printStackTrace(); }
        }
    }
}
