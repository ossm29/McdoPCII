package Vue;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AffichageBarreDeProgression extends JProgressBar {


    public AffichageBarreDeProgression() {
        Font angryFont = null;
        try {
            //creation de la police d'affichage, taille 15
            angryFont = Font.createFont(Font.TRUETYPE_FONT, new File("ressources/fonts/angrybirds-regular.ttf")).deriveFont(15f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(angryFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        this.setPreferredSize(new Dimension(320, 35));
        this.setMinimum(0);
        this.setMaximum(35);
        //ajout de la police
        this.setFont(angryFont);
        this.setStringPainted(true);
        //texte sur la barre
        this.setString("EN ATTENTE DE CLIENTS");

    }
}
