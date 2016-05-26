/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.paris.marmotte;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TimerPersoTest {

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
    public void depalcerMarmottes_si_case_proche() {
        Monde monde = mock(Monde.class);
        Outil o = mock(Outil.class);
        
        
        
        ArrayList<Marmotte> alMarmottes = new ArrayList();
        Marmotte m = new Marmotte(1,new Case(1,1));
        alMarmottes.add(m);
        ArrayList alCases = new ArrayList();
        Case c = new Case(2,2);
        alCases.add(c);
        
            
        when(monde.getCases()).thenReturn(alCases);
        when(o.abs(anyInt())).thenReturn(1);
        
        
        timer.marmottes = alMarmottes;
        timer.deplacerMarmottes(o, monde);
        
        assertTrue(c.getPositionX() == m.getMaCase().getPositionX() && c.getPositionY() == m.getMaCase().getPositionY());
        
        
    }
    
    @Test
    public void depalcerMarmottes_marche_pas_si_case_abherentX() {
        Monde monde = mock(Monde.class);
        Outil o = mock(Outil.class);
        
        
        
        ArrayList<Marmotte> alMarmottes = new ArrayList();
        Marmotte m = new Marmotte(1,new Case(1,1));
        alMarmottes.add(m);
        ArrayList alCases = new ArrayList();
        Case c = new Case(0,1);
        alCases.add(c);
        
            
        when(monde.getCases()).thenReturn(alCases);
        //when(o.abs(anyInt())).thenReturn(1);
        
        
        timer.marmottes = alMarmottes;
        timer.deplacerMarmottes(o, monde);
        
        assertFalse(c.getPositionX() == m.getMaCase().getPositionX() && c.getPositionY() == m.getMaCase().getPositionY());
        
        
    }
    public void depalcerMarmottes_marche_pas_si_case_abherentY() {
        Monde monde = mock(Monde.class);
        Outil o = mock(Outil.class);
        
        
        
        ArrayList<Marmotte> alMarmottes = new ArrayList();
        Marmotte m = new Marmotte(1,new Case(1,1));
        alMarmottes.add(m);
        ArrayList alCases = new ArrayList();
        Case c = new Case(1,0);
        alCases.add(c);
        
            
        when(monde.getCases()).thenReturn(alCases);
        //when(o.abs(anyInt())).thenReturn(1);
        
        
        timer.marmottes = alMarmottes;
        timer.deplacerMarmottes(o, monde);
        
        assertFalse(c.getPositionX() == m.getMaCase().getPositionX() && c.getPositionY() == m.getMaCase().getPositionY());
        
        
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
    public void getTemps_egale_setTemps_de_avant() {
        int unTemps = 3;
        timer.setTemps(unTemps);
        assertTrue(unTemps == timer.getTemps());
    }

    @Test
    public void getDifficulteEmperique_egale_setDifficulteEmperique_de_avant() {
        double uneDifEmp = 1.5;
        timer.setDifficulteEmperique(uneDifEmp);
        assertTrue(uneDifEmp == timer.getDifficulteEmperique());
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

    @Test(expectedExceptions = IllegalStateException.class)
    public void cancel_appel_cancel_le_timer() {
        timer.cancel();
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                
            }
        }, 0, 1);

    }
}
