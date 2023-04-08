package Vue;

import Modele.Serveur;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Classe VueServeur représente la vue du serveur de l'application.
 * Elle utilise une instance de la classe 'Serveur' pour récupérer l'état du serveur
 * et afficher l'image correspondante.
 *
 * @version 1.0
 * */
public class VueServeur {

    /** Attribut */

    /* Instance utilisée pour récupérer l'état du serveur */
    Serveur serveur;

    /**
     * Constructeur
     * Initialise l'instance de 'Serveur' et démarre le serveur.
     *
     * */
    public VueServeur(){
        this.serveur = new Serveur();
        this.serveur.start();
    }

    /**
     * Méthode qui dessine l'image correspondante à l'état actuel du serveur.
     *
     * @param g  l'objet graphique de l'interface de type 'Graphics'
     * */
    public void dessiner(Graphics g){
        // On choisit l'image selon l'etat du client
        String path_name = "ressources/patron"+ (serveur.getEtat()%2) + ".png";
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
        g.drawImage(imageclient, 40, 480, 120, 120,null);
    }
}
