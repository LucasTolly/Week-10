package edu.matc.week10;

/**
 * Created by tolly on 4/3/2017.
 */
public class HalloweenSimulation {

    public static void main(String inputs[]) {
        Halloween halloween = new Halloween();

        Riley riley = new Riley(halloween);
        TrickOrTreaterGenerator trickOrTreaterGenerator = new TrickOrTreaterGenerator(halloween);

        Thread thriley = new Thread(riley);
        Thread thcg = new Thread(trickOrTreaterGenerator);
        thcg.start();
        thriley.start();
    }
}
