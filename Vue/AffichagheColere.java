package Vue;

import Modele.Etat;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AffichagheColere extends JPanel {

    private Etat etat;

    public AffichagheColere(Etat etat) {
        this.setPreferredSize(new Dimension(40, 40));
        this.etat = etat;
    }

    public void paint(Graphics g){
        super.paint(g);
        /* Le degré de colère de notre client */
        int indicColere = this.etat.getClients().getListeClients().get(this.etat.getClient_en_cours()).getAnger();
        /* On prend le fichier correpondant a sa colère */
        File file = new File("ressources/colere" + indicColere + ".jpg");
        // On aura 6 images pour 6 plats ou produits différents
        BufferedImage image = null;
        // On récupère ces images
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
