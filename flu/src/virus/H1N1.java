package virus;

public class H1N1 extends Virus {

    public H1N1() {
        this.name = TypeVirus.H1N1;
        this.virulence = 0.2;
        this.mortality = 0.1;
        }
    }

//class TestH1N1{
//    public static void main(String [] args) {
//    H1N1 h = new H1N1();
//    System.out.println(h.getName());
//    }
//}