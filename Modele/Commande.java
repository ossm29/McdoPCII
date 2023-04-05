package Modele;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *  Class Commande représente une commande passée par un client.
 *
 *  Elle contient une liste de produits choisis aléatoirement parmi un menu prédéfini.
 *  Elle possède des méthodes pour calculer la quantité de certains produits dans la commande,
 *  pour obtenir la liste des produits de la commande et pour calculer le prix total de la commande.
 *
 * @version 1.0
 * */
public class Commande {

    /** Attribut */

    /* Liste de produits représentant une commande */
    private ArrayList<Produit>produits;

    /**
     * Constructeur
     * Crée une nouvelle commande en choisissant des produits
     * aléatoirement parmi un menu prédéfini.
     *
     */
    public Commande() {

        // Pour l'instant aucun produit n'est dans notre panier
        this.produits = new ArrayList<Produit>();

        // Notre menu
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("Burger");
        menu.add("Frites");
        menu.add("Pizza");
        menu.add("Wrap");
        menu.add("Boisson");
        menu.add("Gateau");


        // Chaque client commande au plus 6 articles et au minimum 1 article (depuis ressource.produits)
        Random random = new Random();
        int nbProduit = 1+random.nextInt(6);
        // Chaque client commande au plus 4 produits différents (depuis ressources.produits)
        for ( int i = 0; i<3 && nbProduit>0; i++){
            // On tire le produit aléatoirement
            int reference = random.nextInt(menu.size());
            String nomProduit = menu.get(reference);
            // On ne peut pas ajouter un produit 2 fois à la liste donc on le retire du menu après l'avoir sélectionné
            menu.remove(reference);
            // On tire une quantité au hasard entre 1 et notre nb de produit max restant
            int quantiteProduit = 1 + random.nextInt(nbProduit);
            // On ajoute le produit à notre commande, s'il est déjà présent on augmente sa qté
            this.produits.add(new Produit(nomProduit,quantiteProduit));
            // On met à jour le nbProduit auquel on a droit pour le prochain tirage
            nbProduit = nbProduit - quantiteProduit;
        }
    }

    /**
     * Calcule la quantité de pizzas dans la commande.
     *
     * @return total  la quantité de pizzas dans la commande de type 'int'.
     */
    public int calculPizza () {
        int total = 0;
        for (Produit produit : this.produits){
            if (produit.getNom() == "pizza"){
                total = total + produit.getQuantite();
            }
        }
        return total;
    }

    /**
     * Calcule la quantité de burgers dans la commande.
     *
     * @return total  la quantité de burgers dans la commande de type 'int'.
     */
    public int calculBurger () {
        int total = 0;
        for (Produit produit : this.produits){
            if (produit.getNom() == "burger"){
                total = total + produit.getQuantite();
            }
        }
        return total;
    }

    /**
     * Calcule la quantité de desserts dans la commande.
     *
     * @return total  la quantité de desserts dans la commande de type 'int'.
     */
    public int calculDessert () {
        int total = 0;
        for (Produit produit : this.produits){
            if (produit.getNom() == "piece-fo-cake"){
                total = total + produit.getQuantite();
            }
        }
        return total;
    }

    /**
     * Calcule la quantité de boissons dans la commande.
     *
     * @return total  la quantité de boissons dans la commande de type 'int'.
     */
    public int calculBoisson () {
        int total = 0;
        for (Produit produit : this.produits){
            if (produit.getNom() == "plastic-cup"){
                total = total + produit.getQuantite();
            }
        }
        return total;
    }

    /**
     * Calcule la quantité de wraps dans la commande.
     *
     * @return total  la quantité de wraps dans la commande de type 'int'.
     */
    public int calculwrap () {
        int total = 0;
        for (Produit produit : this.produits){
            if (produit.getNom() == "wrap"){
                total = total + produit.getQuantite();
            }
        }
        return total;
    }

    /**
     * Calcule la quantité de frites dans la commande.
     *
     * @return total  la quantité de frites dans la commande de type 'int'.
     */
    public int calculFrites() {
        int total = 0;
        for (Produit produit : this.produits){
            if (produit.getNom() == "french-fries"){
                total = total + produit.getQuantite();
            }
        }
        return total;
    }

    /**
     * Calcule le nombre de produits total dans la commande.
     *
     * @return total  le nombre de produits total dans la commande de type 'int'.
     */
    public int calculTout(){
        int total = 0;
        for (Produit produit : this.produits) {
            total = total + produit.getQuantite();
        }
        return total;
    }

    /** Getter */

    /**
     * Obtient et renvoie la commande du client
     * qui est représentée par la liste de produits.
     *
     * @return produits  la commande du client de type 'ArrayList<Produit>'
     * */
    public ArrayList<Produit> getProduits() {
        return this.produits;
    }

    /**
     * Calcul et renvoie le prix total de la commande du client.
     *
     * @return res  le prix total de la commande du client
     *              de type 'int'
     * */
    public int getPrix() {
        int res = 0;
        // On récupère le prix des produits
        HashMap<String, Integer> listePrix = Etat.getPrixProduits();

        for (Produit produit : this.getProduits()) {
            res += produit.getQuantite()*listePrix.get(produit.getNom());
        }
        return res;
    }

}
