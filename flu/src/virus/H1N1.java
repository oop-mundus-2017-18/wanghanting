package virus;

public class H1N1 extends Virus {

    H1N1() {
        super("H1N1");
    this.incubationTime = 1;
    this.recoverTime = 3;
    this.contagiousTime = 5;
    this.mortalityRate = 0.60;
    this.infectionRate = 0.75;
    }
}

//class TestH1N1{
//    public static void main(String [] args) {
//    H1N1 h = new H1N1();
//    System.out.println(h.getVirusName());
//    }
//}