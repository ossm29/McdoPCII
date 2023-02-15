package Controleur;
import Vue.AffichagePrincipal;

public class Repaint extends Thread{

	/* Attributs */
	AffichagePrincipal affichagePrincipal;
	
  /* Constructeur  */
	public Repaint(AffichagePrincipal affichagePrincipal) {
        this.affichagePrincipal = affichagePrincipal;
	}
	
  /* Ma méthode run grace à laquelle je redessine mon vue à chaque fois */
	@Override
    public void run() {
      while(true) {
        try {
            Thread.sleep(50);
            System.out.println("Dessin fait");
            this.affichagePrincipal.repaint();
            this.affichagePrincipal.revalidate();
        }  /* Je redessine à chaque fois  */
        catch (Exception e) { e.printStackTrace(); }
      }
    }
	
	
}
