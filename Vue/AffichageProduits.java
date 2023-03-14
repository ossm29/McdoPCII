package Vue;

import Modele.Etat;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/** Classe qui gère l'affichage de la barre de produits en bas de l'écran */
public class AffichageProduits extends JPanel {
    public static final int LARGEUR = (int) (0.7*Etat.WIDTH);                              	   /* Largeur Fenetre */
    public static final int HAUTEUR = (int) (0.25*Etat.HEIGHT / 2);                              	/* Hauteur Fenetre */

    /* Variables */
    private Etat etat;                                                  	/* Variable Etat que notre classe retranscrira en affichage */

    /* Constructeurs */
    public AffichageProduits(Etat etat){
        this.setEtat(etat);
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));               	/* On définit les dimensions de notre JPanel */
    }

    /*Getter Etat*/
    public Etat getEtat() {
        return etat;
    }

    /*Setter etat*/
    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    /* Affichage */
    @Override
    public void paint(Graphics g) {

        super.paint(g);

        /* Arrière Plan et Bordures */
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);
        setBackground((new Color(245, 240, 225)));


        /* Affichage Image */

        // On charge les fichiers
        File fileBurger = new File("ressources/burger.png");
        File fileFrittes = new File("ressources/french-fries.png");
        File fileBoisson = new File("ressources/plastic-cup.png");
        File filePizza = new File("ressources/pizza.png");
        File fileDessert = new File ("ressources/piece-of-cake.png");
        File fileSushi = new File ("ressources/sushi.png");

        // On aura 6 images pour 6 plats ou produits différents
        BufferedImage imageburger;
        BufferedImage imagefrites;
        BufferedImage imageboisson;
        BufferedImage imagepizza;
        BufferedImage imagedessert;
        BufferedImage imagesushi;

        // On récupère ces images
        try {
            imageburger = ImageIO.read(fileBurger);
            imageboisson = ImageIO.read(fileBoisson);
            imagefrites = ImageIO.read(fileFrittes);
            imagepizza = ImageIO.read(filePizza);
            imagesushi = ImageIO.read(fileSushi);
            imagedessert = ImageIO.read(fileDessert);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Police d'ecriture
        g.setColor(Color.red);
        // On affiche les images des produits
        g.drawImage(imageburger, 80, 15, 75, 75,this);
        g.fillOval(125,5,40,40);

        g.drawImage(imagefrites, 230, 15, 75, 75,this);
        g.fillOval(265,5,40,40);

        g.drawImage(imagepizza, 380,15,75,75,this);
        g.fillOval(410,5,40,40);

        g.drawImage(imagesushi, 530,15,75,75,this);
        g.fillOval(560,5,40,40);

        g.drawImage(imageboisson, 680, 15, 75, 75,this);
        g.fillOval(710,5,40,40);

        g.drawImage(imagedessert, 830,15,75,75,this);
        g.fillOval(865,5,40,40);

        // On affiche les quantités des produits dans le stock
        g.setColor(Color.black);
        Font font = new Font("Serif", Font.PLAIN, 32);
        g.setFont(font);

        // Quantite
        int quantiteburger = this.etat.getQuantiteBurger();
        int quantitepizza = this.etat.getQuantitePizza();
        int quantitefrites = this.etat.getQuantiteFrittes();
        int quantitesushi = this.etat.getQuantiteSushi();
        int quantiteboisson = this.etat.getQuantiteBoisson();
        int quantitedessert = this.etat.getQuantiteDessert();


        if(quantiteburger>9){ g.drawString(quantiteburger+"", 128,32); }
        else { g.drawString(quantiteburger+"", 135, 32); }

        if (quantitepizza>9){ g.drawString(quantitepizza+"", 410, 32);}
        else { g.drawString(quantitepizza+"", 417, 32);}

        if (quantitefrites>9) {g.drawString(quantitefrites+"", 268, 32); }
        else { g.drawString(quantitefrites+"", 275, 32); }

        if (quantitesushi>9) {g.drawString(quantitesushi+"", 562, 32); }
        else { g.drawString(quantitesushi+"", 568, 32); }

        if (quantiteboisson>9) {g.drawString(quantiteboisson+"", 713, 32); }
        else { g.drawString(quantiteboisson+"", 720, 32); }

        if (quantitedessert>9) {g.drawString(quantitedessert+"", 868, 32); }
        else { g.drawString(quantitedessert+"", 875, 32); }

    }
}
