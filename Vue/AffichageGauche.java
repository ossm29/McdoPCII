package Vue;

import javax.swing.*;
import java.awt.*;

public class AffichageGauche extends JPanel{

    private AffichageServeur affichageServeur;
    private AffichageProduits affichageProduits;

    private AffichageIngredients affichageIngredients;

    public AffichageGauche(AffichageServeur affichage, AffichageProduits affichageProduits, AffichageIngredients affichageIngredients){
        this.affichageServeur = affichage;
        this.affichageProduits = affichageProduits;
        this.affichageIngredients = affichageIngredients;
        this.setPreferredSize(new Dimension(1000,850));
        this.add(this.affichageServeur, BorderLayout.NORTH);
        this.add(this.affichageIngredients, BorderLayout.SOUTH);
    }

    /*Getter*/

    public AffichageProduits getAffichageProduits() {
        return affichageProduits;
    }
    public AffichageServeur getAffichageServeur(){
        return affichageServeur;
    }

    // Affichage
/*    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }*/
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
