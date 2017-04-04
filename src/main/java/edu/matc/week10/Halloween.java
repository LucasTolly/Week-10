package edu.matc.week10;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by tolly on 4/3/2017.
 */
public class Halloween {
    private final Logger logger = Logger.getLogger(this.getClass());

    int lineMaxLimit;
    List<TrickOrTreater> listTrickOrTreater;

    public Halloween() {
        lineMaxLimit = 3;
        listTrickOrTreater = new LinkedList<TrickOrTreater>();
    }

    public void handOutCandy() {
        TrickOrTreater trickOrTreater;
        logger.info("Riley is watching TV");
        synchronized (listTrickOrTreater) {

            while(listTrickOrTreater.size()==0) {
                try {
                    listTrickOrTreater.wait();
                }
                catch(InterruptedException iex) {
                    iex.printStackTrace();
                }
            }
            logger.info("Riley saw that there is a trick-or-treater");
            trickOrTreater = (TrickOrTreater)((LinkedList<?>)listTrickOrTreater).poll();
        }
        long duration=0;
        try {
            logger.info("Handing out candy to " + trickOrTreater.getName());
            duration = (long)(Math.random()*10);
            TimeUnit.SECONDS.sleep(duration);
        } catch(InterruptedException iex) {
            iex.printStackTrace();
        }
        logger.info("Finished handing out candy to "+trickOrTreater.getName() + " in "+duration+ " seconds.");
    }

    public void add(TrickOrTreater trickOrTreater) {
        logger.info("TrickOrTreater : "+trickOrTreater.getName()+ " entering the line at "+trickOrTreater.getInTime());

        synchronized (listTrickOrTreater) {
            if(listTrickOrTreater.size() == lineMaxLimit) {
                logger.info("The line is too long for " + trickOrTreater.getName());
                logger.info(trickOrTreater.getName()+" has walked away...");
                return ;
            }

            ((LinkedList<TrickOrTreater>)listTrickOrTreater).offer(trickOrTreater);
            logger.info(trickOrTreater.getName() + " is in line waiting for candy.");

            if(listTrickOrTreater.size()==1)
                listTrickOrTreater.notify();
        }
    }
}
