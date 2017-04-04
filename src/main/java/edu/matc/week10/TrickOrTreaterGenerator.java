package edu.matc.week10;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by tolly on 4/3/2017.
 */
public class TrickOrTreaterGenerator implements Runnable {
    private final Logger logger = Logger.getLogger(this.getClass());

    Halloween halloween;

    public TrickOrTreaterGenerator(Halloween halloween)
    {
        this.halloween = halloween;
    }

    public void run()
    {
        while(true)
        {
            TrickOrTreater trickOrTreater = new TrickOrTreater(halloween);
            trickOrTreater.setInTime(new Date());
            Thread thTrickOrTreater = new Thread(trickOrTreater);
            trickOrTreater.setName("TrickOrTreater "+thTrickOrTreater.getId());
            thTrickOrTreater.start();

            try {
                TimeUnit.SECONDS.sleep((long)(Math.random()*10));
            } catch(InterruptedException iex) {
                logger.error(iex.getStackTrace());
            }
        }
    }
}
