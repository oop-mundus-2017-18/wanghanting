package states;

import simulator.*;
import virus.*;

public abstract class StatesManager {
    protected State currentState;
    protected Field field;
    protected Location location;
    protected Virus currentVirus;

    protected StatesManager(State stateType, Field field, Location location) {
        currentState = stateType;
        this.field = field;
        this.location = location;
    }

    abstract State analyseStateContagious(Virus virus, int timeContagious);

    abstract State analyseStateContagious(boolean healthyPerson, Virus virus, int timeContagious);

    public abstract State getState(Virus virus, int timeInfection, int timeContagious);

    public abstract State getState(boolean healthyPerson, Virus virus, int timeInfection, int timeContagious, int timeRecover);

    public abstract State analyseStateSick(Virus virus, int timeInfection);

    abstract State analyseStateHealthy();

    public Virus getCurrentVirus() {
        return currentVirus;
    }
}