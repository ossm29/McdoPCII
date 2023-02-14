package Controleur;
import Vue.AffichagePrincipale;
import Vue.AffichageProduits;
import Vue.AffichagePrincipale;

public class Repaint extends Thread{

	/* Attributs */
	AffichagePrincipale affichagePrincipale;
	
  /* Constructeur  */
	public Repaint(AffichagePrincipale affichagePrincipale) {
        this.affichagePrincipale = affichagePrincipale;
	}
	
  /* Ma méthode run grace à laquelle je redessine mon vue à chaque fois */
	@Override
    public void run() {
      while(true) {
        try {
            Thread.sleep(50);
            System.out.println("Dessin fait");
            this.affichagePrincipale.repaint();
            this.affichagePrincipale.revalidate();
        }  /* Je redessine à chaque fois  */
        catch (Exception e) { e.printStackTrace(); }
      }
    }
	
	
}
