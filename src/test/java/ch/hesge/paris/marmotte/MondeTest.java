package ch.hesge.paris.marmotte;
import java.util.Random;
import org.junit.Ignore;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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
        
        Case caseTrouvee2 = monde.getCaseVideAliatoire(alea);              
        
        assertTrue(caseTrouvee.getPositionX() == tailleRandom+1 && caseTrouvee.getPositionY() == tailleRandom+1);
             
    }
}    
