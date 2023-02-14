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
    public static final int LARGEUR = 1000;                              	/* Largeur Fenetre */
    public static final int HAUTEUR = 200;                              	/* Hauteur Fenetre */

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
        super.paint(g);

        /* Affichage Image */

        // On charge les fichiers
        File fileBurger = new File("Vue/burger.png");
        File fileFrittes = new File("Vue/french-fries.png");
        File fileBoisson = new File("Vue/plastic-cup.png");
        File filePizza = new File("Vue/pizza.png");
        File fileDessert = new File ("vue/piece-of-cake.png");
        File fileSushi = new File ("Vue/sushi.png");

        // On aura 6 images pour 6 plats ou produits différents
        BufferedImage imageburger = null;
        BufferedImage imagefrittes = null;
        BufferedImage imageboisson = null;
        BufferedImage imagepizza = null;
        BufferedImage imagedessert = null;
        BufferedImage imagesushi = null;

        // On récupère ces images
        try {
            imageburger = ImageIO.read(fileBurger);
            imageboisson = ImageIO.read(fileBoisson);
            imagefrittes = ImageIO.read(fileFrittes);
            imagepizza = ImageIO.read(filePizza);
            imagesushi = ImageIO.read(fileSushi);
            imagedessert = ImageIO.read(fileDessert);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // On affiche les images
        g.drawImage(imageburger, 80, 50, 75, 75,this);
        g.drawImage(imagefrittes, 230, 50, 75, 75,this);
        g.drawImage(imagepizza, 380,50,75,75,this);
        g.drawImage(imagesushi, 530,50,75,75,this);
        g.drawImage(imageboisson, 680, 50, 75, 75,this);
        g.drawImage(imagedessert, 830,50,75,75,this);
    }
}
