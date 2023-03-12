package Vue;

import Modele.Commande;
import Modele.Etat;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/** Classe qui gère l'affichage des commandes en bas à droite de l'écran*/

public class AffichageCommande extends JPanel {
    public static final int LARGEUR = (int) (0.3* Etat.WIDTH);       	/* Largeur Fenetre */
    public static final int HAUTEUR = (int) (0.55*Etat.HEIGHT);       	/* Hauteur Fenetre */

    /* Variables */
    private Etat etat;                                                  	/* Variable Etat que notre classe retranscrira en affichage */

    /* Constructeurs */
    public AffichageCommande(Etat etat){
        this.setEtat(etat);
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));               	/* On définit les dimensions de notre JPanel */
    }

    /* Affichage */
    @Override
    public void paint(Graphics g) {
        super.paint(g);                                                     /* Effacer les précédents "dessin" */

        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);
        this.setBackground((new Color(31, 62, 89)));

        this.paintBurger(g);
        this.paintPizza(g);
        this.paintFrites(g);
        this.paintSushi(g);
        this.paintBoisson(g);
        this.paintDessert(g);
    }

    /*Getter Etat*/
    public Etat getEtat() {
        return etat;
    }

    /*Setter etat*/
    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    // DessinBurger
    public void paintBurger(Graphics g){
        /* Affichage Image */

        // On charge les fichiers
        File fileBurger = new File("ressources/burger.png");

        // On aura 1 images pour le produit
        BufferedImage imageburger = null;

        // On récupère ces images
        try {
            imageburger = ImageIO.read(fileBurger);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // On affiche les images
        g.drawImage(imageburger, 80, 50, 75, 75,this);
    }

    //Dessin Pizza
    public void paintPizza(Graphics g){
        /* Affichage Image */

        // On charge les fichiers
        File filePizza = new File("ressources/pizza.png");

        // On aura 1 images pour le produit
        BufferedImage imagepizza = null;

        // On récupère ces images
        try {
            imagepizza = ImageIO.read(filePizza);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // On affiche les images
        g.drawImage(imagepizza, 250, 50, 75, 75,this);
    }

    // Paint Frittes

    public void paintFrites(Graphics g){
        /* Affichage Image */

        // On charge les fichiers
        File file = new File("ressources/french-fries.png");

        // On aura 1 images pour le produit
        BufferedImage image = null;

        // On récupère ces images
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // On affiche les images
        g.drawImage(image, 80, 150, 75, 75,this);
    }

    public void paintSushi(Graphics g){
        /* Affichage Image */

        // On charge les fichiers
        File file = new File("ressources/sushi.png");

        // On aura 1 images pour le produit
        BufferedImage image = null;

        // On récupère ces images
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // On affiche les images
        g.drawImage(image, 250, 150, 75, 75,this);
    }

    public void paintBoisson(Graphics g){
        /* Affichage Image */

        // On charge les fichiers
        File file = new File("ressources/plastic-cup.png");

        // On aura 1 images pour le produit
        BufferedImage image = null;

        // On récupère ces images
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // On affiche les images
        g.drawImage(image, 80, 250, 75, 75,this);
    }

    public void paintDessert(Graphics g){
        /* Affichage Image */

        // On charge les fichiers
        File file = new File("ressources/piece-of-cake.png");

        // On aura 1 images pour le produit
        BufferedImage image = null;

        // On récupère ces images
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // On affiche les images
        g.drawImage(image, 250, 250, 75, 75,this);
    }

    /*méthode qui permet l'affichage de la commande :
    * on affiche l'icône du produit et la qté commandée
    * on affiche les produits par qté décroissante
    * */
/*    public void afficheCommande(Commande C, Graphics g) {
        HashMap Order = new HashMap<String,Integer >();
        Order.put("burger", C.calculBurger());
        Order.put("pizza", C.calculPizza());
        Order.put("plastic-cup",C.calculBoisson());
        Order.put("piece-of-cake", C.calculDessert());
        Order.put("sushi",C.calculSushi());
        Order.put("french-fries",C.calculFrittes());

        Order.;
    }*/
}
