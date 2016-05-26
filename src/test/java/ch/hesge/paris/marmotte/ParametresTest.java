package ch.hesge.paris.marmotte;

import javax.swing.ImageIcon;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class ParametresTest {

    private Parametres p;

    @BeforeMethod
    public void setUp() {
        p = new Parametres();
    }

    @Test
    public void setVitesseDifficulteEmperique_definit_ca_valeur() {
        int valeurTest = 1;
        p.setVitesseDifficulteEmperique(valeurTest);
        assertTrue(p.getVitesseDifficulteEmperique() == valeurTest);
    }

    @Test
    public void setPvMarmotte_definit_ca_valeur() {
        int valeurTest = 1;
        p.setPvMarmotte(valeurTest);
        assertTrue(p.getPvMarmotte() == valeurTest);
    }

    @Test
    public void setDegat_definit_ca_valeur() {
        int valeurTest = 1;
        p.setDegat(valeurTest);
        assertTrue(p.getDegat() == valeurTest);
    }

    @Test
    public void setScore_definit_ca_valeur() {
        int valeurTest = 1;
        p.setScore(valeurTest);
        assertTrue(p.getScore() == valeurTest);
    }

    @Test
    public void setMondeTailleX_definit_ca_valeur() {
        int valeurTest = 1;
        p.setMondeTailleX(valeurTest);
        assertTrue(p.getMondeTailleX() == valeurTest);
    }
    
    @Test
    public void setMondeTailleY_definit_ca_valeur() {
        int valeurTest = 1;
        p.setMondeTailleX(valeurTest);
        assertTrue(p.getMondeTailleX() == valeurTest);
    }    
}
