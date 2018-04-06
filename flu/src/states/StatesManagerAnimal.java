package states;

import model.*;
import virus.*;
import simulator.*;
import java.util.Random;

/**
 * @author WANG Hanting
 * @author Gabriela Cavalcante
 * @version 06/04/2018
 */
public class StatesManagerAnimal extends StatesManager {
    private Being animalType;

    public StatesManagerAnimal(State stateType, Being animal, Field field, Location location) {
        super(stateType, field, location);
        this.animalType = animal;
    }

    @Override
    public State getState(Virus virus, int timeInfection, int timeContagious) {
        if (currentState.equals(State.HEALTHY)) {
            currentState = analyseStateHealthy();
        } else if (currentState.equals(State.INFECTED)) {
            currentState = analyseStateSick(virus, timeInfection);
        } else if (currentState.equals(State.CONTAGIOUS)) {
            currentState = analyseStateContagious(virus, timeContagious);
        }
        return currentState;
    }

    @Override
    public State getState(boolean healthyPerson, Virus virus, int timeInfection, int timeContagious, int timeRecover) {
        return null;
    }

    @Override
    public State analyseStateSick(Virus virus, int timeInfection) {
        if (timeInfection >= virus.getIncubation())
            return State.CONTAGIOUS;
        return State.INFECTED;
    }

    @Override
    State analyseStateContagious(Virus virus, int timeContagious) {
        if (timeContagious == virus.getContagious())
            return State.DEAD;
        return State.CONTAGIOUS;
    }

    @Override
    State analyseStateContagious(boolean healthyPerson, Virus virus, int timeContagious) {
        return null;
    }

    @Override
    State analyseStateHealthy() {
        for (Location loc : field.adjacentLocations(location)) {
            LivingBeings beings = (LivingBeings) field.getObjectAt(loc);
            Random rand = Randomizer.getRandom();
            if (beings != null && beings.getState().equals(State.CONTAGIOUS) && rand.nextDouble() <= beings.getVirus().getVirulence()) {
                if (animalType.isEquals(beings.getType())){
                    currentVirus = beings.getVirus();
                    return State.INFECTED;
                }
                else if((animalType.isEquals(Being.DUCK) && beings.getType().isEquals(Being.CHICKEN)) ||
                        (animalType.isEquals(Being.CHICKEN) && beings.getType().isEquals(Being.DUCK))){
                    currentVirus = beings.getVirus();
                    return State.INFECTED;
                }
            }
        }
        return State.HEALTHY;
    }
}