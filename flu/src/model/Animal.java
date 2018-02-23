package model;

import state.State;
import virus.Virus;

public class Animal {
    State state;
    Virus virus;
    //wanghan
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
        return "Animal: "+virus.getVirusName();
    }
    
}
