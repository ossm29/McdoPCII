package Modele;
/**Ingrédients permettant de collecter des ressources.produits*/
public class Ingredient {
    /* Attribut */
    private String nom;

    /** Constructeur */
    public Ingredient(String nom){
        this.nom = nom;
    }

    /* Getter */
    public String getNom(){
        return this.nom;
    }

    /* Setter */
    public void setNom(String nom){
        this.nom = nom;
    }
}
