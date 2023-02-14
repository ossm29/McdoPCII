package Vue;

import Modele.Etat;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AffichageClient extends JPanel {

    /* Constantes Fenetre*/
    public static final int LARGEUR = 400;                              	/* Largeur Fenetre */
    public static final int HAUTEUR = 350;                              	/* Hauteur Fenetre */

    /* Variables */
    private Etat etat;                                                  	/* Variable Etat que notre classe retranscrira en affichage */
    private VueClients vueClients;

    /* Constructeurs */
    public AffichageClient(Etat etat){
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));               	/* On définit les dimensions de notre JPanel */

        this.setEtat(etat);
        this.vueClients = new VueClients(this);

    }

    /* Affichage */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);
        this.setBackground((new Color(255, 193, 59)));
        try {
            this.vueClients.dessiner(g);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*File fileClient = new File("Vue/client10.png");

        // On aura 6 images pour 6 plats ou produits différents
        BufferedImage imageclient = null;

        // On récupère ces images
        try {
            imageclient = ImageIO.read(fileClient);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // On affiche l'image
        g.drawImage(imageclient, 25, 25, 350, 300,this);
        //g.fillRect(25,25,350,300);*/

    }


    /*Getter Etat*/
    public Etat getEtat() {
        return etat;
    }

    /*Setter etat*/
    public void setEtat(Etat etat) {
        this.etat = etat;
    }

}
