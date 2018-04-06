package model;

import states.*;
import virus.*;
import simulator.*;

/**
 * @author WANG Hanting
 * @version 1.0
 */
public abstract class LivingBeings {
    protected State state;
    protected Being type;
    protected Virus virus;
    protected boolean alive;
    protected Field field;

    public LivingBeings(State state, Being type, Virus virus, boolean alive, Field field) {
        this.state = state;
        this.type = type;
        this.virus = null;
        this.alive = true;
        this.field = field;
    }

    /**
     * Make this animal act - that is: make it do
     * whatever it wants/needs to do.
     */
    abstract public void act();

    /**
     * Return the animal's state
     * @return the animal's state
     */
    public State getState() {
        return state;
    }
    
    /**
     * Return the type
     * @return the type
     */
    public Being getType() {
        return type;
    }
    
    /**
     * Return the virus
     * @return the virus
     */
    public Virus getVirus() {
        return virus;
    }

    /**
     * Check whether the animal is alive or not.
     * @return true if the animal is still alive.
     */
    public boolean isAlive()
    {
        return alive;
    }

}