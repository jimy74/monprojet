package ch.hesge.paris.marmotte;
import java.util.Random;
import org.junit.Ignore;
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
        assertNotNull(monde.getCaseVideAliatoire());
    }

    @Ignore
      @Test
    public void getCaseVideAliatoire_renvoi_la_case_qui_est_au_x_et_y_aleatoire() { 
        Monde p_monde = mock(Monde.class);
        Random alea = mock(Random.class);
        
        int tailleRandom = 3; //je fige l'entrée de la méthode testée, "si non comment tester l'aléatoire/l'imprévisible"
        when(alea.nextInt()).thenReturn(3); 
        
        Case caseTrouvee = p_monde.getCaseVideAliatoire();
        
        System.out.println(caseTrouvee.getPositionX());
        System.out.println(caseTrouvee.getPositionY());
        
        Case caseTrouvee2 = p_monde.getCaseVideAliatoire();
        
        System.out.println(caseTrouvee2.getPositionX());
        System.out.println(caseTrouvee2.getPositionY());        
        
        assertTrue(caseTrouvee.getPositionX() == tailleRandom && caseTrouvee.getPositionY() == tailleRandom);
    }
}    
