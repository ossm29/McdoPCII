package Controleur;
import java.awt.event.*;
import Modele.Etat;
import Vue.*;

/**
 *  Class Control implémente les interfaces 'MouseListener' et 'KeyListener',
 *  est responsable de la gestion des événements de souris et de clavier
 *  suite à toute interaction et de la communication entre les classes
 *  'Etat' et 'AffichagePrincipal'.
 *
 *
 * @version 1.0
 * */
public class Control implements MouseListener, KeyListener{

    /** Variables utiles au modèle MVC */

    // L'état courant de l'application
    private Etat etat;
    // La fenêtre principale de l'application
    private AffichagePrincipal affichagePrincipal;

    /** Threads */

    // Thread de génération de clients pour la simulation
    private GenereClient genereClient;
    // Thread de vérification gameOver
    private CheckGameOver checkGameOver;

    /**
     * Constructeur
     * Définit l'affichage et l'état choisis et lance les actions
     * de GenereClient (et Repaint) pour la mise à jour de l'affichage
     *
     * @param etat  l'état courant de l'application de type 'Etat'
     * @param affichagePrincipal  l'affichage principal de l'application de type 'AffichagePrincipal'
     * */
    public Control(Etat etat, AffichagePrincipal affichagePrincipal) {

        this.setEtat(etat);
        this.affichagePrincipal = affichagePrincipal;
        this.genereClient = new GenereClient(this);
        this.checkGameOver = new CheckGameOver(this.etat,affichagePrincipal);
        
        /* On initialise nos threads */
        this.genereClient.start();
        this.checkGameOver.start();

        
        /*On lance les threads */
        //this.repaint.start();
        
        this.affichagePrincipal.addMouseListener(this);
    }

    /**
     * Obtient et renvoie l'affichage principal de notre fenêtre
     *
     * @return affichagePrincipal  l'affichage principal de l'application de type 'AffichagePrincipal'
     * */
    public AffichagePrincipal getAffichagePrincipal() {
        return affichagePrincipal;
    }


    /** Implémentations des méthodes de l'interface MouseListener */

    @Override
    public void mouseClicked(MouseEvent e) {}

    /**
     * Permet de sélectionner et désélectionner un ingrédient
     * lorsque l'utilisateur clique sur la souris
     *
     * @param e  l'évènement de la souris de type 'MouseEvent'
     * */
    @Override
    public void mousePressed(MouseEvent e) {
        if (!this.getEtat().gameOver()) {
            int x = e.getX();
            int y = e.getY();

            // Vérifie si le bouton gauche de la souris a été cliqué
            if (e.getButton() == MouseEvent.BUTTON1) {
                // Vérifie quelle zone a été cliquée et ajoute ou supprime l'ingrédient correspondant
                if (x > 40 && x < 90 && y > 690 && y < 740) {
                    if (this.etat.getSelectionIngredients().contains("pain")) {
                        this.etat.removeIngredient("pain");
                    } else {
                        this.etat.addIngredient("pain");
                    }
                    //System.out.println(this.etat.getSelectionIngredients());
                }
                if (x > 190 && x < 240 && y > 690 && y < 740) {
                    if (this.etat.getSelectionIngredients().contains("huile")) {
                        this.etat.removeIngredient("huile");
                    } else {
                        this.etat.addIngredient("huile");
                    }
                    //System.out.println(this.etat.getSelectionIngredients());
                }
                if (x > 340 && x < 390 && y > 690 && y < 740) {
                    if (this.etat.getSelectionIngredients().contains("patate")) {
                        this.etat.removeIngredient("patate");
                    } else {
                        this.etat.addIngredient("patate");
                    }
                    //System.out.println(this.etat.getSelectionIngredients());
                }
                if (x > 490 && x < 540 && y > 690 && y < 740) {
                    if (this.etat.getSelectionIngredients().contains("tomate")) {
                        this.etat.removeIngredient("tomate");
                    } else {
                        this.etat.addIngredient("tomate");
                    }
                    //System.out.println(this.etat.getSelectionIngredients());
                }
                if (x > 640 && x < 690 && y > 690 && y < 740) {
                    if (this.etat.getSelectionIngredients().contains("fromage")) {
                        this.etat.removeIngredient("fromage");
                    } else {
                        this.etat.addIngredient("fromage");
                    }
                    //System.out.println(this.etat.getSelectionIngredients());
                }
                if (x > 790 && x < 830 && y > 690 && y < 740) {
                    if (this.etat.getSelectionIngredients().contains("pate")) {
                        this.etat.removeIngredient("pate");
                    } else {
                        this.etat.addIngredient("pate");
                    }
                    //System.out.println(this.etat.getSelectionIngredients());
                }
                if (x > 40 && x < 90 && y > 740 && y < 790) {
                    if (this.etat.getSelectionIngredients().contains("viande")) {
                        this.etat.removeIngredient("viande");
                    } else {
                        this.etat.addIngredient("viande");
                    }
                    //System.out.println(this.etat.getSelectionIngredients());
                }
                if (x > 190 && x < 240 && y > 740 && y < 790) {
                    if (this.etat.getSelectionIngredients().contains("salade")) {
                        this.etat.removeIngredient("salade");
                    } else {
                        this.etat.addIngredient("salade");
                    }
                    //System.out.println(this.etat.getSelectionIngredients());
                }
                if (x > 340 && x < 390 && y > 740 && y < 790) {
                    if (this.etat.getSelectionIngredients().contains("sauce")) {
                        this.etat.removeIngredient("sauce");
                    } else {
                        this.etat.addIngredient("sauce");
                    }
                    //System.out.println(this.etat.getSelectionIngredients());
                }
                if (x > 490 && x < 540 && y > 740 && y < 790) {
                    if (this.etat.getSelectionIngredients().contains("poulet")) {
                        this.etat.removeIngredient("poulet");
                    } else {
                        this.etat.addIngredient("poulet");
                    }
                    //System.out.println(this.etat.getSelectionIngredients());
                }
                if (x > 640 && x < 690 && y > 740 && y < 790) {
                    if (this.etat.getSelectionIngredients().contains("tortilla")) {
                        this.etat.removeIngredient("tortilla");
                    } else {
                        this.etat.addIngredient("tortilla");
                    }
                    //System.out.println(this.etat.getSelectionIngredients());
                }
                if (x > 790 && x < 840 && y > 740 && y < 790) {
                    if (this.etat.getSelectionIngredients().contains("sel")) {
                        this.etat.removeIngredient("sel");
                    } else {
                        this.etat.addIngredient("sel");
                    }
                    //System.out.println(this.etat.getSelectionIngredients());
                }

                //this.etat.production();
                this.affichagePrincipal.repaint();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}



    /** Implémentations des méthodes de l'interface KeyListener */

    /**
     * Cette méthode est appelée lorsque l'utilisateur tape une touche.
     * Si la touche est "précédent" ou "suivant", la méthode
     * change le client courant et met à jour l'affichage.
     *
     * @param e  l'évènement de la touche tapée de type 'KeyEvent'
     * */
    @Override
    public void keyTyped(KeyEvent e) {
        if ( e.getKeyCode() == KeyEvent.VK_Q) { // Si la touche "précédent" est tapée
            this.etat.clientprecedent(); // On change le client courant
            System.out.println(this.etat.getClient_en_cours());
            // On met à jour l'affichage
            this.affichagePrincipal.getAffichageDroite().getAffichgeClient().getMiniAffichageClient().repaint();
        }
        if ( e.getKeyCode() == KeyEvent.VK_D ) { // Si la touche "suivant" est tapée
            this.etat.clientsuivant(); // On change le client courant
            System.out.println(this.etat.getClient_en_cours());
            // On met à jour l'affichage
            this.affichagePrincipal.getAffichageDroite().getAffichgeClient().getMiniAffichageClient().repaint();
        }
    }

    /**
     * Cette méthode est appelée lorsque l'utilisateur appuie sur une touche.
     * Si la touche est "précédent" ou "suivant", la méthode change
     * le client courant et met à jour l'affichage.
     *
     * @param e  l'évènement de la touche appuyée de type 'KeyEvent'
     * */
    @Override
    public void keyPressed(KeyEvent e) {
        if ( e.getKeyCode() == KeyEvent.VK_Q) { // Si la touche "précédent" est appuyée
            this.etat.clientprecedent(); // On change le client courant
            System.out.println(this.etat.getClient_en_cours());
            // On met à jour l'affichage
            this.affichagePrincipal.getAffichageDroite().getAffichgeClient().getMiniAffichageClient().repaint();
        }
        if ( e.getKeyCode() == KeyEvent.VK_D ) { // Si la touche "suivant" est appuyée
            this.etat.clientsuivant(); // On change le client courant
            System.out.println(this.etat.getClient_en_cours());
            // On met à jour l'affichage
            this.affichagePrincipal.getAffichageDroite().getAffichgeClient().getMiniAffichageClient().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    /**
     * Getter
     * Obtient et renvoie l'état dans notre classe Control
     *
     * @return etat  l'état courant de l'application de type 'Etat'
     * */
    public Etat getEtat() {
        return etat;
    }

    /**
     * Setter
     * Définit l'état de notre classe Control
     *
     * @param etat  l'état courant de l'application de type 'Etat'
     * */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}