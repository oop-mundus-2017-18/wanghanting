package virus;

public class H5N1 extends Virus {

    public H5N1() {
        this.name = TypeVirus.H5N1;
        this.virulence = 0.4;
        this.mortality = 0.33;
        this.incubation = 2;
        this.contagious = 2;
        this.recover = 3;
        }
    }