package Modele;
import Vue.Clients;
import Vue.miniAffichageClient;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Classe Etat représente l'état du jeu.
 * Elle contient les données nécessaires pour initialiser et mettre à jour
 * l'interface graphique, ainsi que pour gérer les interactions
 * avec l'utilisateur.
 *
 * @version 1.0
 * */
public class Etat {

    /** Attributs concernant le joueur et les clients */

    /* Score du joueur */
    private int score;
    /* Nombre de clients générés */
    private int compteurClients = 1;
    /* Nombre de clients insatisfaits */
    private static int clients_insatisfaits;
    /* Nombre de clients servis */
    private static int clients_servis = 0;
    /* Liste de tous les clients dans le restaurant */
    private Clients clients;
    /* Index (et non pas ID) du client qui se fait
    traiter sa commande actuellement */
    private int client_en_cours;
    /* Liste de tous les ingrédients sélectionnés par le joueur
    afin de préparer un produit */
    private HashSet<String>selectionIngredients;

    /** Attributs concernant les stocks */

    /* Stock des produits */
    private HashMap<String, Integer> stockProduits;
    /* Prix des produits */
    private static final HashMap<String, Integer> prixProduits;

    /* Initialisation du prix de chaque produit */
    static {
        prixProduits = new HashMap<>();
        prixProduits.put("Burger", 8);
        prixProduits.put("Frites", 4);
        prixProduits.put("Pizza",  10);
        prixProduits.put("Wrap", 6);
        prixProduits.put("Boisson", 2);
        prixProduits.put("Gateau", 3);
    }

    /** Attributs concernant la préparation des produits */

    /* Durée de la préparation des produits en millisecondes */
    private int dureePreparation = 3000;
    /* Indique si un burger est en cours de préparation */
    private boolean burger_en_cours_de_preparation;
    /* Indique si une pizza est en cours de préparation */
    private boolean pizza_en_cours_de_preparation;
    /* Indique si des frites est en cours de préparation */
    private boolean frites_en_cours_de_preparation;
    /* Indique si un wrap est en cours de préparation */
    private boolean wrap_en_cours_de_preparation;

    /* Contenu du plateau
     (Choix du type : LinkedHashMap est une HashMap qui mémorise l'ordre d'insertion) */
    private LinkedHashMap<String, Integer> trayContent;

    /* Dimensions de la fenêtre ; les dimensions des autres affichages sont proportionnelles */
    public static final int WIDTH = 1420;
    public static final int HEIGHT = 800;


    /**
     * Constructeur
     * Initialise les attributs nécessaires au fonctionnement du jeu.
     *
     */
    public Etat(){
        /* Initialisations */
        this.score = 0;
        clients_insatisfaits = 0;
        this.clients = new Clients(new miniAffichageClient(this));

        // Initialisation des stocks des produits
        Random random = new Random();
        stockProduits = new HashMap<>();
        stockProduits.put("Burger", 8+random.nextInt(8));
        stockProduits.put("Frites",  8+random.nextInt(8));
        stockProduits.put("Pizza",  8+random.nextInt(8));
        stockProduits.put("Wrap",  8+random.nextInt(8));
        stockProduits.put("Boisson",  108+random.nextInt(8));
        stockProduits.put("Gateau",  108+random.nextInt(8));

        // Initialisation de la liste d'ingrédients sélectionnés vide
        this.selectionIngredients = new HashSet<String>();

        // Initialisation des variables en cours de préparation a false
        this.setBurger_en_cours_de_preparation(false);
        this.setPizza_en_cours_de_preparation(false);
        this.setFrites_en_cours_de_preparation(false);
        this.setWrap_en_cours_de_preparation(false);

        // Initialisation du contenu du plateau
        trayContent = new LinkedHashMap<>();

    }

    /** Getters */

    /**
     * Retourne le nombre de clients générés.
     *
     * @return compteurClients  le nombre de clients générés de type 'int'
     * */
    public int getCompteurClients(){
        return this.compteurClients;
    }

    /**
     * Retourne l'index du client qui se fait
     * traiter sa commande actuellement.
     *
     * @return client_en_cours  l'index du client de type 'int'
     * */
    public int getClient_en_cours(){
        return this.client_en_cours;
    }

    /**
     * Retourne l'état de préparation d'un burger.
     *
     * @return true si un burger est en cours de préparation,
     *         false sinon
     * */
    public boolean isBurger_en_cours_de_preparation(){
        return this.burger_en_cours_de_preparation;
    }

    /**
     * Retourne l'état de préparation d'une pizza.
     *
     * @return true si une pizza est en cours de préparation,
     *         false sinon
     * */
    public boolean isPizza_en_cours_de_preparation(){
        return this.pizza_en_cours_de_preparation;
    }

    /**
     * Retourne l'état de préparation de frites.
     *
     * @return true si des frites sont en cours de préparation,
     *         false sinon
     * */
    public boolean isFrites_en_cours_de_preparation(){
        return this.frites_en_cours_de_preparation;
    }

    /**
     * Retourne l'état de préparation d'un wrap.
     *
     * @return true si un wrap est en cours de préparation,
     *         false sinon
     * */
    public boolean isWrap_en_cours_de_preparation(){
        return this.wrap_en_cours_de_preparation;
    }

    /**
     * Retourne la liste de tous les clients dans le restaurant.
     *
     * @return clients  la liste de tous les clients dans le restaurant de type 'Clients'
     * */
    public Clients getClients(){
        return clients;
    }

    /**
     * Retourne la liste de tous les ingrédients sélectionnés par le joueur
     * afin de préparer un produit.
     *
     * @return selectionIngredients  la liste de tous les ingrédients sélectionnés
     *                               de type 'HashSet<String>'
     * */
    public HashSet<String>getSelectionIngredients(){
        return this.selectionIngredients;
    }

    /**
     * Retourne le stock de burgers dans le restaurant.
     *
     * @return stockProduits s'il n'est pas invalide,
     *         0 sinon
     *                       nombre de burgers en stock de type 'int'
     * */
    public int getStockBurger() {
        return stockProduits.getOrDefault("Burger", 0);
    }

    /**
     * Retourne le stock de pizzas dans le restaurant.
     *
     * @return stockProduits s'il n'est pas invalide,
     *         0 sinon
     *                       nombre de pizzas en stock de type 'int'
     * */
    public int getStockPizza() {
        return stockProduits.getOrDefault("Pizza", 0);
    }

    /**
     * Retourne le stock de boissons dans le restaurant.
     *
     * @return stockProduits s'il n'est pas invalide,
     *         0 sinon
     *                       nombre de boissons en stock de type 'int'
     * */
    public int getStockBoisson() {
        return stockProduits.getOrDefault("Boisson", 0);
    }

    /**
     * Retourne le stock de wrap dans le restaurant.
     *
     * @return stockProduits s'il n'est pas invalide,
     *         0 sinon
     *                       nombre de wrap en stock de type 'int'
     * */
    public int getStockWrap() {
        return stockProduits.getOrDefault("Wrap", 0);
    }

    /**
     * Retourne le stock de frites dans le restaurant.
     *
     * @return stockProduits s'il n'est pas invalide,
     *         0 sinon
     *                       nombre de frites en stock de type 'int'
     * */
    public int getStockFrites() {
        return stockProduits.getOrDefault("Frites", 0);
    }

    /**
     * Retourne le stock de gateaux dans le restaurant.
     *
     * @return stockProduits s'il n'est pas invalide,
     *         0 sinon
     *                       nombre de gateaux en stock de type 'int'
     * */
    public int getStockGateau() {
        return stockProduits.getOrDefault("Gateau", 0);
    }

    /**
     * Retourne le score du joueur.
     *
     * @return score  le score du joueur de type 'int'
     * */
    public int getScore() { return score; }

    /**
     * Retourne le nombre de clients insatisfaits.
     *
     * @return clients_insatisfaits  nombre de clients insatisfaits de type 'int'
     * */
    public int getClients_insatisfaits() { return clients_insatisfaits; }

    /**
     * Retourne le nombre de clients servis.
     *
     * @return clients_servis  nombre de clients servis de type 'int'
     * */
    public int getClients_servis() { return clients_servis; }

    /**
     * Retourne le temps de durée de préparation.
     *
     * @return dureePreparation  temps de préparation de type 'int'
     * */
    public int getDureePreparation() { return this.dureePreparation; }

    /**
     * Retourne le prix de tous les produits.
     *
     * @return prixProduits  le prix des produits de type 'HashMap<String, Integer>'
     * */
    public static HashMap<String, Integer> getPrixProduits() {return Etat.prixProduits; }

    /**
     * Retourne le contenu du plateau.
     *
     * @return trayContent  le contenu du plateau de type 'HashMap<String, Integer>'
     * */
    public HashMap<String, Integer> getTrayContent() { return this.trayContent; }


    /** Setters */

    /**
     * Met à jour le statut du burger en cours de préparation.
     *
     * @param bool  le nouveau statut du burger de type 'boolean'
     * */
    public void setBurger_en_cours_de_preparation(boolean bool){
        this.burger_en_cours_de_preparation = bool;
    }

    /**
     * Met à jour le statut de la pizza en cours de préparation.
     *
     * @param bool  le nouveau statut de la pizza de type 'boolean'
     * */
    public void setPizza_en_cours_de_preparation(boolean bool){
        this.pizza_en_cours_de_preparation = bool;
    }

    /**
     * Met à jour le statut du wrap en cours de préparation.
     *
     * @param bool  le nouveau statut du wrap de type 'boolean'
     * */
    public void setWrap_en_cours_de_preparation(boolean bool){
        this.wrap_en_cours_de_preparation = bool;
    }

    /**
     * Met à jour le statut des frites en cours de préparation.
     *
     * @param bool  le nouveau statut des frites de type 'boolean'
     * */
    public void setFrites_en_cours_de_preparation(boolean bool){
        this.frites_en_cours_de_preparation = bool;
    }


    /** Méthodes */

    /**
     * Méthode qui met à jour le score du joueur en l'incrémentant.
     *
     * */
    public void updateScore(){
        this.score++;
    }

    /**
     * Méthode qui met à jour le nombre de clients insatisfaits du service
     * en l'incrémentant.
     *
     * */
    public static void updateClientInsatisfait(){
        clients_insatisfaits++;
    }

    /**
     * Méthode qui met à jour l'index du client en cours de service
     * en passant au suivant.
     *
     * */
    public void clientsuivant(){
        // Vérification s'il existe un client suivant
        if ( this.client_en_cours + 1 < this.clients.getListeClients().size()){
            this.client_en_cours++;
        }
    }

    /**
     * Méthode qui met à jour l'index du client en cours de service
     * en passant au précédent.
     *
     * */
    public void clientprecedent(){
        // Vérification s'il existe un client précédent
        if ( this.client_en_cours -1 > -1){
            this.client_en_cours --;
        }
    }

    /**
     * Méthode qui vérifie si la file d'attente est vide
     * et qu'il n'y a aucun client à servir.
     *
     * @return true  si la file est vide,
     *         false sinon
     *
     * */
    public boolean fileVide(){
        if (this.clients.getListeClients().size() == 0) { return true; }
        else { return false; }
    }

    /**
     * Méthode qui ajoute un ingrédient choisi à la sélection d'ingrédients du joueur
     * lorsqu'il prépare un produit.
     *
     * @param ingredient  le nom de l'ingrédient à ajouter de type 'String'
     * */
    public void addIngredient(String ingredient){
        this.selectionIngredients.add(ingredient);
    }

    /**
     * Méthode qui supprime un ingrédient choisi à la sélection d'ingrédients du joueur
     * lorsqu'il prépare un produit.
     *
     * @param ingredient  le nom de l'ingrédient à supprimer de type 'String'
     * */
    public void removeIngredient(String ingredient){
        this.selectionIngredients.remove(ingredient);
    }

    /**
     * Méthode qui vide la sélection d'ingrédients du joueur lorsqu'il prépare un produit
     * afin de l'annuler.
     *
     * */
    public void videIngredients() {
        this.selectionIngredients.clear();
    }

    /**
     * Méthode qui enclenche la production d'un burger qui prendra
     * une durée donnée.
     *
     * @param dureeEnMillisecondes  durée de préparation en ms de type 'int'
     * */
    public void preparationBurger(int dureeEnMillisecondes) {
        this.burger_en_cours_de_preparation = true;
        Timer timer = new Timer(dureeEnMillisecondes, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Etat.this.burger_en_cours_de_preparation = false;
                // Ajout d'un burger au stock de produits après sa préparation
                stockProduits.put("Burger",stockProduits.get("Burger")+1);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    /**
     * Méthode qui enclenche la production d'une pizza qui prendra
     * une durée donnée.
     *
     * @param dureeEnMillisecondes  durée de préparation en ms de type 'int'
     * */
    public void preparationPizza(int dureeEnMillisecondes) {
        this.pizza_en_cours_de_preparation = true;
        Timer timer = new Timer(dureeEnMillisecondes, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Etat.this.pizza_en_cours_de_preparation = false;
                // Ajout d'une pizza au stock de produits après sa préparation
                stockProduits.put("Pizza",stockProduits.get("Pizza")+1);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    /**
     * Méthode qui enclenche la production d'une barquette de frites qui prendra
     * une durée donnée.
     *
     * @param dureeEnMillisecondes  durée de préparation en ms de type 'int'
     * */
    public void preparationFrites(int dureeEnMillisecondes) {
        this.frites_en_cours_de_preparation = true;
        Timer timer = new Timer(dureeEnMillisecondes, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Etat.this.frites_en_cours_de_preparation = false;
                // Ajout d'une barquette de frites au stock de produits après sa préparation
                stockProduits.put("Frites",stockProduits.get("Frites")+1);
            }
        });
        timer.setRepeats(false);
        timer.start();

    }

    /**
     * Méthode qui enclenche la production d'un wrap qui prendra
     * une durée donnée.
     *
     * @param dureeEnMillisecondes  durée de préparation en ms de type 'int'
     * */
    public void preparationWrap( int dureeEnMillisecondes) {
        this.wrap_en_cours_de_preparation = true;
        Timer timer = new Timer(dureeEnMillisecondes, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Etat.this.wrap_en_cours_de_preparation = false;
                // Ajout d'un wrap au stock de produits après sa préparation
                stockProduits.put("Wrap",stockProduits.get("Wrap")+1);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    /**
     * Methode qui, d'après la selection des ingredients, si celle-ci correspond à une
     * recette pour un produit alors on augmente sa quantité de 1 et on vide la selection
     * @return produit  le nom du produit créé,
     *         vide sinon
     */
    public String production(){
        // Burger : Pain, tomate, viande, sauce
        HashSet <String> recetteBurger = new HashSet<>(Arrays.asList("pain","tomate","viande","sauce"));
        // Frites : patate, huile, sel
        HashSet <String> recetteFrites = new HashSet<>(Arrays.asList("patate","huile","sel"));
        // Pizza : pate, tomate, fromage, sauce
        HashSet <String> recettePizza = new HashSet<>(Arrays.asList("pate","tomate","fromage","sauce"));
        // Wrap : tortilla, poulet, salade, fromage
        HashSet <String> recetteWrap = new HashSet<>(Arrays.asList("tortilla","poulet","salade","fromage"));

        // Nom du produit généré
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



    /**
     * Méthode qui renvoie l'état du jeu, et donc si le joueur a perdu.
     *
     * @return true  si le nombre de clients insatisfaits dépasse 5,
     *         false sinon
     * */
    public boolean gameOver(){
        // Si le nombre de clients insastisfaits dépasse 5
        // Alors le jeu est fini
        return clients_insatisfaits > 5;
        // Sinon non
    }


    /**
     * Méthode qui met à jour le nombre de clients générés en l'incrémentant.
     *
     * */
    public void updateCompteurClients(){
        this.compteurClients++;
    }

    /**
     * Méthode qui ajoute un produit choisi au contenu du plateau si son stock est disponible
     * Diminue le stock en conséquence
     *
     * @param product  le nom du produit à ajouter au plateau de type 'String'
     * */
    public void addToTray(String product) {
        //si le stock n'est pas nul
        if(stockProduits.getOrDefault(product,0) != 0) {
            trayContent.put(product, trayContent.getOrDefault(product, 0) + 1);
            stockProduits.put(product,stockProduits.get(product)-1);
        }
    }

    /**
     * Méthode qui vide le plateau après avoir ajouté son contenu au stock
     *
     * */
    public void cancelTray() {
        for (Map.Entry<String, Integer> entry : trayContent.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();

            // On ajoute la quantité au stock
            stockProduits.put(product, stockProduits.get(product) + quantity);
        }
        // Vide le plateau
        trayContent.clear();
    }

    /**
     * Méthode qui sert le client si la commande du client en cours correspond
     * au contenu du plateau et supprime le client en cours et vide le plateau
     * en conséquent.
     *
     */
    public void serveTray() {
        if(!fileVide()) {
            Client clientEnCours = this.getClients().getListeClients().get(client_en_cours);
            // Si la file n'est pas vide et la commande du client en cours correspond au contenu du plateau
            if (CommandeEqualTray(clientEnCours.getCommande())) {
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
    }

    /**
     * Méthode qui retourne un booleen indiquant si une commande précise correspond
     * au contenu du plateau.
     *
     * @retaurn true  si la commande donnée correspond au contenu du plateau,
     *          false sinon
     *
     * */
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