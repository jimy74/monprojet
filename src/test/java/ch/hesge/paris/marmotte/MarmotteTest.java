/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.paris.marmotte;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Paris
 */
public class MarmotteTest {

    private Marmotte marmotte;
    private Parametres param;
    private Case caseDepart;
    private Case caseChangee;

    @BeforeMethod
    public void setUp() {
        param = new Parametres();
        caseDepart = new Case(1, 1);
        marmotte = new Marmotte(param.getPvMarmotte(), caseDepart);
        caseChangee = new Case(1, 2);
    }

    @Test
    public void setMaCase_definit_bien_une_nouvelle_case() {

        marmotte.setMaCase(caseChangee);
        assertTrue((caseChangee != caseDepart && caseChangee == marmotte.getMaCase()));
    }

    @Test
    public void setMaCase_si_nouvelle_case_alors_ancienne_case_vide() {
        marmotte.setMaCase(caseChangee);
        assertTrue(caseDepart.isVide());
    }

    @Test
    public void setMaCase_alors_nouvelle_pleine() {
        marmotte.setMaCase(caseChangee);
        assertFalse(caseChangee.isVide());
    }

    @Test(expectedExceptions
            = NullPointerException.class)
    public void setMaCase_null_lance_exeption() {
        marmotte.setMaCase(null);

    }
}
