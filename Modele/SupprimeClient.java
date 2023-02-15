package Modele;

public class SupprimeClient extends  Thread{

    /* Attributs */
    Etat etat;

    /* Constructeur */
    public SupprimeClient(Etat etat){
        this.etat = etat;
    }

    /* Getter */
    public Etat getEtat() {
        return etat;
    }

    /* Setter */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }
    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
