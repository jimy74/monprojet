package ch.hesge.paris.marmotte;

import java.util.ArrayList;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class JeuMarmotteHunterTest {

    private JeuMarmotteHunter jeu;

    @BeforeClass
    public void setUpGlobal() {
        
    }

    @BeforeMethod
    public void setUp() {
        Parametres p = new Parametres();
        jeu = new JeuMarmotteHunter(p,
                new Monde(p.getMondeTailleX(), p.getMondeTailleY()),
                new TimerPerso(p.getVitesseDifficulteEmperique(), p.getVitesseDifficulte()));
    }

    @DataProvider(name = "data")
    public Object[][] data() {

        Object[][] data = new Object[9][1];
        data[0] = new Object[]{0};
        data[1] = new Object[]{1};
        data[2] = new Object[]{2};
        data[3] = new Object[]{3};
        data[4] = new Object[]{1000000};
        data[5] = new Object[]{-1};
        data[6] = new Object[]{-2};
        data[7] = new Object[]{-3};
        data[8] = new Object[]{-1000000};

        return data;

    }

    @Test(dataProvider = "data")
    public void perdUnPoint_fonctionne_si_score_plus_grand_que_0(int score) {
        int scoreTest = jeu.perdUnPoint(score);
        if (score > 0) {
            assertTrue(scoreTest == score - 1);
        }
    }

    @Test(dataProvider = "data")
    public void perdUnPoint_arret_a_0(int score) {
        int scoreTest = jeu.perdUnPoint(score);
            assertTrue(scoreTest >= 0);
    }

    @Test(dataProvider = "data")
    public void perdUnPoint_stop_timer_si_0_ou_moins(int score) {
        jeu.perdUnPoint(score);
        if (score <= 0) {
            assertFalse(jeu.getTimer().isMarche());
        }
    }

    @Test(dataProvider = "data")
    public void perdUnPoint_contenu_timer_si_plus_que_0(int score) {
        int scoreTest = jeu.perdUnPoint(score);
        if (scoreTest > 0) {
            assertTrue(jeu.getTimer().isMarche());
        }
    }

    @Test
    public void ajouterEtDeplacerMarmotteAlea_ajoute_une_marmotte_si_place() {
        int nbMarmottesAvant = jeu.getTimer().getMarmottes().size();
        int nbMarmottesMax = jeu.getMonde().getTailleX() * jeu.getMonde().getTailleY();
        jeu.ajouterEtDeplacerMarmotteAlea();
        int nbMarmottesApres = jeu.getTimer().getMarmottes().size();
        assertTrue(nbMarmottesAvant < nbMarmottesApres || nbMarmottesAvant == nbMarmottesMax);
    }

    @Test
    public void ajouterEtDeplacerMarmotteAlea_deplace_une_marmotte_si_place() {
        int nbMarmottesAvant = jeu.getTimer().getMarmottes().size();
        int nbMarmottesMax = jeu.getMonde().getTailleX() * jeu.getMonde().getTailleY();

        ArrayList<String> alPositionsAvant = new ArrayList<String>();
        for (Marmotte m : jeu.getTimer().getMarmottes()) {
            alPositionsAvant.add(m.getMaCase().getPositionX() + "" + m.getMaCase().getPositionY());
        }
        jeu.ajouterEtDeplacerMarmotteAlea();
        ArrayList<String> alPositionsApres = new ArrayList<String>();
        for (Marmotte m : jeu.getTimer().getMarmottes()) {
            alPositionsApres.add(m.getMaCase().getPositionX() + "" + m.getMaCase().getPositionY());
        }

        assertTrue(!alPositionsAvant.equals(alPositionsApres) || nbMarmottesAvant == nbMarmottesMax);
    }
    
    @Test
    public void ajouterEtDeplacerMarmotteAlea_reduit_score_si_plus_grand_que_0_et_monde_rempli() {
        
        int nbMarmottesAvant = jeu.getTimer().getMarmottes().size();
        int nbMarmottesMax = jeu.getMonde().getTailleX() * jeu.getMonde().getTailleY();
        
        int ancienScore = jeu.getParametres().getScore();
        
        jeu.ajouterEtDeplacerMarmotteAlea();
        if (ancienScore > 0 && nbMarmottesAvant == nbMarmottesMax)
            assertTrue(ancienScore < jeu.getParametres().getScore());
            

        
    }    
}
