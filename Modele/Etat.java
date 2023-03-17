package Modele;
import Vue.Clients;
import Vue.miniAffichageClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/* Ensemble des données qui caractériseront l'état de mon interface */
public class Etat {

    //

    /* Attributs concernant le Joueur et les clients */
    private int score;                          /* Score Joueur */
    private int compteurCLients = 1;            /* Nb de clients générés */
    private static int clients_insatisfaits;    /* Nb de client insatisfait */
    private Clients clients;                    /* La liste de tous les clients dans le magasin */
    private int client_en_cours;                /* index ( et NON PAS ID )  du client
                                                qui se fait traiter sa commande actuellement */
    private HashSet<String>selectionIngredients; /* Liste de tous les ingrédients selectionnés par le joueur afin de préparer un produit */

    /* Attributs concernants les stocks */
    private int quantiteBurger;
    private int quantitePizza;
    private int quantiteBoisson;
    private int quantiteWrap;
    private int quantiteFrites;
    private int quantiteDessert;

    /* Attributs préparation */

    private int dureePreparation = 5000; //durée de la préparation en ms
    private boolean burger_en_cours_de_preparation;
    private boolean pizza_en_cours_de_preparation;
    private boolean frittes_en_cours_de_preparation;
    private boolean wrap_en_cours_de_preparation;

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
        this.setQuantitewrap();
        this.setQuantitePizza();

        /* On initiase notre liste d'ingrédients selectionnés vide*/
        this.selectionIngredients = new HashSet<String>();

        /* On initialise nos varaibles en cours de preparation a false */
        this.setBurger_en_cours_de_preparation(false);
        this.setPizza_en_cours_de_preparation(false);
        this.setFrittes_en_cours_de_preparation(false);
        this.setWrap_en_cours_de_preparation(false);

    }

    /* Getters */
    public int getCompteurCLients(){
        return this.compteurCLients;
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
        return this.frittes_en_cours_de_preparation;
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
    public int getQuantiteBurger() {
        return quantiteBurger;
    }

    public int getQuantitePizza() {
        return quantitePizza;
    }

    public int getQuantiteBoisson() {
        return quantiteBoisson;
    }

    public int getQuantiteWrap() {
        return quantiteWrap;
    }

    public int getQuantiteFrites() {
        return quantiteFrites;
    }

    public int getQuantiteDessert() {
        return quantiteDessert;
    }

    public int getScore() { return score; }

    public int getClients_insatisfaits() { return clients_insatisfaits; }

    public int getDureePreparation() { return this.dureePreparation; }

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

    public void setQuantitewrap() {
        /* Entre 8 et 15 */
        Random random = new Random();
        this.quantiteWrap = 8 + random.nextInt(8);
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
        this.quantiteFrites = 8 + random.nextInt(8);
    }

    public void setBurger_en_cours_de_preparation(boolean bool){
        this.burger_en_cours_de_preparation = bool;
    }
    public void setPizza_en_cours_de_preparation(boolean bool){
        this.pizza_en_cours_de_preparation = bool;
    }
    public void setWrap_en_cours_de_preparation(boolean bool){
        this.wrap_en_cours_de_preparation = bool;
    }

    public void setFrittes_en_cours_de_preparation(boolean bool){
        this.frittes_en_cours_de_preparation = bool;
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
                Etat.this.quantiteBurger++;
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
                Etat.this.quantitePizza++;
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    // Méthode qui enclenche la production d'une barquette de frittes qui prendra un durée donnée en paramtre
    public void preparationFrittes( int dureeEnMillisecondes) {
        this.frittes_en_cours_de_preparation = true;
        Timer timer = new Timer(dureeEnMillisecondes, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Etat.this.frittes_en_cours_de_preparation = false;
                Etat.this.quantiteFrites++;
            }
        });
        timer.setRepeats(false);
        timer.start();

    }

    // Méthode qui enclenche la production d'un wrapqui prendra un durée donnée en paramtre
    public void preparationWrap( int dureeEnMillisecondes) {
        this.wrap_en_cours_de_preparation = true;
        Timer timer = new Timer(dureeEnMillisecondes, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Etat.this.wrap_en_cours_de_preparation = false;
                Etat.this.quantiteWrap++;
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    // Methode qui d'apres la selection des ingredients, si celle-ci correspond a une recette pour un produit alors on augmente sa quantite de 1 et on clear la selection
    // return le nom du produit créé, null sinon
    public String production(){
        //Burger : Pain, tomate, viande, sauce
        HashSet <String> recetteBurger = new HashSet<>(Arrays.asList("pain","tomate","viande","sauce"));
        // Frites : patate, huile, sel
        HashSet <String> recetteFrites = new HashSet<>(Arrays.asList("patate","huile","sel"));
        //Pizza : pate, tomate, fromage, viande , sauce
        HashSet <String> recettePizza = new HashSet<>(Arrays.asList("pate","tomate","fromage","viande","sauce"));
        //Wrap : tortilla, poulet, salade, sauce, fromage
        HashSet <String> recetteWrap = new HashSet<>(Arrays.asList("tortilla","poulet","salade","sauce","fromage"));

        //nom du produit généré
        String produit = "vide";

        if(this.getSelectionIngredients().equals(recetteBurger)) {
            if (!this.burger_en_cours_de_preparation) {
                this.preparationBurger(dureePreparation);
                this.selectionIngredients = new HashSet<>();
                produit = "burger";
            }
        } if(this.getSelectionIngredients().equals(recetteFrites)) {
            if (!this.frittes_en_cours_de_preparation) {
                this.preparationFrittes(dureePreparation);
                this.selectionIngredients = new HashSet<>();
                produit = "frites";
            }
        } if(this.getSelectionIngredients().equals(recettePizza)) {
            if (!this.pizza_en_cours_de_preparation) {
                this.preparationPizza(dureePreparation);
                this.selectionIngredients = new HashSet<>();
                produit = "pizza";
            }
        } if(this.getSelectionIngredients().equals(recetteWrap)) {
            if (!this.wrap_en_cours_de_preparation) {
                this.preparationWrap(dureePreparation);
                this.selectionIngredients = new HashSet<>();
                produit = "wrap";
            }
        }
        return produit;
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