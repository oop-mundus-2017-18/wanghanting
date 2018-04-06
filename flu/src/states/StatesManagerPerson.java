package states;


import model.*;
import virus.*;
import simulator.*;
import java.util.Random;

/**
 * @author WANG Hanting
 * @author Gabriela Cavalcante
 * @created 06/04/18.
 */
public class StatesManagerPerson extends StatesManager {

    public StatesManagerPerson(State stateType, Field field, Location location) {
        super(stateType, field, location);
    }

    @Override
    State analyseStateContagious(Virus virus, int timeContagious) {
        return null;
    }

    @Override
    public State getState(boolean healthyPerson, Virus virus, int timeInfection, int timeContagious, int timeRecover) {
        if (currentState.equals(State.HEALTHY)) {
            currentState = analyseStateHealthy();
        } else if (currentState.equals(State.INFECTED)) {
            currentState = analyseStateSick(virus, timeInfection);
        } else if (currentState.equals(State.CONTAGIOUS)) {
            currentState = analyseStateContagious(healthyPerson, virus, timeContagious);
        } else if (currentState.equals(State.RECOVERING)) {
            currentState = analyseStateRecover(virus, timeRecover);
        }
        return currentState;
    }

    @Override
    public State analyseStateSick(Virus virus, int timeInfection) {
        if (timeInfection >= virus.getIncubation())
            return State.CONTAGIOUS;
        return State.INFECTED;
    }

    private State analyseStateRecover(Virus virus, int timeRecover) {
        if (timeRecover == virus.getRecover())
            return State.HEALTHY;
        return State.RECOVERING;
    }

    @Override
    State analyseStateContagious(boolean healthyPerson, Virus virus, int timeContagious) {
        Random rand = Randomizer.getRandom();
        if (timeContagious == virus.getContagious()) {
            if (rand.nextDouble() <= virus.getMortality() && !healthyPerson)
                return State.DEAD;
            else
                return State.RECOVERING;
        }
        return State.CONTAGIOUS;
    }

    @Override
    public State getState(Virus virus, int timeInfection, int timeContagious) {
        return null;
    }

    @Override
    State analyseStateHealthy() {
        for (Location loc : field.adjacentLocations(location)) {
            LivingBeings beings = (LivingBeings) field.getObjectAt(loc);
            Random rand = Randomizer.getRandom();
            if (beings != null) {
                if (beings.getState().equals(State.CONTAGIOUS)) {
                    if(rand.nextDouble() <= beings.getVirus().getVirulence()){
                        currentVirus = beings.getVirus();
                        return State.INFECTED;
                    }
                } else if (beings.isResist()) {
                    return State.RECOVERING;
                }
            }
        }
        return State.HEALTHY;
    }

}