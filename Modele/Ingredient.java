package Modele;

/**
 * Classe Ingredient qui représente un ingrédient permettant de collecter
 * des produits du fichier "ressources.produits".
 *
 * @version 1.0
 * */
public class Ingredient {


    /** Attribut */

    /* Nom de l'ingrédient */
    private String nom;

    /**
     * Constructeur
     * Définit le nom d'un ingrédient précis donné en paramètres.
     *
     * @param nom  le nom de l'ingrédient de type 'String'
     * */
    public Ingredient(String nom){
        this.nom = nom;
    }

    /** Getter
     * Récupère et retourne le nom de l'ingrédient.
     *
     * @return le nom de l'ingrédient.
     * */
    public String getNom(){
        return this.nom;
    }

    /** Setter
     * Définit le nom de l'ingrédient.
     *
     * @param nom  le nom de l'ingrédient de type 'String'.
     * */
    public void setNom(String nom){
        this.nom = nom;
    }
}
