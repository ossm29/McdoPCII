package Modele;
/** IL FAUDRAIT FAIRE DU PRODUIT UN ENUM : FIXER LES VALEURS POSSIBLES **/
public class Produit {

    /* Attribut */
    private String nom;
    private int quantite;

    /* Constructeur */
    public Produit(String nom, int quantite){
        this.nom = nom;
        this.quantite = quantite;
    }

    /* Getter */
    public String getNom(){
        return this.nom;
    }
    public int getQuantite(){
        return this.quantite;
    }

    /* Setter */
    public void setNom(String nom, int quantite){
        this.nom = nom;
        this.quantite = quantite;
    }
}
