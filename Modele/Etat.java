package Modele;
import Vue.Clients;
import Vue.miniAffichageClient;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/* Ensemble des données qui caractériseront l'état de mon interface */
public class Etat {

    /* Attributs concernant le Joueur et les clients */
    private int score;                          /* Score Joueur */
    private int compteurClients = 1;            /* Nb de clients générés */
    private static int clients_insatisfaits;    /* Nb de clients insatisfaits */

    private static int clients_servis = 0; /* Nb de clients servis */
    private Clients clients;                    /* La liste de tous les clients dans le magasin */
    private int client_en_cours;                /* index ( et NON PAS ID )  du client
                                                qui se fait traiter sa commande actuellement */
    private HashSet<String>selectionIngredients; /* Liste de tous les ingrédients selectionnés par le joueur afin de préparer un produit */

    /* Attributs concernants les stocks */

    private HashMap<String, Integer> stockProduits;
    /* Prix des produits*/
    private static final HashMap<String, Integer> prixProduits;

    static {
        //On initialise les prix produits
        prixProduits = new HashMap<>();
        prixProduits.put("Burger", 8);
        prixProduits.put("Frites", 4);
        prixProduits.put("Pizza",  10);
        prixProduits.put("Wrap", 6);
        prixProduits.put("Boisson", 2);
        prixProduits.put("Gateau", 3);
    }

    /* Attributs préparation */

    private int dureePreparation = 3000; //durée de la préparation en ms
    private boolean burger_en_cours_de_preparation;
    private boolean pizza_en_cours_de_preparation;
    private boolean frites_en_cours_de_preparation;
    private boolean wrap_en_cours_de_preparation;

    /* Contenu du plateau, LinkedHashMap est une HashMap qui mémorise ordre d'insertion */
    private LinkedHashMap<String, Integer> trayContent;


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

        //On initialise les stocks produits
        Random random = new Random();
        stockProduits = new HashMap<>();
        stockProduits.put("Burger", 8+random.nextInt(8));
        stockProduits.put("Frites",  8+random.nextInt(8));
        stockProduits.put("Pizza",  8+random.nextInt(8));
        stockProduits.put("Wrap",  8+random.nextInt(8));
        stockProduits.put("Boisson",  108+random.nextInt(8));
        stockProduits.put("Gateau",  108+random.nextInt(8));

        /* On initiase notre liste d'ingrédients selectionnés vide*/
        this.selectionIngredients = new HashSet<String>();

        /* On initialise nos varaibles en cours de preparation a false */
        this.setBurger_en_cours_de_preparation(false);
        this.setPizza_en_cours_de_preparation(false);
        this.setFrites_en_cours_de_preparation(false);
        this.setWrap_en_cours_de_preparation(false);

        /*On initialise le contenu du plateau */
        trayContent = new LinkedHashMap<>();


    }

    /* Getters */
    public int getCompteurClients(){
        return this.compteurClients;
    }

    public int getClient_en_cours(){
        return this.client_en_cours;
    }

    public boolean isBurger_en_cours_de_preparation(){
        return this.burger_en_cours_de_preparation;
    }

    public boolean isPizza_en_cours_de_preparation(){
        return this.pizza_en_cours_de_preparation;
    }

    public boolean isFrites_en_cours_de_preparation(){
        return this.frites_en_cours_de_preparation;
    }

    public boolean isWrap_en_cours_de_preparation(){
        return this.wrap_en_cours_de_preparation;
    }

    public Clients getClients(){
        return clients;
    }

    public HashSet<String>getSelectionIngredients(){
        return this.selectionIngredients;
    }
    public int getStockBurger() {
        return stockProduits.getOrDefault("Burger", 0);
    }

    public int getStockPizza() {
        return stockProduits.getOrDefault("Pizza", 0);
    }

    public int getStockBoisson() {
        return stockProduits.getOrDefault("Boisson", 0);
    }

    public int getStockWrap() {
        return stockProduits.getOrDefault("Wrap", 0);
    }

    public int getStockFrites() {
        return stockProduits.getOrDefault("Frites", 0);
    }

    public int getStockGateau() {
        return stockProduits.getOrDefault("Gateau", 0);
    }

    public int getScore() { return score; }

    public int getClients_insatisfaits() { return clients_insatisfaits; }

    public int getClients_servis() { return clients_servis; }

    public int getDureePreparation() { return this.dureePreparation; }

    public static HashMap<String, Integer> getPrixProduits() {return Etat.prixProduits; }

    public HashMap<String, Integer> getTrayContent() { return this.trayContent; }

    /* Setters */

    public void setBurger_en_cours_de_preparation(boolean bool){
        this.burger_en_cours_de_preparation = bool;
    }
    public void setPizza_en_cours_de_preparation(boolean bool){
        this.pizza_en_cours_de_preparation = bool;
    }
    public void setWrap_en_cours_de_preparation(boolean bool){
        this.wrap_en_cours_de_preparation = bool;
    }

    public void setFrites_en_cours_de_preparation(boolean bool){
        this.frites_en_cours_de_preparation = bool;
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

    // Méthode qui ajoute un ingredient en parametre a notre selection d'ingredients
    public void addIngredient(String ingredient){
        this.selectionIngredients.add(ingredient);
    }

    // Méthode qui supprime un ingrédient en parametre de notre selection d'ingredient
    public void removeIngredient(String ingredient){
        this.selectionIngredients.remove(ingredient);
    }

    // Méthode qui vide la séléction d'ingrédients (pour annuler)
    public void videIngredients() {
        this.selectionIngredients.clear();
    }

    // Méthode qui enclenche la production d'un burger qui prendra un durée donnée en parametre
    public void preparationBurger( int dureeEnMillisecondes) {
        this.burger_en_cours_de_preparation = true;
        Timer timer = new Timer(dureeEnMillisecondes, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Etat.this.burger_en_cours_de_preparation = false;
                stockProduits.put("Burger",stockProduits.get("Burger")+1);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    // Méthode qui enclenche la production d'une pizza qui prendra un durée donnée en paramtre
    public void preparationPizza( int dureeEnMillisecondes) {
        this.pizza_en_cours_de_preparation = true;
        Timer timer = new Timer(dureeEnMillisecondes, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Etat.this.pizza_en_cours_de_preparation = false;
                stockProduits.put("Pizza",stockProduits.get("Pizza")+1);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    // Méthode qui enclenche la production d'une barquette de frittes qui prendra un durée donnée en parametre
    public void preparationFrites(int dureeEnMillisecondes) {
        this.frites_en_cours_de_preparation = true;
        Timer timer = new Timer(dureeEnMillisecondes, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Etat.this.frites_en_cours_de_preparation = false;
                stockProduits.put("Frites",stockProduits.get("Frites")+1);
            }
        });
        timer.setRepeats(false);
        timer.start();

    }

    /* Méthode qui enclenche la production d'un wrap qui prendra un durée donnée en parametre */
    public void preparationWrap( int dureeEnMillisecondes) {
        this.wrap_en_cours_de_preparation = true;
        Timer timer = new Timer(dureeEnMillisecondes, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Etat.this.wrap_en_cours_de_preparation = false;
                stockProduits.put("Wrap",stockProduits.get("Wrap")+1);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    /** Methode qui d'apres la selection des ingredients, si celle-ci correspond a une
     * recette pour un produit alors on augmente sa quantite de 1 et on clear la selection
     return le nom du produit créé, null sinon
     */
    public String production(){
        //Burger : Pain, tomate, viande, sauce
        HashSet <String> recetteBurger = new HashSet<>(Arrays.asList("pain","tomate","viande","sauce"));
        // Frites : patate, huile, sel
        HashSet <String> recetteFrites = new HashSet<>(Arrays.asList("patate","huile","sel"));
        //Pizza : pate, tomate, fromage, sauce
        HashSet <String> recettePizza = new HashSet<>(Arrays.asList("pate","tomate","fromage","sauce"));
        //Wrap : tortilla, poulet, salade, fromage
        HashSet <String> recetteWrap = new HashSet<>(Arrays.asList("tortilla","poulet","salade","fromage"));

        //nom du produit généré
        String produit = "vide";

        if(this.getSelectionIngredients().equals(recetteBurger)) {
            if (!this.burger_en_cours_de_preparation) {
                this.preparationBurger(dureePreparation);
                this.selectionIngredients = new HashSet<>();
                produit = "Burger";
            }
        } if(this.getSelectionIngredients().equals(recetteFrites)) {
            if (!this.frites_en_cours_de_preparation) {
                this.preparationFrites(dureePreparation);
                this.selectionIngredients = new HashSet<>();
                produit = "Frites";
            }
        } if(this.getSelectionIngredients().equals(recettePizza)) {
            if (!this.pizza_en_cours_de_preparation) {
                this.preparationPizza(dureePreparation);
                this.selectionIngredients = new HashSet<>();
                produit = "Pizza";
            }
        } if(this.getSelectionIngredients().equals(recetteWrap)) {
            if (!this.wrap_en_cours_de_preparation) {
                this.preparationWrap(dureePreparation);
                this.selectionIngredients = new HashSet<>();
                produit = "Wrap";
            }
        }
        return produit;
    }



    /** Méthode qui renvoie true si le jeu est fini sinon false */
    public boolean gameOver(){
        // Si le nombre de client insastisfait dépasse 5
        // Alors le jeu est fini
        return clients_insatisfaits > 5;
        // Sinon non
    }

    /** incrémente la valeur du compteur de clients générés */
    public void updateCompteurClients(){
        this.compteurClients++;
    }

    /** Ajoute un produit passé en paramètre au contenu du plateau si stock disponible
     * Diminue le stock en conséquence
     * */
    public void addToTray(String product) {
        //si le stock n'est pas nul
        if(stockProduits.getOrDefault(product,0) != 0) {
            trayContent.put(product, trayContent.getOrDefault(product, 0) + 1);
            stockProduits.put(product,stockProduits.get(product)-1);
        }
    }

    /** Vide le plateau après avoir
     * ajouté son contenu au stock
     * */
    public void cancelTray() {
        for (Map.Entry<String, Integer> entry : trayContent.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();

            //On ajoute la qté au stock
            stockProduits.put(product, stockProduits.get(product) + quantity);
        }
        // Vide le plateau
        trayContent.clear();
    }

    /** sert le client si la commande du client en cours correspond au contenu du plateau
     * supprime le client en cours
     * vide le plateau
     */
    public void serveTray() {
        Client clientEnCours = this.getClients().getListeClients().get(client_en_cours);
        // Si la file n'est pas vide et la commande du client en cours correspond au contenu du plateau
        if( !this.fileVide() && CommandeEqualTray(clientEnCours.getCommande())) {
            // On ajoute le prix de la commande au score
            this.score += clientEnCours.getCommande().getPrix();

            // On supprime le client de la liste des clients
            this.clients.removeClient(clientEnCours);
            // On incrémente le nb de clients servis
            clients_servis += 1;

            // On vide le plateau
            trayContent.clear();
        }

    }

    /** Retourne vrai si la commande passée en paramètre correspond au contenu du plateau */
    public boolean CommandeEqualTray(Commande commande) {
        // Crée un HashMap pour stocker les quantités de produits dans la commande
        HashMap<String, Integer> commandeContent = new HashMap<>();

        // Parcourt la liste des produits de la commande
        for (Produit produit : commande.getProduits()) {
            // Met à jour le HashMap commandeContent avec les quantités de produits
            commandeContent.put(produit.getNom(), produit.getQuantite());
        }

        // Compare les deux HashMap (commandeContent et trayContent) pour vérifier s'ils sont égaux
        return trayContent.equals(commandeContent);
    }


}