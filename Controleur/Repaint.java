package Controleur;
import Vue.Affichage;

public class Repaint extends Thread{

	/* Attributs */
	Affichage affichage;
	
  /* Constructeur  */
	public Repaint(Affichage affichage) {
		this.affichage = affichage;
	}
	
  /* Ma méthode run grace à laquelle je redessine mon vue à chaque fois */
	@Override
    public void run() {
      while(true) {
        try { Thread.sleep(50); this.affichage.repaint(); this.affichage.revalidate();}  /* Je redessine à chaque fois  */
        catch (Exception e) { e.printStackTrace(); }
      }
    }
	
	
}
