package states;

public enum State {
    HEALTHY("healthy"), INFECTED("infected");

    private String state = "";
    
    State(String state){
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
}