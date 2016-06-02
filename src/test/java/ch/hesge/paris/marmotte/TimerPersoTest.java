/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.paris.marmotte;
import java.util.ArrayList;
import java.util.TimerTask;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TimerPersoTest {

    private TimerPerso timer;
    private Parametres p;

    @BeforeMethod
    public void setUp() {
        p = new Parametres();
        timer = new TimerPerso(new Monde(p.getMondeTailleX(), p.getMondeTailleY()),
                p.getVitesseDifficulteEmperique(),
                p.getVitesseDifficulte()
        );
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
        
        
        timer.marmottes = alMarmottes;
        timer.deplacerMarmottes(o, monde);
        
        assertFalse(c.getPositionX() == m.getMaCase().getPositionX() && c.getPositionY() == m.getMaCase().getPositionY());
        
        
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
