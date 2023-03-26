package Modele;
import java.util.ArrayList;
import java.util.Random;

public class Commande {

    private ArrayList<Produit>produits;

    public Commande() {

        // Pour l'instant aucun produit n'est dans notre panier
        this.produits = new ArrayList<Produit>();

        // Notre menu
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("burger");
        menu.add("frites");
        menu.add("pizza");
        menu.add("wrap");
        menu.add("boisson");
        menu.add("gateau");


        // Chaque client commande au plus 6 article - non ressources.produits - et au minimum 1 article
        Random random = new Random();
        int nbProduit = 1+random.nextInt(6);
        // Chaque client commande au plus 3 ressources.produits différents
        for ( int i = 0; i<3 && nbProduit>0; i++){
            // On tire le produit aléatoirement
            int reference = random.nextInt(menu.size());
            String nomProduit = menu.get(reference);
            //on ne peut pas ajouter un produit 2 fois à la liste donc on le retire du menu après l'avoir sélectionné
            menu.remove(reference);
            // On tire une quantité au hasard entre 1 et notre nb de produit max restant
            int quantiteProduit = 1 + random.nextInt(nbProduit);
            // On ajoute le produit a notre commande , si il est déjà présent on augmente sa qté
            this.produits.add(new Produit(nomProduit,quantiteProduit));
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
    public int calculwrap () {
        int total = 0;
        for (Produit produit : this.produits){
            if (produit.getNom() == "wrap"){
                total = total + produit.getQuantite();
            }
        }
        return total;
    }

    public int calculFrites() {
        int total = 0;
        for (Produit produit : this.produits){
            if (produit.getNom() == "french-fries"){
                total = total + produit.getQuantite();
            }
        }
        return total;
    }

    public int calculTout(){
        int total = 0;
        for (Produit produit : this.produits) {
            total = total + produit.getQuantite();
        }
        return total;
    }

    public ArrayList<Produit> getProduits() {
        return this.produits;
    }


}
