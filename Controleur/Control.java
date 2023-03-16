package Controleur;
import java.awt.event.*;
import Modele.Etat;
import Vue.*;

/* Ma classe Control qui fera le lien entre ma Classe Etat et ma Classe Affichage suite à toute interaction */
public class Control implements MouseListener, KeyListener{

    /* Variables  utiles au modèle MVC */
    private Etat etat;                              
    private AffichagePrincipal affichagePrincipal;

    /* Threads */
    private Repaint repaint;

    private GenereClient genereClient;
    
    /* Constructeur */
    public Control(Etat etat, AffichagePrincipal affichagePrincipal) {

        this.setEtat(etat);
        this.affichagePrincipal = affichagePrincipal;
        this.genereClient = new GenereClient(this);
        
        /* On initialise nos threads */
        //this.repaint = new Repaint(this.affichagePrincipal);
        this.genereClient.start();
        
        /*On lance les threads */
        //this.repaint.start();
        
        this.affichagePrincipal.addMouseListener(this);
    }

    public AffichagePrincipal getAffichagePrincipal() {
        return affichagePrincipal;
    }

    /* Ce qui se passe quand je presse et relache (entre autre clique) sur les boutons de ma souris  */
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    
    /* Ce qui se passe quand je presse les boutons de ma souris  */
    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
    	if ( e.getButton() == MouseEvent.BUTTON1 ) {
            // On ajoute ou supprime l'ingredient selon la zone de clic
            if (x>40 && x<90 && y>690 && y<740){
                if (this.etat.getSelectionIngredients().contains("pain")){
                    this.etat.removeIngredient("pain");
                }
                else { this.etat.addIngredient("pain");}
                System.out.println(this.etat.getSelectionIngredients());
            }
            if (x>190 && x<240 && y>690 && y<740){
                if (this.etat.getSelectionIngredients().contains("huile")){
                    this.etat.removeIngredient("huile");
                }
                else { this.etat.addIngredient("huile"); }
                System.out.println(this.etat.getSelectionIngredients());
            }
            if (x>340 && x<390 && y>690 && y<740){
                if (this.etat.getSelectionIngredients().contains("patate")) {
                    this.etat.removeIngredient("patate");
                }
                else { this.etat.addIngredient("patate"); }
                System.out.println(this.etat.getSelectionIngredients());
            }
            if (x>490&& x<540 && y>690 && y<740){
                if (this.etat.getSelectionIngredients().contains("tomate")){
                    this.etat.removeIngredient("tomate");
                }
                else { this.etat.addIngredient("tomate"); }
                System.out.println(this.etat.getSelectionIngredients());
            }
            if (x>640&& x<690 && y>690 && y<740){
                if (this.etat.getSelectionIngredients().contains("fromage")){
                    this.etat.removeIngredient("fromage");
                }
                else { this.etat.addIngredient("fromage"); }
                System.out.println(this.etat.getSelectionIngredients());
            }
            if (x>790&& x<830 && y>690 && y<740){
                if (this.etat.getSelectionIngredients().contains("pate")){
                    this.etat.removeIngredient("pate");
                }
                else { this.etat.addIngredient("pate"); }
                System.out.println(this.etat.getSelectionIngredients());
            }
            if (x>40 && x<90 && y>740 && y<790){
                if (this.etat.getSelectionIngredients().contains("viande")){
                    this.etat.removeIngredient("viande");
                }
                else { this.etat.addIngredient("viande");}
                System.out.println(this.etat.getSelectionIngredients());
            }
            if (x>190 && x<240 && y>740 && y<790){
                if (this.etat.getSelectionIngredients().contains("salade")){
                    this.etat.removeIngredient("salade");
                }
                else { this.etat.addIngredient("salade");}
                System.out.println(this.etat.getSelectionIngredients());
            }
            if (x>340&& x<390 && y>740 && y<790){
                if (this.etat.getSelectionIngredients().contains("sauce")){
                    this.etat.removeIngredient("sauce");
                }
                else { this.etat.addIngredient("sauce");}
                System.out.println(this.etat.getSelectionIngredients());
            }
            if (x>490 && x<540&& y>740 && y<790){
                if (this.etat.getSelectionIngredients().contains("poulet")){
                    this.etat.removeIngredient("poulet");
                }
                else { this.etat.addIngredient("poulet");}
                System.out.println(this.etat.getSelectionIngredients());
            }
            if (x>640 && x<690 && y>740 && y<790){
                if (this.etat.getSelectionIngredients().contains("tortilla")){
                    this.etat.removeIngredient("tortilla");
                }
                else { this.etat.addIngredient("tortilla");}
                System.out.println(this.etat.getSelectionIngredients());
            }
            if (x>790 && x<840&& y>740 && y<790){
                if (this.etat.getSelectionIngredients().contains("sel")){
                    this.etat.removeIngredient("sel");
                }
                else { this.etat.addIngredient("sel");}
                System.out.println(this.etat.getSelectionIngredients());
            }

            //this.etat.production();
            this.affichagePrincipal.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

    @Override
    public void keyTyped(KeyEvent e) {
        if ( e.getKeyCode() == KeyEvent.VK_Q) {
            this.etat.clientprecedent();
            System.out.println(this.etat.getClient_en_cours());
            this.affichagePrincipal.getAffichageDroite().getAffichgeClient().getMiniAffichageClient().repaint();
        }
        if ( e.getKeyCode() == KeyEvent.VK_D ) {
            this.etat.clientsuivant();
            System.out.println(this.etat.getClient_en_cours());
            this.affichagePrincipal.getAffichageDroite().getAffichgeClient().getMiniAffichageClient().repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if ( e.getKeyCode() == KeyEvent.VK_Q) {
            this.etat.clientprecedent();
            System.out.println(this.etat.getClient_en_cours());
            this.affichagePrincipal.getAffichageDroite().getAffichgeClient().getMiniAffichageClient().repaint();
        }
        if ( e.getKeyCode() == KeyEvent.VK_D ) {
            this.etat.clientsuivant();
            System.out.println(this.etat.getClient_en_cours());
            this.affichagePrincipal.getAffichageDroite().getAffichgeClient().getMiniAffichageClient().repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}