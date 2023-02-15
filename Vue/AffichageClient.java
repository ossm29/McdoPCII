package Vue;

import Controleur.Control;
import Controleur.ControlClientClicDroit;
import Controleur.ControlClientClicGauche;
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
    private miniAffichageClient miniAffichageClient;

    /* Constructeurs */
    public AffichageClient(Etat etat){
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));               	/* On définit les dimensions de notre JPanel */

        this.setEtat(etat);
        this.miniAffichageClient = new miniAffichageClient(this.etat);


        /* Boutton Gauche et Droit*/
        JButton boutongauche = new JButton("<");
        JButton boutondroit = new JButton(">");
        /* Dimensions Boutons */
        boutongauche.setPreferredSize(new Dimension(40, 290));
        boutondroit.setPreferredSize(new Dimension(40,290));
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

        /* Jpanel du haut pour afficher la colère et une jauge de temps - a faire plus tard dans une classe a part- */
        JPanel nord = new JPanel();
        nord.setPreferredSize(new Dimension(380, 40));
        nord.setBackground(Color.white);

        /* On organise nos sections */
        this.add(nord, BorderLayout.NORTH);
        this.add(boutongauche, BorderLayout.WEST);
        this.add(miniAffichageClient, BorderLayout.CENTER);
        this.add(boutondroit, BorderLayout.EAST);


    }

    /* Affichage */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);
        this.setBackground((new Color(255, 193, 59)));
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
