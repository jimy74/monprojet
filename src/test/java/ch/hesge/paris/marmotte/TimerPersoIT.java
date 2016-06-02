/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.paris.marmotte;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Paris
 */
public class TimerPersoIT {

    private TimerPerso timer;
    private Parametres p;
    private int nbMarmottesAvant;
    private int nbMarmottesMax;

    @BeforeMethod
    public void setUp() {
        p = new Parametres();
        timer = new TimerPerso(new Monde(p.getMondeTailleX(), p.getMondeTailleY()),
                p.getVitesseDifficulteEmperique(),
                p.getVitesseDifficulte()
        );
    }
    
    @Test
    public void depalcerMarmottes_deplace_une_marmotte_dans_une_case_vide() {

        Case caseTrouvee = null;

        ArrayList<Case> cases = timer.getMonde().getCases();
        for (Case uneCase : cases) {
            //si marmotte à une case vide directement à proximité
            if (uneCase.isVide()) {
                caseTrouvee = uneCase;
            }
        }
        timer.deplacerMarmottes(new Outil(), timer.getMonde());
        assertTrue(caseTrouvee != null);
    }
    
    @Test
    public void depalcerMarmottes_deplace_une_marmotte_si_place_et_si_marmotte() {
        nbMarmottesAvant = timer.getMarmottes().size();
        nbMarmottesMax = timer.getMonde().getTailleX() * timer.getMonde().getTailleY();

        ArrayList<String> alPositionsAvant = new ArrayList<String>();
        for (Marmotte m : timer.getMarmottes()) {
            alPositionsAvant.add(m.getMaCase().getPositionX() + "" + m.getMaCase().getPositionY());
        }

        timer.deplacerMarmottes(new Outil(), timer.getMonde());
        ArrayList<String> alPositionsApres = new ArrayList<String>();
        for (Marmotte m : timer.getMarmottes()) {
            alPositionsApres.add(m.getMaCase().getPositionX() + "" + m.getMaCase().getPositionY());
        }
        assertTrue(!alPositionsAvant.equals(alPositionsApres) || nbMarmottesAvant == nbMarmottesMax || nbMarmottesAvant <= 0);
    }
    
    @Test
    public void afficherTemps_affiche_anienneValeur_plus_1sec() {

        timer.afficherTemps();

        String sansPartieAvant = timer.getMonde().getLblTemps().substring(8, timer.getMonde().getLblTemps().length());
        String sansString = sansPartieAvant.substring(0, sansPartieAvant.length() - 9);

        int temps1 = Integer.parseInt(sansString);

        try {
            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException ex) {
            Logger.getLogger(TimerPersoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        timer.afficherTemps();

        sansPartieAvant = timer.getMonde().getLblTemps().substring(8, timer.getMonde().getLblTemps().length());
        sansString = sansPartieAvant.substring(0, sansPartieAvant.length() - 9);

        int temps2 = Integer.parseInt(sansString);

        Assert.assertTrue(temps1 + 1 == temps2);

    }
    
    @Test
    public void cancel_arrete_levolution_du_temps() {

        String tempsAvant = timer.getMonde().getLblTemps();

        timer.cancel();

        try {
            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException ex) {
            Logger.getLogger(TimerPersoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String temps = timer.getMonde().getLblTemps();

        assertEquals(tempsAvant, temps);

    }
    
    @Test
    public void afficherTemps_change_le_lbl_apres_1sec() {

        timer.afficherTemps();
        String temps1 = timer.getMonde().getLblTemps();
        try {
            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException ex) {
            Logger.getLogger(TimerPersoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        timer.afficherTemps();
        String temps2 = timer.getMonde().getLblTemps();
        Assert.assertTrue(!temps1.equals(temps2));

    }    
}
