package Vue;
import Vue.AffichagePrincipal;

/**
 * Classe Repaint est un thread d'affichage qui s'exécute au moins 24 fois
 * par seconde afin de fluidifier l'affichage
 *
 * @version 1.0
 * */
public class Repaint extends Thread{

    /** ATTRIBUTS */

    /* Boolean qui indique si le modèle a été modifié */
    private boolean edited;
    /* Instance pour l'affichage principal utilisée pour redessiner la vue */
	AffichagePrincipal affichagePrincipal;
	
  /**
   * Constructeur
   * Définit l'affichage principal, qui est l'instance principale de la classe.
   *
   * @param affichagePrincipal  l'instance pour l'affichage principal de type 'AffichagePrincipal'
   * */
	public Repaint(AffichagePrincipal affichagePrincipal) {
        this.affichagePrincipal = affichagePrincipal;
	}
	
  /**
   * Méthode qui redessine la vue à chaque fois qu'elle est appelée.
   *
   * */
	@Override
    public void run() {
      while(true) {
        try {
            // 24 fois par seconde
            Thread.sleep(1000/24);
            this.affichagePrincipal.repaint();
            this.affichagePrincipal.revalidate();

            System.out.println("Dessin effectué");

        }  /* Je redessine à chaque fois  */
        catch (Exception e) { e.printStackTrace(); }
      }
    }

    /**
     * Méthode qui définit le booléen "edited" à true pour indiquer que le modèle
     * a été modifié.
     *
     * */
    public void setEdited() {
        this.edited = true;
    }
	
	
}
