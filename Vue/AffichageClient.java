package Vue;

import Controleur.Control;
import Controleur.ControlClientClicDroit;
import Controleur.ControlClientClicGauche;
import Modele.Etat;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.swing.plaf.synth.SynthProgressBarUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AffichageClient extends JPanel {

    /* Constantes Fenetre*/
    public static final int LARGEUR = (int) (0.3* Etat.WIDTH);                              	/* Largeur Fenetre */
    public static final int HAUTEUR = (int) (0.45*Etat.HEIGHT);                              	/* Hauteur Fenetre */

    /* Variables */
    private Etat etat;                                                  	/* Variable Etat que notre classe retranscrira en affichage */
    private miniAffichageClient miniAffichageClient;
    private AffichageIndicateurs indicateurs;

    /* Constructeurs */
    public AffichageClient(Etat etat){
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));               	/* On définit les dimensions de notre JPanel */

        this.setEtat(etat);
        this.miniAffichageClient = new miniAffichageClient(this.etat);


        /* Boutton Gauche et Droit*/
        JButton boutongauche = new JButton("<");
        JButton boutondroit = new JButton(">");
        /* Dimensions Boutons */
        boutongauche.setPreferredSize(new Dimension(40, 230));
        boutondroit.setPreferredSize(new Dimension(40,230));
        /* Decoration boutons */
        Font police = boutongauche.getFont(); // récupère la police actuelle
        Font nouvellePolice = new Font(police.getName(), police.getStyle(), police.getSize()-2);
        boutongauche.setFont(nouvellePolice);
        boutondroit.setFont(nouvellePolice);

        boutongauche.setBackground(Color.white);
        boutondroit.setBackground(Color.white);

        /* On ajoute les controleurs */
        boutongauche.addMouseListener(new ControlClientClicGauche(this.etat, this.miniAffichageClient));
        boutondroit.addMouseListener((new ControlClientClicDroit(this.etat, this.miniAffichageClient)));

        /* Barre de progression */
        this.indicateurs = new AffichageIndicateurs(this.etat);

        /* On organise nos sections */
        this.add(this.indicateurs, BorderLayout.NORTH);
        this.add(boutongauche, BorderLayout.WEST);
        this.add(miniAffichageClient, BorderLayout.CENTER);
        this.add(boutondroit, BorderLayout.EAST);


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
        // Bordure
        Border blackline = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(blackline);
        // Arrière plan
        this.setBackground(new Color(119, 181, 254));
    }
}
