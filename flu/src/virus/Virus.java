package virus;

public abstract class Virus {
    protected TypeVirus name; // The name of Virus
    protected double virulence; // of the virus
    protected double mortality; // To verify if a person will recover from the illness or die
    protected int incubation;
    protected int contagious;
    protected int recover;

    public double getVirulence() {
        return virulence;
        }
    
    public double getMortality() {
        return mortality;
        }
    
    public TypeVirus getName() {
        return name;
        }
    
    public int getIncubation() {
        return incubation;
        }
    
    public int getContagious() {
        return contagious;
        }
    
    public int getRecover() {
        return recover;
        }
}