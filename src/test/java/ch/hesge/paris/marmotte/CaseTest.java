package ch.hesge.paris.marmotte;

import java.awt.Insets;
import javax.swing.ImageIcon;
import org.junit.Assert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class CaseTest {

    private Case c;

    @BeforeMethod
    public void setUp() {
        c = new Case(1, 1);
    }

    @Test
    public void isVide_retourne_true_si_setVide_true() {
        c.setVide(true);
        assertTrue(c.isVide());
    }

    @Test
    public void isVide_retourne_false_si_setVide_false() {
        c.setVide(false);
        assertFalse(c.isVide());
    }

    @Test
    public void Case_est_par_defaut_vide() {
        assertTrue(c.isVide());
    }

    @Test
    public void setVide_true_si_imgHerbe() {
        c.setVide(true);
        String nomCompletImg = ((ImageIcon) c.getIcon()).getDescription();
        String nomImg = nomCompletImg.substring(nomCompletImg.lastIndexOf("/") + 1);
        assertTrue(nomImg.equals("TextureHerbePetite.jpg"));
    }

    @Test
    public void setVide_false_si_imgMarmotte1Point() {
        c.setVide(false);
        String nomCompletImg = ((ImageIcon) c.getIcon()).getDescription();
        String nomImg = nomCompletImg.substring(nomCompletImg.lastIndexOf("/") + 1);
        assertTrue(nomImg.equals("ImageMarmotte1Point.png"));
    }
    
    @Test
    public void nouvelleCase_est_vide_par_defaut(){
        assertTrue(c.isVide());
    }
    
    @Test
    public void nouvelleCase_est_sans_marges_par_defaut(){
        assertEquals(c.getMargin(),new Insets(0, 0, 0, 0));
    }
    
    @Test
    public void nouvelleCase_na_pas_de_bordure_par_defaut(){
        Assert.assertNull(c.getBorder());
    }    
}
