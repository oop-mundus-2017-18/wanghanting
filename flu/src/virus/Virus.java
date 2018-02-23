package virus;

public abstract class Virus {
    protected String name = ""; // The name of Virus
    protected int incubationTime; // Time, in days, that the individual is sick, but not contagious.
    protected int contagiousTime; // Time, in days, that the individual is contagious
    protected int recoverTime; // Time, in days, that the individual is recovering
    protected double infectionRate; // of the virus
    protected double mortalityRate; // To verify if a person will recover from the illness or die
    
    Virus(String name) {
        this.name = name;
        }
    
    public String getVirusName() {
        return name;
        }
    
    public double getInfectionRate() {
        return infectionRate;
        }

    public double getMortalityRate() {
        return mortalityRate;
        }

    public int getIncubationTime() {
        return incubationTime;
        }

    public int getContagiousTime() {
        return contagiousTime;
        }

    public int getRecoverTime() {
        return recoverTime;
        }
}
