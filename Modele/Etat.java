package Modele;
import Controleur.GenereClient;
import Vue.Clients;
import Vue.miniAffichageClient;
import java.util.Random;

/* Ensemble des données qui caractériseront l'état de mon interface */
public class Etat {

    //

    /* Attributs concernant le Joueur et les clients */
    private int score;                          /* Score Joueur */
    private int compteurCLients = 2;            /* Nb de clients générés */
    private static int clients_insatisfaits;    /* Nb de client insatisfait */
    private Clients clients;                    /* La liste de tous les clients dans le magasin */
    private int client_en_cours;                /* index ( et NON PAS ID )  du client
                                                qui se fait traiter sa commande actuellement */

    /* Attributs concernants les stocks */
    private int quantiteBurger;
    private int quantitePizza;
    private int quantiteBoisson;
    private int quantiteSushi;
    private int quantiteFrittes;
    private int quantiteDessert;

    /* Les threads */
    private GenereClient genereClient;

    /*dimensions de la fenêtre ; les dimesnsions des autres affichages sont proportionnelles*/
    public static final int WIDTH = 1420;
    public static final int HEIGHT = 800;




    /* Thread */
    
    /* Constructeur */
    public Etat(){
        /* Initialisation */
        this.score = 0;
        clients_insatisfaits = 0;
        this.clients = new Clients(new miniAffichageClient(this));

        /* Attributs Stockage Pour Chaque Produits */
        this.setQuantiteBoisson();
        this.setQuantiteBurger();
        this.setQuantiteDessert();
        this.setQuantiteFrittes();
        this.setQuantiteSushi();
        this.setQuantitePizza();


    }

    /* Getters */
    public int getCompteurCLients(){
        return this.compteurCLients;
    }

    public int getClient_en_cours(){
        return this.client_en_cours;
    }

    public Clients getClients(){
        // TODO SUPPrimer les clients avec un timer nul
        /*Clients nosClients = new Clients(this.clients.getMiniAffichageClient());
        for (Client client : clients.getListeClients()){
            if (client.getTimer()<0){
                clients.removeClient(client);
            }
        }*/
        return clients;
    }

    public int getQuantiteBurger() {
        return quantiteBurger;
    }

    public int getQuantitePizza() {
        return quantitePizza;
    }

    public int getQuantiteBoisson() {
        return quantiteBoisson;
    }

    public int getQuantiteSushi() {
        return quantiteSushi;
    }

    public int getQuantiteFrittes() {
        return quantiteFrittes;
    }

    public int getQuantiteDessert() {
        return quantiteDessert;
    }

    public int getScore() { return score; }

    public int getClients_insatisfaits() { return clients_insatisfaits; }
    /* Setters */

    public void setQuantiteBurger() {
        /* Entre 8 et 15 */
        Random random = new Random();
        this.quantiteBurger = 8 + random.nextInt(8);
    }
    public void setQuantitePizza() {
        /* Entre 8 et 15 */
        Random random = new Random();
        this.quantitePizza = 8 + random.nextInt(8);
    }

    public void setQuantiteSushi() {
        /* Entre 8 et 15 */
        Random random = new Random();
        this.quantiteSushi = 8 + random.nextInt(8);
    }

    public void setQuantiteBoisson() {
        /* Entre 8 et 15 */
        Random random = new Random();
        this.quantiteBoisson = 8 + random.nextInt(8);
    }

    public void setQuantiteDessert() {
        /* Entre 8 et 15 */
        Random random = new Random();
        this.quantiteDessert = 8 + random.nextInt(8);
    }

    public void setQuantiteFrittes() {
        /* Entre 8 et 15 */
        Random random = new Random();
        this.quantiteFrittes= 8 + random.nextInt(8);
    }
    /* Méthodes */

    // Méthode qui met a jour le score
    public void updateScore(){
        this.score++;
    }

    // Méthode qui met a jour le nombre de client insatisfait du service
    public static void updateClientInsatisfait(){
        clients_insatisfaits++;
    }

    // Méthode qui update l'index du client en cours en passant au suivant
    public void clientsuivant(){
        if ( this.client_en_cours + 1 < this.clients.getListeClients().size()){
            this.client_en_cours++;
        }
    }

    // Méthode qui update l'index du client en cours en passant au précédent
    public void clientprecedent(){
        if ( this.client_en_cours -1 > -1){
            this.client_en_cours --;
        }
    }

    // Méthode qui renvoie true si la file est vide est qu'il n'y'a aucun client a servir
    public boolean fileVide(){
        if (this.clients.getListeClients().size() == 0) { return true; }
        else { return false; }
    }

    // Méthode qui renvoie true si le jeu est fini sinon false
    public boolean gameOver(){
        // Si le nombre de client insastisfait dépasse 5
        // Alors le jeu est fini
        return clients_insatisfaits > 5;
        // Sinon non
    }

    public void updateCompteurClients(){
        this.compteurCLients++;
    }
}