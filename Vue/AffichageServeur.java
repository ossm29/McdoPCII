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
import java.net.http.WebSocket;


/* Ma classe Affichage qui définira la vue, dans notre cas elle traduire les données de la Classe Etat en affichage pour l'utilisateur  */
public class AffichageServeur extends JPanel {

    /* Constantes Fenetre*/
    public static final int LARGEUR = 1000;                              	/* Largeur Fenetre */
    public static final int HAUTEUR = 800;                              	/* Hauteur Fenetre */
    
    /* Variables */
    private Etat etat;                                                  	/* Variable Etat que notre classe retranscrira en affichage */
    private VueServeur vueServeur;
    private String notification;

    // Attribut qui indique si oui ou non la notif est affichée
    private Boolean affichageNotification;

    // Police d'écriture utilisée
    private Font font;

    // Images utilisées à l'affichage
    private BufferedImage decor;
    private BufferedImage imageBurger;
    private BufferedImage imageFrittes;
    private BufferedImage imagePizza;
    private BufferedImage imageSushi;
    private BufferedImage imageBoisson;
    private BufferedImage imageCake;

    /* Constructeurs */
    public AffichageServeur(Etat etat){
        /* On définit les dimensions de notre JPanel */
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));

        /* Les attributs */
        this.setEtat(etat);
        this.vueServeur = new VueServeur();
        this.affichageNotification = false;
        this.notification = "";

        /* Image de Fond*/
        String path_name = "ressources/restaurant.png";
        File file = new File(path_name);
        // On aura 12 images pour 12 états différents
        this.decor = null;
        // On récupère ces images
        try {
            this.decor = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Police d'écriture
        this.font = null;
        try {
            //creation de la police d'affichage, taille 15
            this.font = Font.createFont(Font.TRUETYPE_FONT, new File("ressources/fonts/angrybirds-regular.ttf")).deriveFont(15f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(this.font);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        // Images Produits
        File fileBurger = new File("ressources/burger.png");
        File fileFrittes = new File("ressources/french-fries.png");
        File fileBoisson = new File("ressources/plastic-cup.png");
        File filePizza = new File("ressources/pizza.png");
        File fileDessert = new File ("ressources/piece-of-cake.png");
        File fileSushi = new File ("ressources/sushi.png");
        // On récupère ces images
        try {
            this.imageBurger  = ImageIO.read(fileBurger);
            this.imageBoisson = ImageIO.read(fileBoisson);
            this.imageFrittes = ImageIO.read(fileFrittes);
            this.imagePizza   = ImageIO.read(filePizza);
            this.imageSushi   = ImageIO.read(fileSushi);
            this.imageCake    = ImageIO.read(fileDessert);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
        // Dessin du décor
        this.drawDecor(g);
        /* Arrière Plan et Bordures */
        setBackground((new Color(48, 78, 56)));
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);

        // Police d'écriture
        this.setFont(this.font);
        /* Score et Nombre de Clients insatisfait */
        this.drawStats(g);
        /* Affichage Patron */
        this.vueServeur.dessiner(g);
        // Affichage Notification quand un nouveau client arrive
        this.dessinerNotification(g);
        // Dessin produits
        this.drawProducts(g);
        // Dessin chargement

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
        g.drawImage(this.decor, 0, 0, 1000, 600,null);
    }

    public void drawProducts(Graphics g){

        g.setColor(Color.PINK);
        g.fillRect(0, 600,1000,100);
        // Police d'ecriture
        g.setColor(Color.white);
        // On affiche les images des produits
        g.drawImage(this.imageBurger,85,625,50,50,this);
        g.drawImage(this.imageFrittes, 230, 625, 50, 50,this);
        g.drawImage(this.imagePizza, 380,625,50,50,this);
        g.drawImage(this.imageSushi, 530,625,50,50,this);
        g.drawImage(this.imageBoisson, 680, 625, 50, 50,this);
        g.drawImage(this.imageCake, 830,625,50,50,this);

        // TODO LES QUANTITES
        /*
        g.fillOval(85,710,60,60);
        g.fillOval(235,710,60,60);
        g.fillOval(385,710,60,60);
        g.fillOval(535,710,60,60);
        g.fillOval(685,710,60,60);
        g.fillOval(835,710,60,60);

        // On affiche les quantités des produits dans le stock
        g.setColor(Color.black);
        Font font = new Font("Serif", Font.PLAIN, 32);
        g.setFont(font);


        if(this.etat.getQuantiteBurger()>9){ g.drawString(this.etat.getQuantiteBurger()+"", 100, 150); }
        else { g.drawString(this.etat.getQuantiteBurger()+"", 108, 150); }

        if (this.etat.getQuantitePizza()>9){ g.drawString(this.etat.getQuantitePizza()+"", 251, 150);}
        else { g.drawString(this.etat.getQuantitePizza()+"", 257, 150);}

        if (this.etat.getQuantiteFrittes()>9) {g.drawString(this.etat.getQuantiteFrittes()+"", 400, 150); }
        else { g.drawString(this.etat.getQuantiteFrittes()+"", 408, 150); }

        if (this.etat.getQuantiteSushi()>9) {g.drawString(this.etat.getQuantiteSushi()+"", 550, 150); }
        else { g.drawString(this.etat.getQuantiteSushi()+"", 559, 150); }

        if (this.etat.getQuantiteBoisson()>9) {g.drawString(this.etat.getQuantiteBoisson()+"", 700, 150); }
        else { g.drawString(this.etat.getQuantiteBoisson()+"", 707, 150); }

        if (this.etat.getQuantiteDessert()>9) {g.drawString(this.etat.getQuantiteDessert()+"", 850, 150); }
        else { g.drawString(this.etat.getQuantiteDessert()+"", 858, 150); }
        */
    }
}