package model;

import states.State;
import virus.Virus;

public class Animal {
    State state;
    Virus virus;
 
    public Animal(State state, Virus virus) {
        this.state = state;
        this.virus = virus;
    }
    
    public void infect(Animal a) {
        
    }
    
    @Override
    public String toString(){
        return "Animal: "+state.getState();
    }
    
    public String getVirus() {
        return "Animal: "+virus.getName();
    }
    
}
