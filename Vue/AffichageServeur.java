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
    public static final int LARGEUR = 1000;                            	/* Largeur Fenetre */
    public static final int HAUTEUR = 800;                             	/* Hauteur Fenetre */
    
    /* Variables */
    private Etat etat;                                                  	/* Variable Etat que notre classe retranscrira en affichage */
    private VueServeur vueServeur;
    private String notification;
    private Boolean affichageNotification;

    /* Font de police */
    private Font font;

    /* Images des produits */
    private BufferedImage imageBurger;
    private BufferedImage imagePizza;
    private BufferedImage imageCaKE;
    private BufferedImage imageSushi;
    private BufferedImage imageFrittes;
    private BufferedImage imageBoisson;

    /* Image des ingédients */
    private BufferedImage imageBread;
    private BufferedImage imageOil;
    private BufferedImage imagePotato;
    private BufferedImage imageTomato;

    /* Constructeurs */
    public AffichageServeur(Etat etat){
        /* On définit les dimensions de notre JPanel */
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));

        /* Les attributs */
        this.setEtat(etat);
        this.vueServeur = new VueServeur();
        this.affichageNotification = false;
        this.notification = "";

        /* Police d'écriture */
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

        /* Image des produits */

        // On charge les fichiers
        File fileBurger = new File("ressources/burger.png");
        File fileFrittes = new File("ressources/french-fries.png");
        File fileBoisson = new File("ressources/plastic-cup.png");
        File filePizza = new File("ressources/pizza.png");
        File fileDessert = new File ("ressources/piece-of-cake.png");
        File fileSushi = new File ("ressources/sushi.png");

        // On récupère ces images
        try {
            this.imageBurger = ImageIO.read(fileBurger);
            this.imageBoisson= ImageIO.read(fileBoisson);
            this.imageFrittes = ImageIO.read(fileFrittes);
            this.imagePizza = ImageIO.read(filePizza);
            this.imageSushi = ImageIO.read(fileSushi);
            this.imageCaKE = ImageIO.read(fileDessert);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* Images des ingrédients */

        // On charge les fichiers
        File fileBread = new File("ressources/ingredients/bread.png");
        File fileOil = new File("ressources/ingredients/oil.png");
        File filePotato = new File("ressources/ingredients/potato.png");
        File fileTomato = new File("ressources/ingredients/tomato.png");

        // On récupère ces images
        try {
            imageBread = ImageIO.read(fileBread);
            imageOil = ImageIO.read(fileOil);
            imagePotato = ImageIO.read(filePotato);
            imageTomato = ImageIO.read(fileTomato);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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

        // On paramètre notre police d'écriture en attribut
        this.setFont(this.font);

        // On affiche le score et le nombre de clients insatisfaits
        this.drawStats(g);
        // On affiche le patron
        this.vueServeur.dessiner(g);
        // On affiche les notifs - dans le cas ou y en a -
        this.dessinerNotification(g);
        // On affiche les produits
        this.drawProducts(g);
        // On affiche les ingrédients
        this.drawIngredients(g);
        // On affiche la selection
        this.drawSelection(g);
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

    public void drawProducts(Graphics g){

        // Couleur de fond
        g.setColor(new Color(245, 240, 225));
        g.fillRect(0,600,1000,80);

        // On affiche les images
        g.drawImage(this.imageBurger, 80, 615, 55, 55,this);
        g.drawImage(this.imageFrittes, 230, 615, 55, 55,this);
        g.drawImage(this.imagePizza, 380,615,55,55,this);
        g.drawImage(this.imageSushi, 530,615,55,55,this);
        g.drawImage(this.imageBoisson, 680, 620, 50, 50,this);
        g.drawImage(this.imageCaKE, 830,615,55,55,this);

        // On affiche les cercles au dessus des produits
        g.setColor(Color.white);
        g.fillOval(125,605,30,30);
        g.fillOval(265,605,30,30);
        g.fillOval(416,605,30,30);
        g.fillOval(560,605,30,30);
        g.fillOval(710,605,30,30);
        g.fillOval(865,605,30,30);

        // On affiche les quantités des produits dans le stock
        g.setColor(Color.black);

        // Quantite
        int quantiteburger = this.etat.getQuantiteBurger();
        int quantitepizza = this.etat.getQuantitePizza();
        int quantitefrites = this.etat.getQuantiteFrittes();
        int quantitesushi = this.etat.getQuantiteSushi();
        int quantiteboisson = this.etat.getQuantiteBoisson();
        int quantitedessert = this.etat.getQuantiteDessert();


        if(quantiteburger>9){ g.drawString(quantiteburger+"", 133,626); }
        else { g.drawString(quantiteburger+"", 137, 626); }

        if (quantitepizza>9){ g.drawString(quantitepizza+"", 425, 626);}
        else { g.drawString(quantitepizza+"", 428, 626);}

        if (quantitefrites>9) {g.drawString(quantitefrites+"", 273, 626); }
        else { g.drawString(quantitefrites+"", 275, 626); }

        if (quantitesushi>9) {g.drawString(quantitesushi+"", 569, 626); }
        else { g.drawString(quantitesushi+"", 571, 626); }

        if (quantiteboisson>9) {g.drawString(quantiteboisson+"", 719, 626); }
        else { g.drawString(quantiteboisson+"", 722, 626); }

        if (quantitedessert>9) {g.drawString(quantitedessert+"", 873, 626); }
        else { g.drawString(quantitedessert+"", 876, 626); }
    }

    public void drawIngredients(Graphics g){

        // On affiche les images des ingrédients LIGNE 1
        g.drawImage(this.imageBread, 80, 690, 50, 50,this);
        g.drawImage(this.imageOil, 230, 690, 50, 50,this);
        g.drawImage(this.imagePotato, 380,690,50,50,this);
        g.drawImage(this.imageTomato, 530,690,50,50,this);
        g.drawImage(this.imageTomato, 680,690,50,50,this);
        g.drawImage(this.imageTomato, 820,690,50,50,this);

        // On affiche les images des ingredients LIGNE 2
        // On affiche les images des ingrédients
        g.drawImage(this.imageBread, 80, 740, 50, 50,this);
        g.drawImage(this.imageOil, 230, 740, 50, 50,this);
        g.drawImage(this.imagePotato, 380,740,50,50,this);
        g.drawImage(this.imageTomato, 530,740,50,50,this);
        g.drawImage(this.imageTomato, 680,740,50,50,this);
        g.drawImage(this.imageTomato, 820,740,50,50,this);
    }

    public void drawSelection(Graphics g){
        if (this.etat.getSelectionIngredients().contains("pain")){
            g.setColor(Color.green);
            g.fillOval(125,695,13,13);
        }
        if (this.etat.getSelectionIngredients().contains("huile")){
            g.setColor(Color.green);
            g.fillOval(267,695,13,13);
        }
        if (this.etat.getSelectionIngredients().contains("patate")){
            g.setColor(Color.green);
            g.fillOval(425,695,13,13);
        }
        if (this.etat.getSelectionIngredients().contains("tomate")){
            g.setColor(Color.green);
            g.fillOval(575,695,13,13);
        }
    }
}