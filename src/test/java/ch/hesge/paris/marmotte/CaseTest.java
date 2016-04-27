package ch.hesge.paris.marmotte;

import javax.swing.ImageIcon;
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
    public void une_case_est_par_defaut_vide() {
        assertTrue(c.isVide());
    }

    @Test
    public void isVide_true_si_imgHerbe() {
        c.setVide(true);
        String nomCompletImg = ((ImageIcon) c.getIcon()).getDescription();
        String nomImg = nomCompletImg.substring(nomCompletImg.lastIndexOf("/") + 1);
        assertTrue(nomImg.equals("TextureHerbePetite.jpg"));
    }

    @Test
    public void isVide_false_si_imgMarmotte1Point() {
        c.setVide(false);
        String nomCompletImg = ((ImageIcon) c.getIcon()).getDescription();
        String nomImg = nomCompletImg.substring(nomCompletImg.lastIndexOf("/") + 1);
        assertTrue(nomImg.equals("ImageMarmotte1Point.png"));
    }
}
