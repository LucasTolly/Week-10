package edu.matc.week10;

import org.apache.log4j.Logger;

/**
 * Created by tolly on 4/3/2017.
 */
public class Riley implements Runnable {
    private final Logger logger = Logger.getLogger(this.getClass());

    Halloween halloween;

    public Riley(Halloween halloween)
    {
        this.halloween = halloween;
    }
    public void run()
    {
        try {
            Thread.sleep(10000);
        }
        catch(InterruptedException iex) {
            logger.error(iex.getStackTrace());
        }
        logger.info("Riley started watching TV");
        while(true) {
            halloween.handOutCandy();
        }
    }
}
