package Vue;

import Controleur.ControlIngredientsCancel;
import Controleur.ControlIngredientsValider;
import Modele.Etat;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/** Classe qui gère l'affichage de la barre d'ingrédients en bas de l'écran */
public class AffichageIngredients extends JPanel {
    public static final int LARGEUR = 990;                              	   /* Largeur Fenetre */
    public static final int HAUTEUR = 110;                              	/* Hauteur Fenetre */

    /* Variables */
    private Etat etat;                                                  	/* Variable Etat que notre classe retranscrira en affichage */

    /* Image des ingédients */
    private BufferedImage imageBread;
    private BufferedImage imageOil;
    private BufferedImage imagePotato;
    private BufferedImage imageTomato;

    private BufferedImage imageCheese;
    private BufferedImage imageMeat;
    private BufferedImage imagePate;
    private BufferedImage imageSauce;
    private BufferedImage imageSalade;
    private BufferedImage imagePoulet;
    private BufferedImage imageTortilla;
    private BufferedImage imageSalt;

    private AnimationTimer burgerTimer;

    /* Constructeurs */
    public AffichageIngredients(Etat etat){
        this.setEtat(etat);
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));               	/* On définit les dimensions de notre JPanel */

        /* Images des ingrédients */

        // On charge les fichiers
        File fileBread = new File("ressources/ingredients/bread.png");
        File fileOil = new File("ressources/ingredients/oil.png");
        File filePotato = new File("ressources/ingredients/potato.png");
        File fileTomato = new File("ressources/ingredients/tomato.png");
        File fileCheese = new File("ressources/mask.png");
        File filePate = new File("ressources/rouleau-a-patisserie.png");
        File fileSteak = new File("ressources/steak.png");
        File fileSauce = new File("ressources/sauce.png");
        File fileSalade = new File("ressources/cabbage.png");
        File filePoulet = new File("ressources/poulet-frit.png");
        File fileTortilla = new File("ressources/tortillas.png");
        File fileSel = new File("ressources/sel.png");
        // On récupère ces images
        try {
            imageBread = ImageIO.read(fileBread);
            imageOil = ImageIO.read(fileOil);
            imagePotato = ImageIO.read(filePotato);
            imageTomato = ImageIO.read(fileTomato);
            imageCheese = ImageIO.read(fileCheese);
            imagePate = ImageIO.read(filePate);
            imageMeat = ImageIO.read(fileSteak);
            imageSauce = ImageIO.read(fileSauce);
            imageSalade = ImageIO.read(fileSalade);
            imagePoulet = ImageIO.read(filePoulet);
            imageTortilla = ImageIO.read(fileTortilla);
            imageSalt = ImageIO.read(fileSel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* Bouton annuler */
        JButton boutonAnnuler = new JButton("Annuler");
        //Définir la position du bouton
        this.setLayout(null);
        boutonAnnuler.setLayout(null);
        boutonAnnuler.setBounds(900,65,80,30);
        boutonAnnuler.addActionListener(new ControlIngredientsCancel(this.etat,this));
        boutonAnnuler.setBackground(Color.white);
        boutonAnnuler.setFocusPainted(false);
        //on l'ajoute au JPanel
        this.add(boutonAnnuler);

        /* Bouton valider selection */
        JButton boutonValider = new JButton("Valider");
        //Définir la position du bouton
        boutonValider.setLayout(null);
        boutonValider.setBounds(900,25,80,30);
        boutonValider.addActionListener(new ControlIngredientsValider(this.etat,this));
        boutonValider.setBackground(Color.white);
        boutonValider.setFocusPainted(false);
        //on l'ajoute au JPanel
        this.add(boutonValider);

    }


    /*Getter Etat*/
    public Etat getEtat() {
        return etat;
    }

    /*Setter etat*/
    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public void lancerBurgerTimer() {
        this.burgerTimer = new AnimationTimer(etat.getDureePreparation()/1000,40,50,50);
        this.burgerTimer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //Bordure
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);
        // Arrière-plan
        this.setBackground(new Color(215, 113, 113));


        this.drawIngredients(g);
        this.drawSelection(g);
        if(this.etat.isBurger_en_cours_de_preparation() || this.etat.isFrittes_en_cours_de_preparation()) {
            this.burgerTimer.dessineTimer(g);
        }
    }

    public void drawIngredients(Graphics g){

        // On affiche les images des ingrédients LIGNE 1
        g.drawImage(this.imageBread, 40, 10, 50, 50,this);
        g.drawImage(this.imageOil, 190, 10, 50, 50,this);
        g.drawImage(this.imagePotato, 340,10,45,45,this);
        g.drawImage(this.imageTomato, 483,10,50,50,this);
        g.drawImage(this.imageCheese, 638,13,42,42,this);
        g.drawImage(this.imagePate, 780,13,43,43,this);

        // On affiche les images des ingredients LIGNE 2
        // On affiche les images des ingrédients
        g.drawImage(this.imageMeat, 43, 60, 45, 45,this);
        g.drawImage(this.imageSalade, 194, 64, 40, 40,this);
        g.drawImage(this.imageSauce, 340,63,40,40,this);
        g.drawImage(this.imagePoulet, 488,60,45,45,this);
        g.drawImage(this.imageTortilla, 640,63,38,38,this);
        g.drawImage(this.imageSalt, 780,64,45,45,this);
    }

    public void drawSelection(Graphics g){
        //Couleur du cercle
        g.setColor(Color.green);
        //On déclare la liste des ingrédients
        String[] Ingredients = {"pain","huile","patate","tomate","fromage","pate","viande","salade","sauce","poulet","tortilla","sel"};
        //Coordonnée X des cercles
        int[] xPositions = {85,235,385,535,680,827};
        //Coordonnée Y des cercles
        int yPosition = 5;
        for(int i = 0; i <Ingredients.length;i++) {
            //Au delà du 5e ingrédient on affiche en 2e ligne
            if(i > 5) { yPosition = 50; }
            if (this.etat.getSelectionIngredients().contains(Ingredients[i])){
                g.fillOval(xPositions[i%6],yPosition,13,13);
            }
        }
    }


}
