package Modele;

public class Serveur extends Thread{

    /* Attributs */
    private int etat;

    /* Constructeur */
    public Serveur(){
        this.setEtat(0);
    }

    /* getter */
    public int getEtat() {
        return etat;
    }

    /* setter */
    public void setEtat(int etatServeur) {
        this.etat = etatServeur;
    }

    /* Méthode qui met a jour l'etat du serveur */
    public void updateEtat(){
        this.etat++;
    }

    @Override
    public void run() {
        /*Tant que true */
        while(true) {
            try {
                /* Attendre 150ms */
                Thread.sleep(200);
                /* Mettre a jour l'état du serveur*/
                this.updateEtat();
            }
            catch (Exception e) { e.printStackTrace(); }
        }
    }
}
