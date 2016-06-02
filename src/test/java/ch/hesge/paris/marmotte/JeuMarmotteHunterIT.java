/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hesge.paris.marmotte;

import java.util.ArrayList;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Paris
 */
public class JeuMarmotteHunterIT {

    private JeuMarmotteHunter jeu;
    private Parametres p;

    @BeforeMethod
    public void setUp() {
        p = new Parametres();
        jeu = new JeuMarmotteHunter(p,
                new TimerPerso(new Monde(p.getMondeTailleX(), p.getMondeTailleY()),
                        p.getVitesseDifficulteEmperique(),
                        p.getVitesseDifficulte()
                )
        );
    }

    @Test
    public void ajouterEtDeplacerMarmotteAlea_deplace_une_marmotte_si_place() {

        int nbMarmottesAvant = jeu.getTimer().getMarmottes().size();
        int nbMarmottesMax = jeu.getMonde().getTailleX() * jeu.getMonde().getTailleY();

        ArrayList<String> alPositionsAvant = new ArrayList<String>();
        for (Marmotte m : jeu.getTimer().getMarmottes()) {
            alPositionsAvant.add(m.getMaCase().getPositionX() + "" + m.getMaCase().getPositionY());
        }
        jeu.ajouterEtDeplacerMarmotteAlea(jeu.getTimer());
        ArrayList<String> alPositionsApres = new ArrayList<String>();
        for (Marmotte m : jeu.getTimer().getMarmottes()) {
            alPositionsApres.add(m.getMaCase().getPositionX() + "" + m.getMaCase().getPositionY());
        }

        assertTrue(!alPositionsAvant.equals(alPositionsApres) || nbMarmottesAvant == nbMarmottesMax || nbMarmottesAvant <= 0);
    }

    @Test
    public void ajouterEtDeplacerMarmotteAlea_reduit_score_si_plus_grand_que_0_et_monde_rempli() {

        int nbMarmottesAvant = jeu.getTimer().getMarmottes().size();
        int nbMarmottesMax = jeu.getMonde().getTailleX() * jeu.getMonde().getTailleY();

        int ancienScore = jeu.getParametres().getScore();

        jeu.ajouterEtDeplacerMarmotteAlea(jeu.getTimer());
        if (ancienScore > 0 && nbMarmottesAvant == nbMarmottesMax) {
            assertTrue(ancienScore < jeu.getParametres().getScore());
        }
    }
}
