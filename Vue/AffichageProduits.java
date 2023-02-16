package Vue;

import Modele.Etat;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AffichageProduits extends JPanel {
    public static final int LARGEUR = (int) (0.7*Etat.WIDTH);                              	/* Largeur Fenetre */
    public static final int HAUTEUR = (int) (0.25*Etat.HEIGHT);                              	/* Hauteur Fenetre */

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
        BufferedImage imageburger = null;
        BufferedImage imagefrites = null;
        BufferedImage imageboisson = null;
        BufferedImage imagepizza = null;
        BufferedImage imagedessert = null;
        BufferedImage imagesushi = null;

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
        g.setColor(Color.white);
        // On affiche les images des produits
        g.drawImage(imageburger, 80, 25, 75, 75,this);
        g.fillOval(85,110,60,60);

        g.drawImage(imagefrites, 230, 25, 75, 75,this);
        g.fillOval(235,110,60,60);

        g.drawImage(imagepizza, 380,25,75,75,this);
        g.fillOval(385,110,60,60);

        g.drawImage(imagesushi, 530,25,75,75,this);
        g.fillOval(535,110,60,60);

        g.drawImage(imageboisson, 680, 25, 75, 75,this);
        g.fillOval(685,110,60,60);

        g.drawImage(imagedessert, 830,25,75,75,this);
        g.fillOval(835,110,60,60);

        // On affiche les quantités des produits dans le stock
        g.setColor(Color.black);
        Font font = new Font("Serif", Font.PLAIN, 32);
        g.setFont(font);

        // Quantite
        int quantiteburger = this.etat.getQuantiteBurger();
        int quantitepizza = this.etat.getQuantitePizza();
        int quantitefritte = this.etat.getQuantiteFrittes();
        int quantitesushi = this.etat.getQuantiteSushi();
        int quantiteboisson = this.etat.getQuantiteBoisson();
        int quantitedessert = this.etat.getQuantiteDessert();


        if(quantiteburger>9){ g.drawString(quantiteburger+"", 100, 150); }
        else { g.drawString(quantiteburger+"", 108, 150); }

        if (quantitepizza>9){ g.drawString(quantitepizza+"", 251, 150);}
        else { g.drawString(quantitepizza+"", 257, 150);}

        if (quantitefritte>9) {g.drawString(quantitefritte+"", 400, 150); }
        else { g.drawString(quantitefritte+"", 408, 150); }

        if (quantitesushi>9) {g.drawString(quantitesushi+"", 550, 150); }
        else { g.drawString(quantitesushi+"", 559, 150); }

        if (quantiteboisson>9) {g.drawString(quantiteboisson+"", 700, 150); }
        else { g.drawString(quantiteboisson+"", 707, 150); }

        if (quantitedessert>9) {g.drawString(quantitedessert+"", 850, 150); }
        else { g.drawString(quantitedessert+"", 858, 150); }

    }
}
