package Modele;
import java.util.ArrayList;
import java.util.Random;

public class Commande {

    private ArrayList<Produit>produits = new ArrayList<>();

    public void Commande() {

        // Pour l'instant aucun produit n'est dans notre panier
        this.produits = new ArrayList<Produit>();

        // Notre menu
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("burger");
        menu.add("pizza");
        menu.add("plastic-cup");
        menu.add("piece-of-cake");
        menu.add("sushi");
        menu.add("french-fries");

        // Chaque client commande au plus 6 article - non produits - et au minimum 1 article
        Random random = new Random();
        int nbProduit = 1 + random.nextInt(6);
        // Chaque client commande au plus 3 produits différents
        for ( int i = 0;i<3 && nbProduit>0; i++){
            // On tire le produit aléatoirement
            int reference = random.nextInt(6);
            String nomProduit = menu.get(reference);
            // On tire une quantité au hasard
            int quantiteProduit = random.nextInt(nbProduit);
            // On ajoute le produit a notre commande
            this.produits.add(new Produit(nomProduit,quantiteProduit));
            System.out.println("ajoute");
            // On met a jour le nbProduit auquel on a droit pour le prochain tirage
            nbProduit = nbProduit - quantiteProduit;
        }
    }

    /* Méthode */
    public int calculPizza () {
        int total = 0;
        for (Produit produit : this.produits){
            if (produit.getNom() == "pizza"){
                total = total + produit.getQuantite();
            }
        }
        return total;
    }

    public int calculBurger () {
        int total = 0;
        for (Produit produit : this.produits){
            if (produit.getNom() == "burger"){
                total = total + produit.getQuantite();
            }
        }
        return total;
    }

    public int calculDessert () {
        int total = 0;
        for (Produit produit : this.produits){
            if (produit.getNom() == "piece-fo-cake"){
                total = total + produit.getQuantite();
            }
        }
        return total;
    }
    public int calculBoisson () {
        int total = 0;
        for (Produit produit : this.produits){
            if (produit.getNom() == "plastic-cup"){
                total = total + produit.getQuantite();
            }
        }
        return total;
    }
    public int calculSushi () {
        int total = 0;
        for (Produit produit : this.produits){
            if (produit.getNom() == "sushi"){
                total = total + produit.getQuantite();
            }
        }
        return total;
    }

    public int calculFrittes () {
        int total = 0;
        for (Produit produit : this.produits){
            if (produit.getNom() == "french-fries"){
                total = total + produit.getQuantite();
            }
        }
        return total;
    }
}
