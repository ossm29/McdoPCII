package Vue;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Classe AffichageBarreDeProgression hérite de la classe 'JProgressBar'
 * de Swing et affiche la barre d'énervement des clients.
 *
 * @version 1.0
 * */
public class AffichageBarreDeProgression extends JProgressBar {

    /**
     * Constructeur
     * Initialise la police de caractères personnalisée,
     * la dimension de la barre de progression, les valeurs minimale
     * et maximale de la barre et le texte à afficher.
     *
     */
    public AffichageBarreDeProgression() {
        Font angryFont = null;
        try {
            // Création de la police de caractères à partir du fichier
            // situé dans le dossier ressources/fonts/angrybirds-regular.ttf.
            // Taille 15
            angryFont = Font.createFont(Font.TRUETYPE_FONT, new File("ressources/fonts/angrybirds-regular.ttf")).deriveFont(15f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // Enregistrement de la police de caractères dans l'environnement graphique local.
            ge.registerFont(angryFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        // Dimension de la barre de progression
        this.setPreferredSize(new Dimension(320, 35));
        // Valeur minimale de la barre de progression
        this.setMinimum(0);
        // Valeur maximale de la barre de progression
        this.setMaximum(35);
        // Ajout de la police de caractères à la barre de progression
        this.setFont(angryFont);
        // Activation de l'affichage du texte sur la barre
        this.setStringPainted(true);
        // Texte à afficher sur la barre
        this.setString("EN ATTENTE DE CLIENTS");

    }
}
