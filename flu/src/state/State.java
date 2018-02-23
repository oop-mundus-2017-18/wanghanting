package state;

public enum State {
    HEALTHY("Healthy"), INFECTED("Infected"), SICK("Sick"),
    CONTAGIOUS("Contagious"), RECOVERING("Recovering"), DEAD("Dead");
    
    private final String state;
    
    State(String state){
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
}
