package states;

public enum State {
    HEALTHY("healthy"), INFECTED("infected"),
    CONTAGIOUS("contagious"), RECOVERING("recovering"), DEAD("dead");

    private String state = "";
    
    State(String state){
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
}