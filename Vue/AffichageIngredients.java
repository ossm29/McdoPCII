package Vue;

import Modele.Etat;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/** Classe qui gère l'affichage de la barre d'ingrédients en bas de l'écran */
public class AffichageIngredients extends JPanel {
    public static final int LARGEUR = (int) (0.7*Etat.WIDTH);                              	   /* Largeur Fenetre */
    public static final int HAUTEUR = (int) (0.25*Etat.HEIGHT)/2;                              	/* Hauteur Fenetre */

    /* Variables */
    private Etat etat;                                                  	/* Variable Etat que notre classe retranscrira en affichage */

    /* Constructeurs */
    public AffichageIngredients(Etat etat){
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

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //Bordure
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);
        // Arrière-plan
        this.setBackground(new Color(215, 113, 113));

        g.drawString("Ingrédients : ", 5,15);

        /* Affichage Images */

        // On charge les fichiers
        File fileBread = new File("ressources/ingredients/bread.png");
        File fileOil = new File("ressources/ingredients/oil.png");
        File filePotato = new File("ressources/ingredients/potato.png");
        File fileTomato = new File("ressources/ingredients/tomato.png");

        // On a 4 images pour les ingrédients
        BufferedImage imageBread;
        BufferedImage imageOil;
        BufferedImage imagePotato;
        BufferedImage imageTomato;


        // On récupère ces images
        try {
            imageBread = ImageIO.read(fileBread);
            imageOil = ImageIO.read(fileOil);
            imagePotato = ImageIO.read(filePotato);
            imageTomato = ImageIO.read(fileTomato);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // On affiche les images des ingrédients
        g.drawImage(imageBread, 80, 15, 50, 50,this);

        g.drawImage(imageOil, 230, 15, 50, 50,this);

        g.drawImage(imagePotato, 380,15,50,50,this);

        g.drawImage(imageTomato, 530,15,50,50,this);

    }


}
