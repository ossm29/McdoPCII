package Vue;

import Modele.Etat;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AffichageColere extends JPanel {

    Etat etat;

    public AffichageColere(Etat etat){
        this.setPreferredSize(new Dimension(40, 40));
        this.etat = etat;
    }

    public void paint(Graphics g){
        super.paint(g);
        this.paintColere(g);
    }

    public void paintColere(Graphics g){
        /* On choisit l'image a afficher selon la colere du client */
        if (this.etat.fileVide() == false) {
            String path_name = "ressources/colere" + (this.etat.getClients().getListeClients().get(this.etat.getClient_en_cours()).getAnger() % 6 + 1) + ".jpg";
            File file = new File(path_name);
            // On aura 12 images pour 12 états différents
            BufferedImage image = null;
            // On récupère ces images
            try {
                image = ImageIO.read(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            g.drawImage(image, 3, 3, 35, 35, null);
        }
    }
}
