/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.paris.marmotte;

import java.util.ArrayList;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Paris
 */
public class TimerTest {

    private JeuMarmotteHunter jeu;
    private Parametres param;
    private TimerPerso timer;
    private int nbMarmottesAvant;
    private int nbMarmottesMax;
       
    @BeforeClass
    public void setUpGlobal() {

    }
    
    @BeforeMethod
    public void setUp() {
        param = new Parametres();
        param.charger();
        jeu = new JeuMarmotteHunter();
        timer = jeu.getTimer();
        nbMarmottesAvant = jeu.getTimer().getMarmottes().size();
        nbMarmottesMax = jeu.getMonde().getTailleX() * jeu.getMonde().getTailleY();
    }

    @Test
    public void depalcerMarmottes_deplace_une_marmotte_si_place() {
        ArrayList<String> alPositionsAvant = new ArrayList<String>();
        for (Marmotte m : timer.getMarmottes()) {
            alPositionsAvant.add(m.getMaCase().getPositionX() + "" + m.getMaCase().getPositionY());
        }
        timer.deplacerMarmottes();
        ArrayList<String> alPositionsApres = new ArrayList<String>();
        for (Marmotte m : timer.getMarmottes()) {
            alPositionsApres.add(m.getMaCase().getPositionX() + "" + m.getMaCase().getPositionY());
        }
        assertTrue(!alPositionsAvant.equals(alPositionsApres) || nbMarmottesAvant == nbMarmottesMax);
    }

}
