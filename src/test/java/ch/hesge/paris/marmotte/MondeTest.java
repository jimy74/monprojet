package ch.hesge.paris.marmotte;

import java.util.ArrayList;
import java.util.Random;
import org.junit.Ignore;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;

public class MondeTest {

    private Monde monde;

    @BeforeMethod
    public void setUp() {
        Parametres p = new Parametres();
        monde = new Monde(p.getMondeTailleX(), p.getMondeTailleY());
    }

    @Test
    public void getCaseVideAliatoire_retourne_une_case_vraiment_vide() {
        assertNotNull(monde.getCaseVideAliatoire(new Random()));
    }

    @Test
    public void getCaseVideAliatoire_renvoi_la_case_qui_est_au_x_et_y_aleatoire() {

        Random alea = mock(Random.class);

        int tailleRandom = 3; //je fige l'entrée de la méthode testée, "si non comment tester l'aléatoire/l'imprévisible"
        when(alea.nextInt(anyInt())).thenReturn(tailleRandom);

        Case caseTrouvee = monde.getCaseVideAliatoire(alea);

        assertTrue(caseTrouvee.getPositionX() == tailleRandom + 1 && caseTrouvee.getPositionY() == tailleRandom + 1);

    }
    /*
    @Ignore
    @Test
    public void toutesCasesPleines_renvoi_vrai_si_toutes_cases_pleines(){
        Case c = new Case(1,1);
        c.setVide(false);
        ArrayList alCasesPrefait = new ArrayList();
        alCasesPrefait.add(c);
        ArrayList alCases = monde.getCases(); 
        alCases = alCasesPrefait;
        assertTrue(monde.toutesCasesPleines());
    }
   
     @Ignore   
    @Test
    public void toutesCasesPleines_renvoi_faux_si_pas_toutes_cases_pleines(){
        assertFalse(monde.toutesCasesPleines());
    }    */
}
