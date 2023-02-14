package Modele;

public class Serveur extends Thread{

    /* Attributs */
    private int etatServeur;

    /* Constructeur */
    public Serveur(){
        this.setEtatServeur(0);
    }

    /* getter */
    public int getEtatServeur() {
        return etatServeur;
    }

    /* setter */
    public void setEtatServeur(int etatServeur) {
        this.etatServeur = etatServeur;
    }

    /* Méthode qui met a jour l'etat du serveur */
    public void updateEtatServeur(){
        this.etatServeur++;
    }

    @Override
    public void run() {
        /*Tant que true */
        while(true) {
            try {
                /* Attendre 200ms */
                Thread.sleep(100);
                /* Mettre a jour l'état du serveur*/
                this.updateEtatServeur();
            }
            catch (Exception e) { e.printStackTrace(); }
        }
    }
}
