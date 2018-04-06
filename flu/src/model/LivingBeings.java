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
    protected Location location;

    public LivingBeings(State state, Being type, Field field, Location location) {
        this.state = state;
        this.type = type;
        this.field = field;
        this.location = location;
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
    
    protected void setDead() {
        alive = false;
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }
    
    protected Location getLocation() {
        return location;
    }
    
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    
    protected Field getField() {
        return field;
    }
    
    
    
    abstract protected void updateTime();
    
    public abstract boolean isResist();
    
    public void setResist(boolean resistant) {
        
    }
}