
import ch.hesge.paris.marmotte.JeuMarmotteHunter;
import ch.hesge.paris.marmotte.Monde;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class JeuMarmotteHunterTest {

@BeforeMethod
public void setUp() {
    JeuMarmotteHunter.lancerTimer();
}

@DataProvider(name = "data")
public Object[][] data() {

Object[][] data = new Object[3][1];
data[0] = new Object[] {0};
data[0] = new Object[] {-1};
data[0] = new Object[] {1};

return data;

}

    @Test(dataProvider = "data")
    public void perdUnPoint_fonctionne_si_score_plus_grand_que_0(int score) {
        int scoreTest = JeuMarmotteHunter.perdUnPoint(score);
        assertTrue(score > 0 && scoreTest == score-1);
    }
    public void perdUnPoint_retourne_score_si_il_est_de_0_ou_moins(int score) {
        int scoreTest = JeuMarmotteHunter.perdUnPoint(score);
        assertTrue(score <= 0 && score == scoreTest);
    }    
}    
