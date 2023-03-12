package Vue;
import java.awt.Dimension;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import Modele.Etat;
import Vue.VueServeur;

import java.awt.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/* Ma classe Affichage qui définira la vue, dans notre cas elle traduire les données de la Classe Etat en affichage pour l'utilisateur  */
public class AffichageServeur extends JPanel {

    /* Constantes Fenetre*/
    public static final int LARGEUR = (int) (0.7*Etat.WIDTH);                              	/* Largeur Fenetre */
    public static final int HAUTEUR = (int) (0.75*Etat.HEIGHT);                              	/* Hauteur Fenetre */
    
    /* Variables */
    private Etat etat;                                                  	/* Variable Etat que notre classe retranscrira en affichage */
    private VueServeur vueServeur;
    private String notification;
    private Boolean affichageNotification;

    /* Constructeurs */
    public AffichageServeur(Etat etat){
        /* On définit les dimensions de notre JPanel */
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));

        /* Les attributs */
        this.setEtat(etat);
        this.vueServeur = new VueServeur();
        this.affichageNotification = false;
        this.notification = "";



    }

    /** fonction de dessin du score et des clients insatisfaits
     * @param g objet graphique
     */
    public void drawStats(Graphics g) {
        /* on dessine un carré blanc à l'endroit où on écrira le score*/
        g.clearRect(700,50,238,35);
        /* on affiche le score (converti en chaîne de caractères) */

        g.drawString("SCORE : "+Integer.toString(this.etat.getScore()),710,73);
        g.setColor(Color.red);
        g.drawString(" | Clients insatisfaits : "+Integer.toString(this.etat.getClients_insatisfaits()),775,73);
        g.setColor(Color.BLACK);
        g.drawRect(700, 50, 238, 35);
    }
    
    /*Getter Etat*/
	public Etat getEtat() {
		return etat;
	}
	
	/*Setter etat*/
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
    public void setNotification(String notif) { this.notification = notif;}

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        this.drawDecor(g);
        /* Arrière Plan et Bordures */
        setBackground((new Color(48, 78, 56)));
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);

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
        this.setFont(angryFont);

        /* Score*/
        this.drawStats(g);
        /* Affichage Serveur */
        this.vueServeur.dessiner(g);
        // Affichage Notification
        this.dessinerNotification(g);

    }

    public void afficherTexteTemporairement(String texte, int dureeEnMillisecondes) {
        this.notification = texte;
        this.affichageNotification = true;

        Timer timer = new Timer(dureeEnMillisecondes, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AffichageServeur.this.affichageNotification = false;
                repaint();
            }
        });
        timer.setRepeats(false);
        timer.start();

        repaint();
    }

    public void dessinerNotification(Graphics g) {
        if (affichageNotification) {
            g.setColor(Color.WHITE);
            g.fillRect(50, 50, 220, 35);
            g.setColor(Color.BLACK);
            g.drawString(notification, 60, 75);
            g.setColor(Color.BLACK);
            g.drawRect(50, 50, 220, 35);
        }
    }

    public void drawDecor(Graphics g){
        String path_name = "ressources/restaurant.png";
        File fileClient = new File(path_name);
        // On aura 12 images pour 12 états différents
        BufferedImage image = null;
        // On récupère ces images
        try {
            image = ImageIO.read(fileClient);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // On affiche l'image
        g.drawImage(image, 0, 0, 1000, 600,null);
    }
}