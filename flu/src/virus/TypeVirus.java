package virus;

public enum TypeVirus {
    H1N1(0.2, 0.1, "H1N1"), H5N1(0.4, 0.33, "H5N1");
// These viruses are to eliminate randomness -
//  for testing only.
//    MINI4TESTING(0, 0), MAXI4TESTING(1, 1);

    private double virulence;
    private double mortality;
    private String name = "";

    TypeVirus(double virulence, double mortality, String name) {
        this.virulence = virulence;
        this.mortality = mortality;
        this.name = name;
    }

    double virulence() {
        return virulence;
    }

    double mortality() {
        return mortality;
    }
}
