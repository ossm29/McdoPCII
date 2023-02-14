package Vue;

import Modele.Serveur;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VueServeur {

    Serveur serveur;

    public VueServeur(){
        this.serveur = new Serveur();
        this.serveur.start();
    }

    public void dessiner(Graphics g){
        // On choisit l'image selon l'état du client
        String path_name = "Vue/serveur"+ (serveur.getEtatServeur()%11 + 1) + ".png";
        File fileClient = new File(path_name);
        // On aura 12 images pour 12 états différents
        BufferedImage imageclient = null;
        // On récupère ces images
        try {
            imageclient = ImageIO.read(fileClient);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // On affiche l'image
        g.drawImage(imageclient, 1, 1, 998, 598,null);
    }
}
