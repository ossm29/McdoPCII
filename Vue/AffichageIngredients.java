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

/**
 * Classe AffichageIngredients hérite de la classe 'JPanel' de Swing.
 * Gère l'affichage de la barre d'ingrédients en bas de l'écran de
 * l'utilisateur.
 * INUTILISEE POUR L'INSTANT
 * @version 1.0
 * */
public class AffichageIngredients extends JPanel {

    /** Constantes fenêtre */

    /* Largeur fenêtre 990 */
    public static final int LARGEUR = 990;
    /* Hauteur fenêtre 110 */
    public static final int HAUTEUR = 110;

    /** Variables */

    /* Variable Etat que notre classe retranscrira en affichage */
    private Etat etat;
    /* Permet l'affichage des animations dans l'affichage serveur */
    private AffichageServeur affichageServeur;

    /* Images des ingrédients */
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



    /**
     *  Constructeur
     *  Gère l'affichage de la barre des ingrédients, ainsi que les boutons
     *  "Annuler" et "Valider" qui contribueront à la sélection des ingrédients.
     *
     * @param etat              l'état courant du jeu de type 'Etat'
     * @param affichageServeur  l'affichage serveur de l'application de type 'AffichageServeur'
     *  */
    public AffichageIngredients(Etat etat, AffichageServeur affichageServeur){
       // Définition de l'état du jeu
        this.setEtat(etat);
        // Définition des dimensions du JPanel
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));
        // Définition de l'affichage serveur
        this.affichageServeur = affichageServeur;

        /* Images des ingrédients */

        // Chargement des fichiers contenant les images
        File fileBread = new File("ressources/ingredients/bread.png");
        File fileOil = new File("ressources/ingredients/oil.png");
        File filePotato = new File("ressources/ingredients/potato.png");
        File fileTomato = new File("ressources/ingredients/tomato.png");
        File fileCheese = new File("ressources/ingredients/mask.png");
        File filePate = new File("ressources/ingredients/rouleau-a-patisserie.png");
        File fileSteak = new File("ressources/ingredients/steak.png");
        File fileSauce = new File("ressources/ingredients/sauce.png");
        File fileSalade = new File("ressources/ingredients/cabbage.png");
        File filePoulet = new File("ressources/ingredients/poulet-frit.png");
        File fileTortilla = new File("ressources/ingredients/tortillas.png");
        File fileSel = new File("ressources/ingredients/sel.png");

        // Récupération des images
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
        // Ajout du boutonAnnuler au JPanel
        this.add(boutonAnnuler);

        /* Bouton valider selection */
        JButton boutonValider = new JButton("Valider");
        //Définir la position du bouton
        boutonValider.setLayout(null);
        boutonValider.setBounds(900,25,80,30);
        boutonValider.addActionListener(new ControlIngredientsValider(this.etat,this));
        boutonValider.setBackground(Color.white);
        boutonValider.setFocusPainted(false);
        // Ajout du boutonValider au JPanel
        this.add(boutonValider);

    }


    /** Gettesr */

    /**
     * Retourne l'état actuel de l'application.
     *
     * @return l'état courant  de type 'Etat'
     * */
    public Etat getEtat() {
        return etat;
    }

    /**
     * Retourne l'affichage serveur actuel de l'application
     *
     * @return l'affichage serveur courant  de type 'AffichageServeur'
     * */
    public AffichageServeur getAffichageServeur() { return this.affichageServeur;}


    /** Setter */

    /**
     * Définit l'état de l'application.
     *
     * @param etat l'état à définir de type 'Etat'
     * */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }


    /**
     * Méthode qui dessine les ingrédients en dessous d'une bordure noire
     * ainsi que les graphismes lors de leur sélection.
     *
     * @param g  l'objet graphique de l'interface  de type 'Graphics'
     * */
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

    /**
     * Méthode qui dessine et affiche les ingrédients avec l'image associée à chacun.
     *
     * @param g  l'objet graphique de l'interface  de type 'Graphics'
     * */
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

    /**
     * Méthode qui dessine un oval vert lors de la sélection d'un ingrédient.
     *
     * @param g  l'objet graphique de l'interface  de type 'Graphics'
     * */
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
