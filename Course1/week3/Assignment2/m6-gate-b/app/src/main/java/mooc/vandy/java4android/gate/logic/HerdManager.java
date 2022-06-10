package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mWestGate;

    /**
     * The output Gate object.
     */
    private Gate mEastGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    /* Create a public static final int HERD to indicate the size of your escargatoire, which
        should be set to the constant value 24 for this simulation.
    */

    public static final int HERD = 24;


    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }

    //Gate[] herdArray = {mEastGate, mWestGate};

    // TODO -- Fill your code in here
    public void simulateHerd(Random rand) {
        int pen = HERD;
        int pasture = 0;
        int randomNumber = 0;
        mOut.println("There are currently " + pen + " snails in the pen and " + pasture + " snails in the pasture");
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            int count = 0;

            if (pen == 0) {
                randomNumber = rand.nextInt(pasture) + 1;
                count = mWestGate.thru(randomNumber);
                pen += count;

            } else if (pasture == 0) {
                randomNumber = rand.nextInt(pasture) + 1;
                count = mEastGate.thru(randomNumber);
                pen += count;
            }
            else {

                boolean bool = rand.nextBoolean();
                if(bool) {
                    randomNumber = rand.nextInt(pen)+1;
                    count = mEastGate.thru(randomNumber);
                    pen += count;
                }
                else {
                    randomNumber = rand.nextInt(pasture)+1;
                    count = mWestGate.thru(randomNumber);
                    pen += count;

                }
            }
            pasture = HERD - pen;
            mOut.println("There are currently " + pen + " snails in the pen and " + pasture + " snails in the pasture");
        }


    }
}