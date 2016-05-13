package ch.hesge.paris.marmotte;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;
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
    
}    
