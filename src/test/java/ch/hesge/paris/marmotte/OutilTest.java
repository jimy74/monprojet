package ch.hesge.paris.marmotte;

import javax.swing.ImageIcon;
import org.testng.Assert;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class OutilTest {

    private Outil outil;

    @BeforeMethod
    public void setUp() {
        outil = new Outil();
    }
    
    @DataProvider(name = "dataAbs")
    public Object[][] dataAbs() {

        Object[][] dataAbs = new Object[5][2];
        dataAbs[0] = new Object[]{0, 0};
        dataAbs[1] = new Object[]{-1, 1};
        dataAbs[2] = new Object[]{1, 1};
        dataAbs[3] = new Object[]{2, 2};
        dataAbs[4] = new Object[]{-2, 2};
        return dataAbs;
    }
    
    @Test(dataProvider = "dataAbs")
    public void absTest(int in, int out) {
        assertTrue(outil.abs(in) == out);
    }
    
    @DataProvider(name = "dataSoustraction")
    public Object[][] dataSoustraction() {

        Object[][] dataSoustraction = new Object[4][3];
        dataSoustraction[0] = new Object[]{0, 0, 0};
        dataSoustraction[1] = new Object[]{1, 1, 0};
        dataSoustraction[2] = new Object[]{0, 1, -1};
        dataSoustraction[3] = new Object[]{1, 0, 1};

        return dataSoustraction;
    }

    @Test(dataProvider = "dataSoustraction")
    public void soustractionTest(int inA, int inB, int out) {
        assertTrue(outil.soustraction(inA, inB) == out);
    }
}
