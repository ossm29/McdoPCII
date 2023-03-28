package Vue;
import java.awt.Dimension;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import Controleur.ControlDragDrop;
import Controleur.ControlPlateauCancel;
import Controleur.ControlPlateauServir;
import Controleur.ControlServeurAide;
import Modele.Etat;

import java.awt.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


/* Ma classe Affichage qui définira la vue, dans notre cas elle traduire les données de la Classe Etat en affichage pour l'utilisateur  */
public class AffichageServeur extends JPanel {

    /* Constantes Fenetre*/
    public static final int LARGEUR = 990;                            	/* Largeur Fenetre */
    public static final int HAUTEUR = 680;                             	/* Hauteur Fenetre */
    
    /* Variables */
    private Etat etat;                                                  	/* Variable Etat que notre classe retranscrira en affichage */
    private VueServeur vueServeur;
    private String notification;
    private Boolean affichageNotification;
    //indique si on affiche l'aide
    private Boolean displayHelp = false;

    /* Font de police */
    private Font font;

    /* Images des ressources.produits */
    private BufferedImage imageBurger;
    private BufferedImage imagePizza;
    private BufferedImage imageGateau;
    private BufferedImage imageWrap;
    private BufferedImage imageFrites;
    private BufferedImage imageBoisson;

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

    //Plateau
    private int trayWidth = 300;
    private int trayHeight = 200;


    /** ANIMATIONS */
    private AnimationTimer burgerTimer;
    private AnimationTimer fritesTimer;
    private AnimationTimer pizzaTimer;
    private AnimationTimer wrapTimer;


    /* Constructeurs */
    public AffichageServeur(Etat etat){
        /* On définit les dimensions de notre JPanel */
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));

        /* Les attributs */
        this.setEtat(etat);
        this.vueServeur = new VueServeur();
        this.affichageNotification = false;
        this.notification = "";

        ControlDragDrop controlDragDrop = new ControlDragDrop(this.etat,this);
        this.addMouseListener(controlDragDrop);
        this.addMouseMotionListener(controlDragDrop);


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

        /* Image des ressources.produits */

        // On charge les fichiers
        File fileBurger = new File("ressources/produits/burger.png");
        File fileFrites = new File("ressources/produits/frites.png");
        File fileBoisson = new File("ressources/produits/boisson.png");
        File filePizza = new File("ressources/produits/pizza.png");
        File fileGateau = new File ("ressources/produits/gateau.png");
        File fileWrap = new File ("ressources/produits/wrap.png");

        // On récupère ces images
        try {
            this.imageBurger = ImageIO.read(fileBurger);
            this.imageBoisson= ImageIO.read(fileBoisson);
            this.imageFrites = ImageIO.read(fileFrites);
            this.imagePizza = ImageIO.read(filePizza);
            this.imageWrap = ImageIO.read(fileWrap);
            this.imageGateau = ImageIO.read(fileGateau);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* Images des ingrédients */

        // On charge les fichiers
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


        /* Bouton aide */
        JButton boutonAide = new JButton("?");
        boutonAide.addActionListener(new ControlServeurAide(this.etat,this));

        //Définir la position du bouton
        this.setLayout(null);
        boutonAide.setLayout(null);
        boutonAide.setBounds(900,625,80,30);
        boutonAide.setBackground(Color.white);
        //on l'ajoute au JPanel
        this.add(boutonAide);

        /* Bouton Annuler plateau */
        JButton boutonVider = new JButton("X");
        boutonVider.addActionListener(new ControlPlateauCancel(this.etat,this));
        boutonVider.setLayout(null);
        boutonVider.setBounds(165,475,30,30);
        this.add(boutonVider);

        /* Bouton Servir plateau */
        JButton boutonServir = new JButton("OK");
        boutonServir.addActionListener(new ControlPlateauServir(this.etat,this));
        boutonServir.setLayout(null);
        boutonServir.setBounds(505,475,30,30);
        this.add(boutonServir);
    }

    /** fonction de dessin du score et des clients insatisfaits
     * @param g objet graphique
     */
    public void drawStats(Graphics g) {
        /* on dessine un carré blanc à l'endroit où on écrira le score*/
        g.clearRect(580,50,350,35);
        /* on affiche le score (converti en chaîne de caractères) */

        g.drawString("SCORE : "+Integer.toString(this.etat.getScore()),710,73);
        g.setColor(Color.red);
        g.drawString(" | Clients insatisfaits : "+Integer.toString(this.etat.getClients_insatisfaits()),775,73);
        g.drawString("Clients servis : "+Integer.toString(this.etat.getClients_servis())+" | ",590,73);
        g.setColor(Color.BLACK);

        g.drawRect(580, 50, 350, 35);
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
        /* Arrière Plan et Bordures */
        setBackground(new Color(245, 240, 225));
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);

        // On paramètre notre police d'écriture en attribut
        this.setFont(this.font);
        // On affiche le decor
        //this.drawDecor(g);
        // On affiche le score et le nombre de clients insatisfaits
        this.drawStats(g);
        // On affiche le patron
        //! this.vueServeur.dessiner(g);
        // On affiche les notifs - dans le cas ou y en a -
        this.dessinerNotification(g);
        // On affiche les ressources.produits
        this.drawProducts(g);
        // On affiche les ingrédients
        //this.drawIngredients(g);
        // On affiche la selection
        //this.drawSelection(g);

        //Si un produit est en production on affiche son timer
        if(this.etat.isBurger_en_cours_de_preparation()) {
            this.burgerTimer.dessineTimer(g);
        } if(this.etat.isFrites_en_cours_de_preparation()) {
            this.fritesTimer.dessineTimer(g);
        } if(this.etat.isPizza_en_cours_de_preparation()) {
            this.pizzaTimer.dessineTimer(g);
        } if(this.etat.isWrap_en_cours_de_preparation()) {
            this.wrapTimer.dessineTimer(g);
        }

        if(this.displayHelp) {
            this.drawHelp(g);
        }

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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.drawDecor(g);
        this.drawTray(g);
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

     /** Affiche l'arrière plan */
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
        g.drawImage(image, 1, 1, 988, 600,null);
    }

    /** Méthode affichant l'aide*/
    public void drawHelp(Graphics g) {
        String path_name = "ressources/recettespcii.png";
        File fileHelp = new File(path_name);
        // image
        BufferedImage image = null;
        // On récupère l'image
        try {
            image = ImageIO.read(fileHelp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // On affiche l'image
        g.drawImage(image, 200, 1, 500, 500,null);
    }

    public void drawProducts(Graphics g){

        // Couleur de fond
        //g.setColor(new Color(245, 240, 225));
        //g.fillRect(0,600,1000,80);

        // On affiche les images
        g.drawImage(this.imageBurger, 40, 615, 55, 55,this);
        g.drawImage(this.imageFrites, 190, 615, 55, 55,this);
        g.drawImage(this.imagePizza, 340,615,55,55,this);
        g.drawImage(this.imageWrap, 490,615,55,55,this);
        g.drawImage(this.imageBoisson, 630, 620, 50, 50,this);
        g.drawImage(this.imageGateau, 770,615,55,55,this);

        // On affiche les cercles au dessus des ressources.produits
        g.setColor(Color.white);
        g.fillOval(85,605,30,30);
        g.fillOval(225,605,30,30);
        g.fillOval(376,605,30,30);
        g.fillOval(533,605,30,30);
        /* Commenté car pas de quantité pour les desserts */
        //g.fillOval(710,605,30,30);
        //g.fillOval(865,605,30,30);

        // On affiche les quantités des ressources.produits dans le stock
        g.setColor(Color.black);

        // Quantite
        int quantiteburger = this.etat.getStockBurger();
        int quantitepizza = this.etat.getStockPizza();
        int quantitefrites = this.etat.getStockFrites();
        int quantitewrap = this.etat.getStockWrap();
        int quantiteboisson = this.etat.getStockBoisson();
        int quantitedessert = this.etat.getStockGateau();


        if(quantiteburger>9){ g.drawString(quantiteburger+"", 93,626); }
        else { g.drawString(quantiteburger+"", 97, 626); }

        if (quantitepizza>9){ g.drawString(quantitepizza+"", 385, 626);}
        else { g.drawString(quantitepizza+"", 388, 626);}

        if (quantitefrites>9) {g.drawString(quantitefrites+"", 233, 626); }
        else { g.drawString(quantitefrites+"", 235, 626); }

        if (quantitewrap>9) {g.drawString(quantitewrap+"", 542, 626); }
        else { g.drawString(quantitewrap+"", 545, 626); }

        //Commenté car pas de quantité pour les desserts
        /*if (quantiteboisson>9) {g.drawString(quantiteboisson+"", 719, 626); }
        else { g.drawString(quantiteboisson+"", 722, 626); }

        if (quantitedessert>9) {g.drawString(quantitedessert+"", 873, 626); }
        else { g.drawString(quantitedessert+"", 876, 626); }*/
    }

    /** Méthode affichant le plateau*/
    public void drawTray(Graphics g) {
        String path_name = "ressources/tray.png";
        File filePlateau = new File(path_name);
        // image
        BufferedImage image = null;
        // On récupère l'image
        try {
            image = ImageIO.read(filePlateau);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // On affiche l'image
        g.drawImage(image, 200, 400, trayWidth, trayHeight,null);

        // On affiche les icônes et les quantités de produits
        int col = 0;
        int row = 0;
        int iconSize = 40;
        int xOffset = 25;
        int yOffset = 50;
        int xSpacing = 90;
        int ySpacing = 50;
        int maxIconsPerRow = 3;
        Font font = new Font("Arial", Font.BOLD, 16);
        g.setFont(font);

        for (Map.Entry<String, Integer> entry : etat.getTrayContent().entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            BufferedImage productImage = this.getImage(product);

            int xPos = 200 + xOffset + col * xSpacing;
            int yPos = 400 + yOffset + row * ySpacing;

            g.drawImage(productImage, xPos, yPos, iconSize, iconSize, null);
            g.drawString("x" + quantity, xPos + iconSize + 5, yPos + iconSize - 5);

            col++;
            if (col == maxIconsPerRow) {
                col = 0;
                row++;
            }
        }
    }

    /** ANIMATIONS*/
    public void lancerBurgerTimer() {
        this.burgerTimer = new AnimationTimer(etat.getDureePreparation(),30,85,605);
        this.burgerTimer.start();
    }

    public void lancerFritesTimer() {
        this.fritesTimer = new AnimationTimer(etat.getDureePreparation(),30,225,605);
        this.fritesTimer.start();
    }

    public void lancerPizzaTimer() {
        this.pizzaTimer = new AnimationTimer(etat.getDureePreparation(),30,376,605);
        this.pizzaTimer.start();
    }

    public void lancerWrapTimer() {
        this.wrapTimer = new AnimationTimer(etat.getDureePreparation(),30,533,605);
        this.wrapTimer.start();
    }


    public void drawIngredients(Graphics g){

        // On affiche les images des ingrédients LIGNE 1
        g.drawImage(this.imageBread, 80, 690, 50, 50,this);
        g.drawImage(this.imageOil, 230, 690, 50, 50,this);
        g.drawImage(this.imagePotato, 380,690,45,45,this);
        g.drawImage(this.imageTomato, 527,690,50,50,this);
        g.drawImage(this.imageCheese, 678,693,42,42,this);
        g.drawImage(this.imagePate, 820,693,43,43,this);

        // On affiche les images des ingredients LIGNE 2
        // On affiche les images des ingrédients
        g.drawImage(this.imageMeat, 83, 740, 45, 45,this);
        g.drawImage(this.imageSalade, 234, 744, 40, 40,this);
        g.drawImage(this.imageSauce, 380,743,40,40,this);
        g.drawImage(this.imagePoulet, 528,740,45,45,this);
        g.drawImage(this.imageTortilla, 680,743,38,38,this);
        g.drawImage(this.imageSalt, 820,744,45,45,this);
    }

    /** Méthode qui affiche un cercle  pour signaler les ingrédients sélectionnés*/
    public void drawSelection(Graphics g){
        //Couleur du cercle
        g.setColor(Color.green);
        //On déclare la liste des ingrédients
        String[] Ingredients = {"pain","huile","patate","tomate","fromage","pate","viande","salade","sauce","poulet","tortilla","sel"};
        //Coordonnée X des cercles
        int[] xPositions = {125,275,425,575,720,867};
        //Coordonnée Y des cercles
        int yPosition = 695;
        for(int i = 0; i <Ingredients.length;i++) {
            //Au delà du 5e ingrédient on affiche en 2e ligne
            if(i > 5) { yPosition = 735; }
            if (this.etat.getSelectionIngredients().contains(Ingredients[i])){
                g.fillOval(xPositions[i%6],yPosition,13,13);
            }
        }
    }
    /** inverse la valeur de displayHelp */
    public void revertDisplayHelp() {
        this.displayHelp = !this.displayHelp;
    }

    /**récupère le produit sous le point donné*/
    public String findProductAtPoint(Point point) {
        int xOffset = 40;
        int productWidth = 55;
        int productHeight = 55;
        int productSpacing = 150;
        ArrayList<String> Products = new ArrayList<>(Arrays.asList("Burger", "Frites", "Pizza", "Wrap", "Boisson", "Gateau"));
        for (String product : Products) {
            Rectangle productBounds = new Rectangle(xOffset, 615, productWidth, productHeight);
            if (productBounds.contains(point)) {
                return product;
            }
            xOffset += productSpacing;
        }
        return null;
    }

    /**Vérifie si un point est dans le plateau*/
    public boolean isInTray(Point point) {
        // Remplacez ces valeurs par les dimensions réelles de votre plateau.
        Rectangle trayBounds = new Rectangle(200, 400, trayWidth, trayHeight);
        return trayBounds.contains(point);
    }

    public BufferedImage getImage(String produit) {
        switch (produit) {
            case "Burger":
                return this.imageBurger;
            case "Pizza":
                return this.imagePizza;
            case "Gateau":
                return this.imageGateau;
            case "Wrap":
                return this.imageWrap;
            case "Frites":
                return this.imageFrites;
            case "Boisson":
                return this.imageBoisson;
            default:
                throw new IllegalArgumentException("Produit invalide : " + produit);
        }
    }
}