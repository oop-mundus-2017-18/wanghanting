package model;

import state.State;
import virus.Virus;

public class Person {
    State state;
    Virus virus;
    
    public Person(State state, Virus virus) {
        this.state = state;
        this.virus = virus;
    }
    
    public void infect(Person p) {
        
    }
    
    @Override
    public String toString(){
        return "Person: "+state.getState();
    }
    
    public String getVirus() {
        return "Person: "+virus.getVirusName();
    }
    
}
