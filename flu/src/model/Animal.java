package model;

import states.*;
import java.util.Random;
import simulator.*;

public abstract class Animal extends LivingBeings {
    private int timeInfection;
    private int timeContagious;
    StatesManager statesManager;

    public Animal(State state, Being type, Field field, Location location) {
        super(State.INFECTED, type, field, location);
    
    Random rand = Randomizer.getRandom();
    if (rand.nextBoolean()) this.state = State.INFECTED;
    else this.state = State.HEALTHY;

    this.field = field;
    this.statesManager = new StatesManagerAnimal(this.state, type, field, location);
    }

    @Override
    public String toString(){
        return "Animal: "+state.getState();
    }
    
    @Override
    public void act() {
        if (isAlive()) {
            updateTime();
            this.state = statesManager.getState(virus, timeInfection, timeContagious);
            if (state.equals(State.DEAD)) {
                setDead();
            }
        }
    }

    /**
     * Update the time of Infection or Contagious.
     */
    @Override
    protected void updateTime() {
        if (state.equals(State.INFECTED))
            timeInfection++;
        else if (state.equals(State.CONTAGIOUS))
            timeContagious++;
    }

    @Override
    public boolean isResist() {
        return false;
    }
}
