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
                Thread.sleep(5000);
                this.etat.getClients().addClient(new Client());
            } catch (Exception e) { e.printStackTrace(); }
        }
    }
}
