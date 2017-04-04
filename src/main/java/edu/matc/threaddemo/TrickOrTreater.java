package edu.matc.threaddemo;

import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Created by tolly on 4/3/2017.
 */
public class TrickOrTreater implements Runnable {
    private final Logger logger = Logger.getLogger(this.getClass());

    String name;
    Date inTime;

    Halloween halloween;

    public TrickOrTreater(Halloween halloween)
    {
        this.halloween = halloween;
    }

    public String getName() {
        return name;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public void run()
    {
        getInCandyLine();
    }
    private synchronized void getInCandyLine()
    {
        halloween.add(this);
    }
}
