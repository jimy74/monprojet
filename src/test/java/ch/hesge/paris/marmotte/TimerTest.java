/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.paris.marmotte;

import bsh.org.objectweb.asm.Label;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Paris
 */
public class TimerTest {

    private TimerPerso timer;
    private Parametres param;
    private int nbMarmottesAvant;
    private int nbMarmottesMax;

    @BeforeClass
    public void setUpGlobal() {

    }

    @BeforeMethod
    public void setUp() {
        Parametres p = new Parametres();
        timer = new TimerPerso(new Monde(p.getMondeTailleX(), p.getMondeTailleY()),
                p.getVitesseDifficulteEmperique(),
                p.getVitesseDifficulte()
        );
    }

    @Test
    public void depalcerMarmottes_deplace_une_marmotte_si_place_et_si_marmotte() {
        nbMarmottesAvant = timer.getMarmottes().size();
        nbMarmottesMax = timer.getMonde().getTailleX() * timer.getMonde().getTailleY();

        ArrayList<String> alPositionsAvant = new ArrayList<String>();
        for (Marmotte m : timer.getMarmottes()) {
            alPositionsAvant.add(m.getMaCase().getPositionX() + "" + m.getMaCase().getPositionY());
        }
        timer.deplacerMarmottes();
        ArrayList<String> alPositionsApres = new ArrayList<String>();
        for (Marmotte m : timer.getMarmottes()) {
            alPositionsApres.add(m.getMaCase().getPositionX() + "" + m.getMaCase().getPositionY());
        }
        assertTrue(!alPositionsAvant.equals(alPositionsApres) || nbMarmottesAvant == nbMarmottesMax || nbMarmottesAvant <= 0);
    }
    
    /*
     @Test
     public void depalcerMarmottes_deplace_si_une_seule_marmotte() {

     TimerPerso timer = mock(TimerPerso.class);
     Monde monde = mock(Monde.class);
     ArrayList<Marmotte> alMarmottes = new ArrayList();
     alMarmottes.add(new Marmotte(1, new Case(1, 1)));

     when(timer.getMonde()).thenReturn(monde);
     when(timer.getMarmottes()).thenReturn(alMarmottes);
     //when(timer.getMarmottes().size()).thenReturn(1); 

     ArrayList<String> alPositionsAvant = new ArrayList<String>();
     for (Marmotte m : alMarmottes) {
     alPositionsAvant.add(m.getMaCase().getPositionX() + "" + m.getMaCase().getPositionY());
     }

     timer.deplacerMarmottes();

     ArrayList<String> alPositionsApres = new ArrayList<String>();
     for (Marmotte m : alMarmottes) {
     alPositionsApres.add(m.getMaCase().getPositionX() + "" + m.getMaCase().getPositionY());
     }

     Assert.assertTrue(!alPositionsAvant.equals(alPositionsApres));
     }

     */
    
    /*
     @Test
     public void depalcerMarmottes_deplace_si_une_marmotte_et_une_caseVide() {
        
     TimerPerso timer = mock(TimerPerso.class);
     Monde monde = mock(Monde.class);
     ArrayList<Marmotte> alMarmottes = mock(ArrayList.class);
     Marmotte marmotte = mock(Marmotte.class);
     ArrayList<Case> alCases = mock(ArrayList.class);
     Case c = mock(Case.class);
        
     when(timer.getMonde()).thenReturn(monde);
     when(monde.getCases()).thenReturn(alCases);
     when(alCases.size()).thenReturn(1);
     when(c.isVide()).thenReturn(true);

     int nbMarmottesAvant = timer.getMarmottes().size();
     int nbMarmottesMax = monde.getTailleX() * monde.getTailleY();
        
     ArrayList<String> alPositionsAvant = new ArrayList<String>();
     for (Marmotte m : timer.getMarmottes()) {
     alPositionsAvant.add(m.getMaCase().getPositionX() + "" + m.getMaCase().getPositionY());
     }
              
     timer.deplacerMarmottes();
     ArrayList<String> alPositionsApres = new ArrayList<String>();
     for (Marmotte m : timer.getMarmottes()) {
     alPositionsApres.add(m.getMaCase().getPositionX() + "" + m.getMaCase().getPositionY());
     }
     assertTrue(!alPositionsAvant.equals(alPositionsApres));
     } */  
    
    @Test
    public void afficherTemps_change_le_lbl_toutes_les_sec() {

        timer.afficherTemps();
        String temps1 = timer.getMonde().getLblTemps();
        try {
            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException ex) {
            Logger.getLogger(TimerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        timer.afficherTemps();
        String temps2 = timer.getMonde().getLblTemps();
        System.out.println(temps1);
        System.out.println(temps2);
        Assert.assertTrue(!temps1.equals(temps2));

    }

}
