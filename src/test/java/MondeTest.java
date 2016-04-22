
import ch.hesge.paris.marmotte.JeuMarmotteHunter;
import ch.hesge.paris.marmotte.Monde;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.BeforeMethod;

public class MondeTest {
    
@BeforeMethod
public void setUp() {
    JeuMarmotteHunter.getParametres().setMondeTailleX(3);
    JeuMarmotteHunter.getParametres().setMondeTailleY(3);  
}
    @Test
    public void getCaseVideAliatoire_retourne_une_caseVide_pas_remplit() {
        Monde monde = new Monde(JeuMarmotteHunter.getParametres().getMondeTailleX(),JeuMarmotteHunter.getParametres().getMondeTailleY());
        assertNotNull(monde.getCaseVideAliatoire());
    }
}    
