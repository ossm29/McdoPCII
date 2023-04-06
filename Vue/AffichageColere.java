package Vue;

import Modele.Etat;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * Classe AffichageColere hérite de la classe 'JPanel' de Swing.
 * Elle représente l'affichage de la colère du client dans notre application
 * en modifiant leur image.
 *
 * @version 1.0
 * */
public class AffichageColere extends JPanel {

    /** Attributs */

    /* Variable Etat que notre classe retranscrira en affichage */
    Etat etat;

    /**
     * Constructeur
     * Gère l'affichage dy JPanel ainsi que l'état choisi de l'application.
     *
     * @param etat  l'état choisi de l'application de type 'Etat'
     * */
    public AffichageColere(Etat etat){
        // Définition des dimensions de notre JPanel
        this.setPreferredSize(new Dimension(40, 40));
        this.etat = etat;
    }

    /** Affichage */

    /**
     * Méthode paint qui appelle la méthode "paintColere"
     * pour dessiner l'image correspondant à l'état de colère du client.
     *
     * @param g  l'object Graphics utilisé pour dessiner l'image de type 'Graphics'
     * */
    public void paint(Graphics g){
        super.paint(g);
        this.paintColere(g);
    }

    /**
     * Méthode qui dessine l'image correspondant à l'état de colère du client actuel.
     * L'image est choisie en fonction de l'état de colère du client.
     *
     * @param g l'objet Graphics utilisé pour dessiner l'image de type 'Graphics'
     */

    public void paintColere(Graphics g){
        // On choisit l'image à afficher selon la colère du client
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
