package Vue;

import javax.swing.*;
import java.awt.*;

public class AffichageBarreDeProgression extends JProgressBar {


    public AffichageBarreDeProgression() {
        this.setPreferredSize(new Dimension(380, 40));
        this.setStringPainted(true);
        this.setForeground(Color.GREEN);
        double valeur = 50;//this.etat.getClients().getListeClients().get(this.etat.getClient_en_cours()).getTimer();
        this.setValue(20);
    }
}
