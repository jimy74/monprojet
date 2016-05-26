package ch.hesge.paris.marmotte;

import java.util.Random;
import org.junit.Ignore;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;

public class FramePersoTest {

    private FramePerso frm;
    private Parametres p;

    @BeforeMethod
    public void setUp() {
        p = new Parametres();
        frm = new FramePerso(p.getMondeTailleX(), p.getMondeTailleY());
    }
    
    @Test
    public void la_fenetre_saffiche_par_defaut(){
        assertTrue(frm.isVisible());       
    }
    
     @Test
    public void la_fenetre_affiche_ses_cases_par_defaut(){
        assertTrue(frm.zoneJeu.getComponentCount() == p.getMondeTailleX() * p.getMondeTailleY());       
    }
    
    
     @Test
    public void la_fenetre_est_en_BorderLayout_par_defaut(){
        assertEquals(frm.getLayout().getClass().getName(), "java.awt.BorderLayout");
    }    
     @Test
    public void les_2_panels_sont_en_gridLayout_par_defaut(){
        String layout = "java.awt.GridLayout";
        assertEquals(frm.zoneAffichage.getLayout().getClass().getName(), layout);
        assertEquals(frm.zoneJeu.getLayout().getClass().getName(), layout);
    }    
    @Test
    public void _la_fenetre_nest_pas_resizable(){
        assertFalse(frm.isResizable());
    }
 
}
