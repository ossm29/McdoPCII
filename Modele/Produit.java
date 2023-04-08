package Modele;
/** TODO : AJOUTER ATTRIBUT PRIX **/

/**
 * Classe Produit représente un produit avec son nom et la quantité associée.
 * Elle est utilisée pour stocker des informations sur les produits dans l'application.
 *
 * @version 1.0
 * */
public class Produit {

    /** Attributs */

    /* Nom du produit */
    private String nom;
    /* Quantité disponible du produit */
    private int quantite;

    /**
     * Constructeur
     * Définit les instances nécessaires de la classe.
     *
     * @param nom       le nom du produit de type 'String'
     * @param quantite  la quantité disponible du produit de type 'int'
     * */
    public Produit(String nom, int quantite){
        this.nom = nom;
        this.quantite = quantite;
    }

    /** Getters */

    /**
     * Renvoie le nom du produit.
     *
     * @return le nom du produit.
     * */
    public String getNom(){
        return this.nom;
    }

    /**
     * Renvoie la quantité disponible associée au produit.
     *
     * @return  la quantité disponible.
     * */
    public int getQuantite(){
        return this.quantite;
    }

    /** Setter */

    /**
     * Définit le nom et la quantité d'un produit.
     *
     * @param nom       le nom du produit de type 'String'
     * @param quantite  la quantité disponible du produit de type 'int'
     * */
    public void setNom(String nom, int quantite){
        this.nom = nom;
        this.quantite = quantite;
    }
}
