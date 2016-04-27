package ch.hesge.paris.marmotte;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.BeforeMethod;

public class MondeTest {
    
private JeuMarmotteHunter jeu;

@BeforeMethod
public void setUp() {
    jeu = new JeuMarmotteHunter();
}
    @Test
    public void getCaseVideAliatoire_retourne_une_case_vraiment_vide() {
        Monde monde = jeu.getMonde();
        assertNotNull(monde.getCaseVideAliatoire());
    }
    
}    
