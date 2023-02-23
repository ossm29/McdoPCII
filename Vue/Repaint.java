package Vue;
import Vue.AffichagePrincipal;

/** thread d'affichage qui s'éxécute au moins 24 fois par seconde afin de fluidifier l'affichage */
public class Repaint extends Thread{


    /** ATTRIBUTS */
    /* booleen qui indique si le modèle a été modifié */
    private boolean edited;
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
            //24 fois par seconde
            Thread.sleep(1000/24);
            this.affichagePrincipal.repaint();
            this.affichagePrincipal.revalidate();

            System.out.println("Dessin effectué");

        }  /* Je redessine à chaque fois  */
        catch (Exception e) { e.printStackTrace(); }
      }
    }

    /* méthode qui permet aux threads d'alerter que le modèle est modifié */
    public void setEdited() {
        this.edited = true;
    }
	
	
}
