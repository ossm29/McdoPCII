package Vue;

import Controleur.ControlIngredientsCancel;
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
        JButton btn = new JButton("Annuler");
        //Définir la position du bouton
        this.setLayout(null);
        btn.setLayout(null);
        btn.setBounds(900,50,60,20);
        btn.addActionListener(new ControlIngredientsCancel(this.etat,this));
        //on l'ajoute au JPanel
        this.add(btn);
    }


    /*Getter Etat*/
    public Etat getEtat() {
        return etat;
    }

    /*Setter etat*/
    public void setEtat(Etat etat) {
        this.etat = etat;
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
    }

    public void drawIngredients(Graphics g){

        // On affiche les images des ingrédients LIGNE 1
        g.drawImage(this.imageBread, 80, 10, 50, 50,this);
        g.drawImage(this.imageOil, 230, 10, 50, 50,this);
        g.drawImage(this.imagePotato, 380,10,45,45,this);
        g.drawImage(this.imageTomato, 527,10,50,50,this);
        g.drawImage(this.imageCheese, 678,13,42,42,this);
        g.drawImage(this.imagePate, 820,13,43,43,this);

        // On affiche les images des ingredients LIGNE 2
        // On affiche les images des ingrédients
        g.drawImage(this.imageMeat, 83, 60, 45, 45,this);
        g.drawImage(this.imageSalade, 234, 64, 40, 40,this);
        g.drawImage(this.imageSauce, 380,63,40,40,this);
        g.drawImage(this.imagePoulet, 528,60,45,45,this);
        g.drawImage(this.imageTortilla, 680,63,38,38,this);
        g.drawImage(this.imageSalt, 820,64,45,45,this);
    }

    public void drawSelection(Graphics g){
        //Couleur du cercle
        g.setColor(Color.green);
        //On déclare la liste des ingrédients
        String[] Ingredients = {"pain","huile","patate","tomate","fromage","pate","viande","salade","sauce","poulet","tortilla","sel"};
        //Coordonnée X des cercles
        int[] xPositions = {125,275,425,575,720,867};
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
