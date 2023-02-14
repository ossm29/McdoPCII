package Vue;

import Vue.AffichageServeur;
import Vue.AffichageProduits;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AffichageGauche extends JPanel{

    private AffichageServeur affichageServeur;
    private AffichageProduits affichageProduits;

    public AffichageGauche(AffichageServeur affichage, AffichageProduits affichageProduits){
        this.affichageServeur = affichage;
        this.affichageProduits = affichageProduits;
        this.setPreferredSize(new Dimension(1000,800));
        this.add(this.affichageServeur, BorderLayout.NORTH);
        this.add(this.affichageProduits, BorderLayout.SOUTH);
    }

    /*Getter*/

    public AffichageProduits getAffichageProduits() {
        return affichageProduits;
    }
    public AffichageServeur getAffichageServeur(){
        return affichageServeur;
    }

    // Affichage
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
